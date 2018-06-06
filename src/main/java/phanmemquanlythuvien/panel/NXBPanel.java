/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.panel;

import java.util.List;
import java.util.Vector;

import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.NxbDao;
import phanmemquanlythuvien.dto.Nxb;
import phanmemquanlythuvien.form.NXBForm;

/**
 *
 * @author tainguyen
 */
public class NXBPanel extends SubPanel{
    public NXBPanel() {
        txtLabel.setText("Quản lý nhà xuất bản");
    }
    List<Nxb> allNXB;
    public void prepareTable(){
        header = new Vector();
        header.add("Mã NXB");
        header.add("Tên");
    }
    
    public Vector dataToVector(Nxb item){
        row = new Vector();
        row.add(item.getMaNXB());
        row.add(item.getTenNXB());
        return row;
    }
    
    @Override
    public void showData()
    {
        tblModel.setRowCount(0);
        NxbDao cdD = App.ctx.getBean(NxbDao.class);
        allNXB = cdD.findAll();
        allNXB.stream()
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
        allNXB.stream()
            .filter(consumer -> consumer.getTenNXB().toLowerCase().contains(findValue))
            .map(consumer -> dataToVector(consumer))
            .forEach(item -> data.add(item));
        tblModel.setDataVector(data, header);
        updateMainTable();
    } 
    
    @Override
    public void them(){
        sua(new Nxb());
    }
    
    @Override
    public void sua() {
        NxbDao cdD = App.ctx.getBean(NxbDao.class);
        Nxb selectedNxb = cdD.findById(selectedId);
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
