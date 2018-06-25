package phanmemquanlythuvien.dto;

import java.util.Objects;
import javax.annotation.Generated;

/**
 * TacGia is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class TacGia implements MyObject{

    private Integer maTG;

    private java.sql.Date ngaySinh;

    private String ten;

    private String tomTat;
    
    private boolean trangThai;

    public Integer getMaTG() {
        return maTG;
    }
    
    public void setTrangThai(boolean flag){
        this.trangThai = flag;
    }

    public void setMaTG(Integer maTG) {
        this.maTG = maTG;
    }

    public java.sql.Date getNgaySinh() {
        return ngaySinh;
    }
    
    public String getNgaySinhString() {
        // TODO convert date to string
        if(this.getNgaySinh() != null){
            return this.getNgaySinh().toString();
        }
        
        return "";
    }

    public void setNgaySinh(java.sql.Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public void setNgaySinh(String ngaySinh) {
        setNgaySinh(java.sql.Date.valueOf(ngaySinh));
    }

    public String getTen() {
        return ten;
    }
    
    public boolean getTrangThai(){
        return trangThai;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }
    
    public String getTrangThaiString() {
        return trangThai ? "Kích hoạt" : "Khóa";
    }
    
    @Override
    public String toString(){
        return ten;
    }

    @Override
    public boolean isNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getID() {
        return maTG;
    }

    @Override
    public boolean isMatch(String searchText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isMatch(String[] arrString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

