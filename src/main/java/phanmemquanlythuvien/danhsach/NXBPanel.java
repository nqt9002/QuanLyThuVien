/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.danhsach;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.NxbDao;
import phanmemquanlythuvien.dto.Nxb;
import phanmemquanlythuvien.form.NXBForm;
import phanmemquanlythuvien.enums.Quyen;

/**
 *
 * @author tainguyen
 */
public class NXBPanel extends SubPanel{
    
    List<Nxb> allNXB;
    
    String[] header = new String[] {"Mã Nhà Xuất Bản", "Tên Nhà Xuất Bản", "Trạng Thái"};
    
    public NXBPanel() {
        txtLabel.setText("Quản lý nhà xuất bản");
        quyenThem = Quyen.THEM_NXB;
        quyenXem = Quyen.XEM_NXB;
        quyenXoa = Quyen.XOA_NXB;
        tabName = "Nhà Xuất Bản";
    }
    
    public static TaiKhoanPanel create(){
        return new TaiKhoanPanel();
    }
    
    public Object[] data2Array(Nxb item){
        return new Object[]{
            item.getMaNXB(),
            item.getTenNXB(),
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

        NxbDao tgD = App.ctx.getBean(NxbDao.class);
        allNXB = tgD.findAll();
        
        Object[][] data;
        data = allNXB.stream()
            .filter(nxb -> filterValue == null || nxb.getTenNXB().toLowerCase().contains(filterValue))
            .map(nxb -> data2Array(nxb))
            .toArray(size -> new Object[size][]);
        
        table.setModel(new DefaultTableModel(data, header));
    }
    
    @Override
    public void them(){
        sua(new Nxb());
    }
    
    @Override
    public void sua() {
        NxbDao cdD = App.ctx.getBean(NxbDao.class);
        Nxb selectedNxb = cdD.findById(getSelectedId());
        sua(selectedNxb);
    }
    
    public void sua(Nxb nxb){
        NXBForm form = new NXBForm(nxb);
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
