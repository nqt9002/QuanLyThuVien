package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * MuonTra is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class MuonTra {

    private Integer maBD;

    private Integer maMT;

    private java.sql.Date ngayMuon;

    private java.sql.Date ngayPhaiTra;

    public Integer getMaBD() {
        return maBD;
    }

    public void setMaBD(Integer maBD) {
        this.maBD = maBD;
    }

    public Integer getMaMT() {
        return maMT;
    }

    public void setMaMT(Integer maMT) {
        this.maMT = maMT;
    }

    public java.sql.Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(java.sql.Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public java.sql.Date getNgayPhaiTra() {
        return ngayPhaiTra;
    }

    public void setNgayPhaiTra(java.sql.Date ngayPhaiTra) {
        this.ngayPhaiTra = ngayPhaiTra;
    }

}

