/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.panel;

import java.util.List;
import java.util.Vector;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.TacgiaDao;
import phanmemquanlythuvien.dto.TacGia;
import phanmemquanlythuvien.form.TacGiaForm;

/**
 *
 * @author tainguyen
 */
public class TacGiaPanel extends SubPanel {
    private static Logger logger = Logger.getLogger(TacGiaPanel.class);
    public TacGiaPanel(){
        txtLabel.setText("Quản lý tác giả");
    }
    
    List<TacGia> allTacGia;
    
    @Override
    public void prepareTable(){
        header = new Vector();
        header.add("Mã Tác Giả");
        header.add("Tên Tác Giả");
        header.add("Ngày Sinh");
        header.add("Tóm Tắt");
    }
    
    public Vector dataToVector(TacGia item){
        row = new Vector();
        row.add(item.getMaTG());
        row.add(item.getTen());
        row.add(item.getNgaySinh());
        row.add(item.getTomTat());
        return row;
    }
      
    @Override
    public void showData(){
        tblModel.setRowCount(0);
        TacgiaDao tgD = App.ctx.getBean(TacgiaDao.class);
        
        allTacGia = tgD.findAll();
        
        allTacGia.stream()
            .map(consumer -> dataToVector(consumer))
            .forEach(item -> data.add(item));
        
        tblModel.setDataVector(data, header);
        updateMainTable();
    }
    
    @Override
    public void tim(){
        tblModel.setRowCount(0);
        String findValue = txtTim.getText().toLowerCase();
        allTacGia.stream()
            .filter(consumer -> consumer.getTen().toLowerCase().contains(findValue))
            .map(consumer -> dataToVector(consumer))
            .forEach(item -> data.add(item));
        
        tblModel.setDataVector(data, header);
        updateMainTable();        
    }
    
    @Override
    public void them(){
        sua(new TacGia());
    }
    
    @Override
    public void sua() {
        TacgiaDao tgD = App.ctx.getBean(TacgiaDao.class);
        TacGia selectedTacGia = tgD.findById(selectedId);
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
