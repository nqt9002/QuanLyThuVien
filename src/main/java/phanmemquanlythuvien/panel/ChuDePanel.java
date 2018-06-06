/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.panel;

import java.util.List;
import java.util.Vector;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.ChuDeDao;
import phanmemquanlythuvien.dto.ChuDe;
import phanmemquanlythuvien.form.ChuDeForm;
import org.apache.log4j.Logger;

/**
 *
 * @author tainguyen
 */
public class ChuDePanel extends SubPanel {
    private static Logger logger = Logger.getLogger(ChuDePanel.class);
    public ChuDePanel() {
        txtLabel.setText("Quản lý chủ đề");
    }
    List<ChuDe> allChuDe;
    public void prepareTable(){
        header = new Vector();
        header.add("Mã CD");
        header.add("Tên");
    }
    
    public Vector dataToVector(ChuDe item){
        row = new Vector();
        row.add(item.getMaCD());
        row.add(item.getTenChuDe());
        return row;
    }
    
    @Override
    public void showData()
    {
        tblModel.setRowCount(0);
        ChuDeDao cdD = App.ctx.getBean(ChuDeDao.class);
        allChuDe = cdD.findAll();
        allChuDe.stream()
            .map(consumer -> dataToVector(consumer))
            .forEach(item -> data.add(item));
        tblModel.setDataVector(data, header);
        updateMainTable();
    }
    
    @Override
    public void tim(){
        tblModel.setRowCount(0);
        data = new Vector();
        String findValue = txtTim.getText().toLowerCase();
        allChuDe.stream()
            .filter(consumer -> consumer.getTenChuDe().toLowerCase().contains(findValue))
            .map(consumer -> dataToVector(consumer))
            .forEach(item -> data.add(item));
        tblModel.setDataVector(data, header);
        logger.info(data);
        updateMainTable();
    } 
    
    @Override
    public void them(){
        sua(new ChuDe());
    }
    
    @Override
    public void sua() {
        ChuDeDao cdD = App.ctx.getBean(ChuDeDao.class);
        ChuDe selectedChuDe = cdD.findById(selectedId);
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
