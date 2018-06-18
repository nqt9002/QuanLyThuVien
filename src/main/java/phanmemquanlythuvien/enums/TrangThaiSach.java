/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.enums;

import java.util.Arrays;

/**
 *
 * @author tainguyen
 */
public enum TrangThaiSach {
    KHOA("Khóa"),
    SAN_SANG("Sẵn sàng"),
    CHO_MUON("Cho mượn"),
    MAT("Mất");
    
    private final String text;
   
    TrangThaiSach(String text){
        this.text = text;
    }
    
    public String getText(){
        return this.text;
    }
    
    @Override
    public String toString(){
        return this.text;
    }

    public static Object[] available(){
        return Arrays.asList(TrangThaiSach.values()).stream().toArray();
    }   
}
