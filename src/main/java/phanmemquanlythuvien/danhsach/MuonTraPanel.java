/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.danhsach;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.BanDocDao;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.MuonTraDao;
import phanmemquanlythuvien.dao.SachDao;
import phanmemquanlythuvien.dto.MuonTra;
import phanmemquanlythuvien.enums.Quyen;
import phanmemquanlythuvien.form.MuonForm;
import phanmemquanlythuvien.form.TraForm;

/**
 *
 * @author tainguyen
 */
public class MuonTraPanel extends SubPanel {

    List<MuonTra> allMuonTra;

    private static final Logger LOGGER = Logger.getLogger(TaiKhoanPanel.class);
    
    BanDocDao bandocDao = App.ctx.getBean(BanDocDao.class);
    SachDao sachDao = App.ctx.getBean(SachDao.class);
    DauSachDao dausachDao = App.ctx.getBean(DauSachDao.class);
    
    String[] header = new String[] {"Mã Mượn Trả","Bạn Đọc","Ngày Mượn","Ngày Phải Trả","Trạng Thái"}; 
    
    public MuonTraPanel(){
        txtLabel.setText("Quản lý mượn trả");
        quyenThem = Quyen.THEM_MUON_SACH;
        quyenXem = Quyen.XEM_MUON_SACH;
        quyenXoa = Quyen.XOA_MUON_SACH;
        tabName = "Mượn Trả";
    }
    
    @Override
    public void showHideButton(){
        //check permission
        btnThem.setVisible(canWrite());
        btnSua.setVisible(canWrite());
        btnXoa.setVisible(canDelete());
        btnMuon.setVisible(Quyen.MUON.kiemTra(App.activeUser));
        btnMuon.setText("Phạt");
        btnSua.setVisible(false);
        btnMuon.setVisible(false);
        btnThem.setVisible(false);
    }
    
    public static MuonTraPanel create(){
        return new MuonTraPanel();
    }
   
    public Object[] data2Array(MuonTra item){
        return new Object[]{
            item.getMaMT(),
            "#"+String.format("%05d", item.getMaBD()) +" "+ bandocDao.getTenBanDoc(item.getMaBD()),
            item.getNgayMuon(),
            item.getNgayPhaiTra(),
            item.getDaTraHet() ? "Đã trả hết" : "Chưa trả"
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

        MuonTraDao mtD = App.ctx.getBean(MuonTraDao.class);
        allMuonTra = mtD.findAll();
        Object[][] data;
        data = allMuonTra.stream()
            .filter(mt -> filterValue == null 
                    || bandocDao.getTenBanDoc(mt.getMaBD()).toLowerCase().contains(filterValue)
                    || mt.getMaBD().toString().contains(filterValue))
            .map(mt -> data2Array(mt))
            .toArray(size -> new Object[size][]);
        
        table.setModel(new DefaultTableModel(data, header));
    }
    
    @Override
    public void them(){
        sua(new MuonTra());
    }
    
    @Override
    public void sua() {
        if(checkSelectedRow() == false)
            return;
        MuonTraDao mtD = App.ctx.getBean(MuonTraDao.class);
        MuonTra selectedMuonTra = mtD.findById(getSelectedId());
        sua(selectedMuonTra);
    }
    
    @Override
    public void chiTiet(){
        if(checkSelectedRow() == false)
            return;
        MuonTraDao mtD = App.ctx.getBean(MuonTraDao.class);
        MuonTra selectedMuonTra = mtD.findById(getSelectedId());
        
        chiTiet(selectedMuonTra);
    }
    
    public void chiTiet(MuonTra muontra){
        TraForm form = new TraForm(muontra);
        form.setVisible(true);
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                showData();
            }
        });        
    }      
    
    public void sua(MuonTra muontra){
        MuonForm form = new MuonForm(muontra);
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
