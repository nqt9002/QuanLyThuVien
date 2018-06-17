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
import phanmemquanlythuvien.dao.TaikhoanDao;
import phanmemquanlythuvien.dto.TaiKhoan;
import phanmemquanlythuvien.form.TaiKhoanForm;
import phanmemquanlythuvien.enums.Quyen;

/**
 *
 * @author tainguyen
 */
public class TaiKhoanPanel extends SubPanel {
    
    private static final Logger LOGGER = Logger.getLogger(TaiKhoanPanel.class);
    List<TaiKhoan> allTK;
    
    String[] header = new String[] {"Mã Tài Khoản", "Tên", "Chức Vụ", "Tài Khoản", "Trạng Thái"};

    public TaiKhoanPanel() {
        txtLabel.setText("Quản lý tài khoản");
        quyenThem = Quyen.THEM_TAI_KHOAN;
        quyenXem = Quyen.XEM_TAI_KHOAN;
        quyenXoa = Quyen.XOA_TAI_KHOAN;
        tabName = "Tài Khoản";
    }
    
    
    
    public static TaiKhoanPanel create(){
        return new TaiKhoanPanel();
    }
    
    public Object[] data2Array(TaiKhoan item){
        return new Object[]{
            item.getMaTaiKhoan(),
            item.getTen(),
            item.getChucVu(),
            item.getTaiKhoan(),
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
//        LOGGER.info("load tk data");
        TaikhoanDao tgD = App.ctx.getBean(TaikhoanDao.class);
        allTK = tgD.findAll();
        
        Object[][] data2;
        data2 = allTK.stream()
            .filter(tk -> filterValue == null || tk.getTen().toLowerCase().contains(filterValue))
            .map(tk -> data2Array(tk))
            .toArray(size -> new Object[size][]);
        
        table.setModel(new DefaultTableModel(data2, header));
    }
    
    @Override
    public void them(){
        sua(new TaiKhoan());
    }
    
    @Override
    public void sua() {
        TaikhoanDao tgD = App.ctx.getBean(TaikhoanDao.class);
        TaiKhoan selectedTaiKhoan = tgD.findById(getSelectedId());
        sua(selectedTaiKhoan);
    }
    
    public void sua(TaiKhoan taikhoan){
        TaiKhoanForm form = new TaiKhoanForm(taikhoan);
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
