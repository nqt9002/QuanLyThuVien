package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * Phat is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class Phat {

    private Integer maMT;

    private Integer maPhat;

    private java.sql.Date ngayPhat;

    private Integer soNgay;

    private Integer soTien;

    public Integer getMaMT() {
        return maMT;
    }

    public void setMaMT(Integer maMT) {
        this.maMT = maMT;
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

}

