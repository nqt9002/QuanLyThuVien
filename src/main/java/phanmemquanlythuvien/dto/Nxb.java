package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * Nxb is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class Nxb {

    private Integer maNXB;

    private String tenNXB;
    
    private Boolean trangThai;

    public Integer getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(Integer maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }
    
    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public String getTrangThaiString() {
        return trangThai ? "Kích hoạt" : "Khóa";
    }    
    
    
    @Override
    public String toString(){
        return tenNXB;
    }

}

