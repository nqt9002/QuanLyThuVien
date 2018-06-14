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
import phanmemquanlythuvien.dao.TacgiaDao;
import phanmemquanlythuvien.dto.TacGia;
import phanmemquanlythuvien.form.TacGiaForm;
import phanmemquanlythuvien.enums.Quyen;

/**
 *
 * @author tainguyen
 */
public class TacGiaPanel extends SubPanel {

    List<TacGia> allTacGia;
    private static final Logger LOGGER = Logger.getLogger(TaiKhoanPanel.class);
    
    String[] header = new String[] {"Mã Tác Giả", "Tên Tác Giả", "Ngày Sinh", "Tiểu Sử","Trạng Thái"};    
    
    public TacGiaPanel(){
        txtLabel.setText("Quản lý tác giả");
        quyenThem = Quyen.THEM_TAC_GIA;
        quyenXem = Quyen.XEM_TAC_GIA;
        quyenXoa = Quyen.XOA_TAC_GIA;
        tabName = "Tác Giả";
    }
    
    public static TacGiaPanel create(){
        return new TacGiaPanel();
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
        
        LOGGER.debug("reload Tacgia data");

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
