package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * Sach is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class Sach {

    private Integer maDS;

    private Integer maSach;

    private Boolean trangThai;

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

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public String getTrangThaiString() {
        return trangThai ? "Kích hoạt" : "Khóa";
    }
}

