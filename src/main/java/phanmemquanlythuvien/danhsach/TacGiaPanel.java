/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.danhsach;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.TacgiaDao;
import phanmemquanlythuvien.dto.TacGia;
import phanmemquanlythuvien.form.TacGiaForm;
import phanmemquanlythuvien.enums.Quyen;
import phanmemquanlythuvien.chitiet.TacGiaCT;

/**
 *
 * @author tainguyen
 */
public class TacGiaPanel extends SubPanel {

    List<TacGia> allTacGia;
    
    String[] header = new String[] {"Mã Tác Giả", "Tên Tác Giả", "Ngày Sinh", "Tiểu Sử","Trạng Thái"};    
    
    public TacGiaPanel(){
        txtLabel.setText("Quản lý tác giả");
        quyenThem = Quyen.THEM_TAC_GIA;
        quyenXem = Quyen.XEM_TAC_GIA;
        quyenXoa = Quyen.XOA_TAC_GIA;
        tabName = "Tác Giả";
    }
    
    public static TaiKhoanPanel create(){
        return new TaiKhoanPanel();
    }
    
    public Object[] data2Array(TacGia item){
        return new Object[]{
            item.getMaTG(),
            item.getTen(),
            item.getNgaySinhString(),
            item.getTomTat(),
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

        TacgiaDao tgD = App.ctx.getBean(TacgiaDao.class);
        allTacGia = tgD.findAll();
        
        Object[][] data;
        data = allTacGia.stream()
            .filter(tg -> filterValue == null || tg.getTen().toLowerCase().contains(filterValue))
            .map(tg -> data2Array(tg))
            .toArray(size -> new Object[size][]);
        
        table.setModel(new DefaultTableModel(data, header));
    }
    
    @Override
    public void them(){
        sua(new TacGia());
    }

    @Override
    public void sua() {
        TacgiaDao tgD = App.ctx.getBean(TacgiaDao.class);
        TacGia selectedTacGia = tgD.findById(getSelectedId());
        sua(selectedTacGia);
    }
    
    public void sua(TacGia tacgia){
        TacGiaForm form = new TacGiaForm(tacgia);
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
