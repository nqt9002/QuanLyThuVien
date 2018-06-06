/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.panel;

import java.util.Vector;
import phanmemquanlythuvien.dto.TaiKhoan;

/**
 *
 * @author tainguyen
 */
public class TaiKhoanPanel extends SubPanel {

    public TaiKhoanPanel() {
        
    }
    
    
    @Override
    public Vector dataToVector(TaiKhoan item){
        row = new Vector();
        row.add(item.getMaTaiKhoan());
        row.add(item.getTen());
        row.add(item.getMaChucVu());
        row.add(item.getTaiKhoan());
        row.add(item.getMatKhau());
        row.add(item.getMaBaoMat());
        return row;
    }
    
}
