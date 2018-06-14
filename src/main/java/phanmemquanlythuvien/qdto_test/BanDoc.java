package phanmemquanlythuvien.qdto_test;

import javax.annotation.Generated;

/**
 * BanDoc is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class BanDoc {

    private String email;

    private Integer maBD;

    private java.sql.Date ngaySinh;

    private String soDT;

    private String tenBD;

    private Boolean trangThai;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMaBD() {
        return maBD;
    }

    public void setMaBD(Integer maBD) {
        this.maBD = maBD;
    }

    public java.sql.Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(java.sql.Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getTenBD() {
        return tenBD;
    }

    public void setTenBD(String tenBD) {
        this.tenBD = tenBD;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

}

