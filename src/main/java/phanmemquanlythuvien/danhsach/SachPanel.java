/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.danhsach;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.chitiet.SachCT1;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.ChiTietMuonTraDao;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.MuonTraDao;
import phanmemquanlythuvien.dao.SachDao;
import phanmemquanlythuvien.dto.ChiTietMuonTra;
import phanmemquanlythuvien.dto.DauSach;
import phanmemquanlythuvien.dto.MuonTra;
import phanmemquanlythuvien.dto.Sach;
import phanmemquanlythuvien.enums.Quyen;
import phanmemquanlythuvien.enums.TrangThaiSach;
import phanmemquanlythuvien.form.MuonForm;
import phanmemquanlythuvien.form.SachForm;
import phanmemquanlythuvien.form.TraForm;

/**
 *
 * @author tainguyen
 */
public class SachPanel extends SubPanel{
    List<Sach> allSach;

    DauSachDao dausachDao = App.ctx.getBean(DauSachDao.class);  
    
    private static final Logger LOGGER = Logger.getLogger(SachForm.class); 
    
    String[] header = new String[] {"Tên Sách","Trạng Thái"};

    public SachPanel(){
        txtLabel.setText("Quản lý sách");
        quyenThem = Quyen.THEM_SACH;
        quyenXem = Quyen.XEM_SACH;
        quyenXoa = Quyen.XOA_SACH;
        tabName = "Sách";
        
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
    }
    
    @Override
    public void showHideButton(){
        //check permission
        btnThem.setVisible(canWrite());
        btnSua.setVisible(canWrite());
        btnXoa.setVisible(canDelete());
        btnMuon.setVisible(false);
    }
    
    public static SachPanel create(){
        return new SachPanel();
    }    
    
    public Object[] data2Array(Sach item){
        return new Object[]{
            item,
            item.getTrangThaiEnum()
        };
    }
    
      
    @Override
    public void showData(){
        this.showData(null);
    }
    
    @Override
    public void tim(){
        showData(txtTim.getText().toLowerCase());
    }
    
    public void showData(String filterValue){

        SachDao sD = App.ctx.getBean(SachDao.class);
        allSach = sD.findAll();
        
        Object[][] data;
        
        String[] arrSearchValue = filterValue != null ? filterValue.split(" ") :  new String[0];
         
        data = allSach.stream()
            .filter(s -> s.isMatch(arrSearchValue))
            .map(s -> data2Array(s))
            .toArray(size -> new Object[size][]);
        
        table.setModel(new DefaultTableModel(data, header));
        
    }
    
    @Override
    public void them(){
        sua(new Sach());
    }
    
    @Override
    public void muon(){
        if(checkSelectedRow() == false)
            return;
        Sach sach = getSelected();
        if(sach.isReady()){
            MuonForm form = MuonForm.getInstance();
            form.addSach(sach);
            form.setVisible(true);
            form.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    showData();
                }
            });              
        } else {
            ChiTietMuonTraDao chitietDao = App.ctx.getBean(ChiTietMuonTraDao.class);
            LOGGER.info("TEST: "+chitietDao.findBySachId(sach.getMaSach()).getTieuDe());
           
            ChiTietMuonTra chitiet = chitietDao.findBySachId(sach.getMaSach());
            
           // chitietDao.findById(sach.getMaSach()).equals(chitiet.getNgayTra() != null);
            MuonTra muon = App.ctx.getBean(MuonTraDao.class).findById(chitiet.getMaMT());
            TraForm form = new TraForm(muon);
            form.setVisible(true);
            form.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    showData();
                }
            });        
        }
    }    
    
    @Override
    public void sua() {
        if(checkSelectedRow() == false)
            return;
        if(!canWrite()) return;
        SachDao sD = App.ctx.getBean(SachDao.class);
        Sach selectedSach = sD.findById(getSelected().getMaSach());
        DauSach selectedDauSach = dausachDao.findById(selectedSach.getMaDS());
        int soluong;
        switch (selectedSach.getTrangThaiEnum()) {
            case SAN_SANG:
                selectedSach.setTrangThai(TrangThaiSach.KHOA);
                break;
            case KHOA:
                selectedSach.setTrangThai(TrangThaiSach.SAN_SANG);
                break;
            default:
                btnSua.setVisible(false);
                return;
        }
        
        sD.save(selectedSach);
        soluong = (int) sD.countDS(selectedSach.getMaDS(), TrangThaiSach.SAN_SANG.ordinal());
        selectedDauSach.setSoLuong(soluong);
        dausachDao.save(selectedDauSach);
        showData();
    }
    
    public Sach getSelected(){
        return (Sach) table.getModel().getValueAt(table.getSelectedRow(),0);
    }       
    
    public void sua(Sach sach){
        SachForm form = new SachForm();
        form.setVisible(true);
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                showData();
            }
        });
    }
    
    public TrangThaiSach getSelectedTrangThai(){
        return (TrangThaiSach) table.getModel().getValueAt(table.getSelectedRow(),1);
    }
    
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                   
        TrangThaiSach trangThai = getSelectedTrangThai();
        
        switch (trangThai) {
            case SAN_SANG:
                btnSua.setVisible(canWrite());
                btnSua.setText("Khóa");
                break;
            case KHOA:
                btnSua.setVisible(canWrite());
                btnSua.setText("Mở Khóa");
                break;
            default:
                btnSua.setVisible(false);
                break;
        }
        
        switch (trangThai) {
            case SAN_SANG:
                btnMuon.setVisible(Quyen.MUON.kiemTra(App.activeUser));
                btnMuon.setText("Mượn");
                break;
            case CHO_MUON:
                btnMuon.setVisible(Quyen.MUON.kiemTra(App.activeUser));
                btnMuon.setText("Trả");
                break;
            default:
                btnMuon.setVisible(false);
                break;
        }
    } 
      @Override
    public void chiTiet() {
        if(checkSelectedRow() == false)
            return;
       SachDao tgB = App.ctx.getBean(SachDao.class);
       chiTiet(getSelected());
    }
    
    public void chiTiet(Sach sach){
        SachCT1 form = new SachCT1(sach);
        form.setVisible(true);
        //check if dispose
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                showData();
            }
        });
    }
        
}
