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
public enum ChucVu {
    GUEST("Khách", false),
    QUAN_LY("Quản lý", true),
    THU_KHO("Thủ kho", true),
    THU_THU("Thủ thư", true);  
    
    private final String text;
    public final boolean enable;
    
    ChucVu(String text, boolean isEnable){
        this.text = text;
        this.enable = isEnable;
    }
    
    public String getText(){
        return this.text;
    }
    
    @Override
    public String toString(){
        return this.text;
    }
    
    public static Object[] available(){
        return Arrays.asList(ChucVu.values()).stream().filter(i -> i.enable).toArray();
    }
}
