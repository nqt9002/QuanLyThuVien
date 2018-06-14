/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.danhsach;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.BanDocDao;
import phanmemquanlythuvien.dto.BanDoc;
import phanmemquanlythuvien.form.BanDocForm;
import phanmemquanlythuvien.enums.Quyen;
import phanmemquanlythuvien.form.MuonForm;

/**
 *
 * @author tainguyen
 */
public class BanDocPanel extends SubPanel{
    
    List<BanDoc> allBanDoc;
    
    String[] header = new String[] {"ban doc", "ngay sinh ", "sodt", "email", "Trạng Thái"};
    
    public BanDocPanel() {
        txtLabel.setText("Quản lý nhà bạn đọc");
        quyenThem = Quyen.THEM_BAN_DOC;
        quyenXem = Quyen.XEM_BAN_DOC;
        quyenXoa = Quyen.XOA_BAN_DOC;
        tabName = "Bạn Đọc";
    }
    
    @Override
    public void showHideButton(){
        //check permission
        btnThem.setVisible(canWrite());
        btnSua.setVisible(canWrite());
        btnXoa.setVisible(canDelete());
        btnMuon.setVisible(Quyen.MUON.kiemTra(App.activeUser));
    }    
    
    public static BanDocPanel create(){
        return new BanDocPanel();
    }
    
    public Object[] data2Array(BanDoc item){
        return new Object[]{
            item,
            item.getNgaySinh(),
            item.getSoDT(),
            item.getEmail(),
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
    
    @Override
    public void muon(){
        MuonForm form = MuonForm.getInstance();
        form.setBanDoc(getSelected());
        form.setVisible(true);
    }
    
    public void showData(String filterValue){

        BanDocDao bdD = App.ctx.getBean(BanDocDao.class);
        allBanDoc = bdD.findAll();
        
        Object[][] data;
        data = allBanDoc.stream()
            .filter(bandoc -> filterValue == null || bandoc.getTenBD().toLowerCase().contains(filterValue))
            .map(bandoc -> data2Array(bandoc))
            .toArray(size -> new Object[size][]);
        
        table.setModel(new DefaultTableModel(data, header));
    }
    
    @Override
    public void them(){
        sua(new BanDoc());
    }
    
    @Override
    public void sua() {
        if(table.getSelectedRow() == -1)
            return;
        sua(getSelected());
    }
    
    public BanDoc getSelected(){
        return (BanDoc) table.getModel().getValueAt(table.getSelectedRow(),0);
    }
    
    public void sua(BanDoc bandoc){
        BanDocForm form = BanDocForm.getInstance();
        form.setItem(bandoc);
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
