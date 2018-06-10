/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.danhsach;

import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.ChuDeDao;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.NxbDao;
import phanmemquanlythuvien.dao.TacgiaDao;
import phanmemquanlythuvien.dto.DauSach;
import phanmemquanlythuvien.form.DauSachForm;
import phanmemquanlythuvien.enums.Quyen;

/**
 *
 * @author tainguyen
 */
public class DauSachPanel extends SubPanel{
    List<DauSach> allDauSach;
    HashMap<Integer, String> mapTacGia;
    
    TacgiaDao tacgiaDao = App.ctx.getBean(TacgiaDao.class);
    NxbDao nxbDao = App.ctx.getBean(NxbDao.class);
    ChuDeDao chudeDao = App.ctx.getBean(ChuDeDao.class);

    String[] header = new String[] {"Mã Đầu Sách","Tên Đầu Sách","Tác Giả", "Nhà Xuất Bản", "Chủ Đề"
            ,"Lần Tái Bản","Số Lượng","Trạng Thái"};
    
    public DauSachPanel(){
        txtLabel.setText("Quản lý đầu sách");
        quyenThem = Quyen.THEM_DAU_SACH;
        quyenXem = Quyen.XEM_DAU_SACH;
        quyenXoa = Quyen.XOA_DAU_SACH;
        tabName = "Đầu Sách";        
    }
    
    public static TaiKhoanPanel create(){
        return new TaiKhoanPanel();
    }
    
    public Object[] data2Array(DauSach item){
        return new Object[]{
            item.getMaDS(),
            item.getTen(),             
            tacgiaDao.getTenTacGia(item.getMaTG()),
            nxbDao.getTenNXB(item.getMaNXB()),
            chudeDao.getTenChuDe(item.getMaCD()),
            item.getLanTaiBan(),
            item.getSoLuong(),
            item.getTrangThaiString()
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

        DauSachDao dsD = App.ctx.getBean(DauSachDao.class);
        allDauSach = dsD.findAll();
        
        Object[][] data;
        data = allDauSach.stream()
            .filter(ds -> filterValue == null || ds.getTen().toLowerCase().contains(filterValue))
            .map(ds -> data2Array(ds))
            .toArray(size -> new Object[size][]);
        
        table.setModel(new DefaultTableModel(data, header));
    }
    
    @Override
    public void them(){
        sua(new DauSach());
    }
    
    @Override
    public void sua() {
        DauSachDao dsD = App.ctx.getBean(DauSachDao.class);
        DauSach selectedDauSach = dsD.findById(getSelectedId());
        sua(selectedDauSach);
    }
    
    public void sua(DauSach dausach){
        DauSachForm form = new DauSachForm(dausach);
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
