package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * Phat is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class Phat implements MyObject{

    private Integer maCTMT;
    
    private Integer maMT;
    
    private Integer maSach;

    private Integer maPhat;

    private java.sql.Date ngayPhat;

    private Integer soNgay;

    private Integer soTien;

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
    
    public Integer getMaPhat() {
        return maPhat;
    }

    public void setMaPhat(Integer maPhat) {
        this.maPhat = maPhat;
    }

    public java.sql.Date getNgayPhat() {
        return ngayPhat;
    }

    public void setNgayPhat(java.sql.Date ngayPhat) {
        this.ngayPhat = ngayPhat;
    }

    public Integer getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(Integer soNgay) {
        this.soNgay = soNgay;
    }

    public Integer getSoTien() {
        return soTien;
    }

    public void setSoTien(Integer soTien) {
        this.soTien = soTien;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isMatch(String[] arrString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

