package phanmemquanlythuvien.dto;

import phanmemquanlythuvien.enums.ChucVu;
import phanmemquanlythuvien.enums.Quyen;
import javax.annotation.Generated;

/**
 * TaiKhoan is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class TaiKhoan {
    
    private String maBaoMat;

    private Integer maChucVu = 1;

    private Integer maTaiKhoan;

    private String matKhau;

    private String taiKhoan;

    private String ten;
    
    private Boolean trangThai;
    
    public boolean isNew(){
        return maTaiKhoan == null;
    }

    public String getMaBaoMat() {
        return maBaoMat;
    }

    public void setMaBaoMat(String maBaoMat) {
        this.maBaoMat = maBaoMat;
    }

    public Integer getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(Integer maChucVu) {
        this.maChucVu = maChucVu;
    }

    public Integer getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(Integer maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = hashPass(matKhau);
    }
    
    static public String hashPass(String rawPass){
        // TODO - do hash
        return rawPass;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public ChucVu getChucVu(){
        return ChucVu.values()[getMaChucVu()];
    }
    
    public boolean kiemTraQuyen(Quyen q){
        // TODO: if is admin, return true
        return q.kiemTra(getChucVu());
    }
    
    public Boolean getTrangThai() {
        return trangThai;
    }
    
    public String getTrangThaiString() {
        return trangThai ? "Kích hoạt" : "Khóa";
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

}

