/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.danhsach;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.ChuDeDao;
import phanmemquanlythuvien.dto.ChuDe;
import phanmemquanlythuvien.form.ChuDeForm;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.enums.Quyen;

/**
 *
 * @author tainguyen
 */
public class ChuDePanel extends SubPanel {
    private static Logger logger = Logger.getLogger(ChuDePanel.class);
    List<ChuDe> allChuDe;
    
    String[] header = new String[] {"Mã Chủ Đề", "Tên Chủ Đề","Trạng Thái"};    
    
    public ChuDePanel() {
        txtLabel.setText("Quản lý chủ đề");
        quyenThem = Quyen.THEM_CHU_DE;
        quyenXem = Quyen.XEM_CHU_DE;
        quyenXoa = Quyen.XOA_CHU_DE;
        tabName = "Chủ Đề";
    }
    
    public static ChuDePanel create(){
        return new ChuDePanel();
    }
    
    public Object[] data2Array(ChuDe item){
        return new Object[]{
            item.getMaCD(),
            item.getTenChuDe(),
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

        ChuDeDao tgD = App.ctx.getBean(ChuDeDao.class);
        allChuDe = tgD.findAll();
        
        Object[][] data;
        data = allChuDe.stream()
            .filter(cd -> filterValue == null 
                    || cd.getTenChuDe().toLowerCase().contains(filterValue) 
                    || cd.getMaCD().toString().contains(filterValue))
            .map(cd -> data2Array(cd))
            .toArray(size -> new Object[size][]);
        
        table.setModel(new DefaultTableModel(data, header));
    }
    
    @Override
    public void them(){
        sua(new ChuDe());
    }
    
    @Override
    public void sua() {
        ChuDeDao cdD = App.ctx.getBean(ChuDeDao.class);
        ChuDe selectedChuDe = cdD.findById(getSelectedId());
        sua(selectedChuDe);
    }
    
    public void sua(ChuDe chude){
        ChuDeForm form = new ChuDeForm(chude);
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
