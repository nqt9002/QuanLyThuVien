package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * ChiTietMuonTra is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class ChiTietMuonTra implements MyObject {

    private Integer maCTMT;

    private Integer maMT;

    private Integer maSach;
    
    private Integer maDauSach;

    private java.sql.Date ngayTra;
    
    private String tieuDe;

    public Integer getMaCTMT() {
        return maCTMT;
    }

    public void setMaCTMT(Integer maCTMT) {
        this.maCTMT = maCTMT;
    }

    public Integer getMaMT() {
        return maMT;
    }

    public void setMaMT(Integer maMT) {
        this.maMT = maMT;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }
    
    public Integer getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(Integer maDauSach) {
        this.maDauSach = maDauSach;
    }    

    public java.sql.Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(java.sql.Date ngayTra) {
        this.ngayTra = ngayTra;
    }
    
    public void setTieuDe(String tieuDe){
        this.tieuDe = tieuDe;
    }
    
    public String getTieuDe(){
        return this.tieuDe;
    }
    
    public boolean isDaTra(){
        return this.ngayTra != null;
    }
    
    @Override
    public String toString(){
        return "["+(isDaTra() ? "x" : " ")+"] - "+ this.tieuDe.trim();
    }

    @Override
    public boolean isNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getID() {
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

