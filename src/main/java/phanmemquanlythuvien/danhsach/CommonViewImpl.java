/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.danhsach;

import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.enums.Quyen;

/**
 *
 * @author tainguyen
 */
public class CommonViewImpl extends javax.swing.JPanel implements CommonView {
    private static Logger logger = Logger.getLogger(CommonViewImpl.class);
    public Quyen quyenXem;
    public Quyen quyenThem;
    public Quyen quyenXoa;
    
    @Override
    public boolean canRead(){
        return this.quyenXem.kiemTra(App.activeUser);
    }
    
    @Override
    public boolean canWrite(){
        return this.quyenThem.kiemTra(App.activeUser);
    }
    
    @Override
    public boolean canDelete(){
        return this.quyenXoa.kiemTra(App.activeUser);
    }
    
    @Override
    public void doEdit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showHideButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
