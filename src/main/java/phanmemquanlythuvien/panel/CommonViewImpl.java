/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.panel;

import org.apache.log4j.Logger;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dto.TaiKhoan;

/**
 *
 * @author tainguyen
 */
public class CommonViewImpl extends javax.swing.JPanel implements CommonView {
    private static Logger logger = Logger.getLogger(CommonViewImpl.class);
    public static TaiKhoan.Quyen quyenXem;
    public static TaiKhoan.Quyen quyenThem;
    public static TaiKhoan.Quyen quyenXoa;
    
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
    
}
