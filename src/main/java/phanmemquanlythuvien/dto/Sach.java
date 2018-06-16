package phanmemquanlythuvien.dto;

import java.util.Arrays;
import javax.annotation.Generated;
import phanmemquanlythuvien.enums.TrangThaiSach;

/**
 * Sach is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class Sach implements MyObject{

    private Integer maDS;

    private Integer maSach;

    private Integer trangThai;
    
    private String tieuDe;

    public Integer getMaDS() {
        return maDS;
    }

    public void setMaDS(Integer maDS) {
        this.maDS = maDS;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    
    public void setTrangThai(TrangThaiSach value){
        setTrangThai(value.ordinal());
    }
    
    public TrangThaiSach getTrangThaiEnum(){
        return TrangThaiSach.values()[getTrangThai()];
    }
    
    public void setTieuDe(String tieuDe){
        this.tieuDe = tieuDe;
    }
    
    public String getTieuDe(){
        return this.tieuDe;
    }
    
    public boolean isReady(){
        return this.getTrangThaiEnum() == TrangThaiSach.SAN_SANG;
    }
    
    @Override
    public String toString(){
        return "#"+this.maSach +" "+ this.tieuDe;
    }

    @Override
    public boolean isNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isMatch(String searchText) {
        return searchText != null 
                ? toString().toLowerCase().contains(searchText.toLowerCase()) 
                : true;
    }

    @Override
    public boolean isMatch(String[] arrString) {
        int count = 0;
        
        for(String text: arrString){
            if(isMatch(text))
                count += 1;
        }
        
        return count == arrString.length;
    }
    
}

