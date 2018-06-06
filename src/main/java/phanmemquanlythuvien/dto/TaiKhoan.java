package phanmemquanlythuvien.dto;

import java.util.Arrays;
import javax.annotation.Generated;

/**
 * TaiKhoan is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class TaiKhoan {
    public static enum ChucVu {
        GUEST,
        QUAN_LY,
        THU_KHO,
        THU_THU;    
    }
    
    public static enum Quyen {
        // permission for account
        THEM_TAI_KHOAN(ChucVu.QUAN_LY),
        XEM_TAI_KHOAN(ChucVu.QUAN_LY),
        XOA_TAI_KHOAN(),
        // permission for category
        THEM_CHU_DE(ChucVu.QUAN_LY),
        XEM_CHU_DE(ChucVu.QUAN_LY,ChucVu.THU_KHO,ChucVu.THU_THU),
        XOA_CHU_DE(),
        // permission for author
        THEM_TAC_GIA(ChucVu.QUAN_LY),
        XEM_TAC_GIA(ChucVu.QUAN_LY,ChucVu.THU_KHO,ChucVu.THU_THU),
        XOA_TAC_GIA(),
        // permission for publisher
        THEM_NXB(ChucVu.QUAN_LY),
        XEM_NXB(ChucVu.QUAN_LY,ChucVu.THU_KHO,ChucVu.THU_THU),
        XOA_NXB(),
        // permission for reader
        THEM_BAN_DOC(ChucVu.THU_THU),
        XEM_BAN_DOC(ChucVu.THU_THU),
        XOA_BAN_DOC(),
        // permission for book title
        THEM_DAU_SACH(ChucVu.THU_KHO),
        XEM_DAU_SACH(ChucVu.THU_KHO,ChucVu.QUAN_LY),
        XOA_DAU_SACH(),
        // permission for book
        THEM_SACH(ChucVu.THU_KHO),
        XEM_SACH(ChucVu.THU_KHO,ChucVu.THU_THU,ChucVu.QUAN_LY),  
        XOA_SACH(),
        // permission for borrow book
        THEM_MUON_SACH(ChucVu.THU_THU),
        XEM_MUON_SACH(ChucVu.THU_THU,ChucVu.QUAN_LY),
        XOA_MUON_SACH(),
        // permission for give book back
        THEM_TRA_SACH(ChucVu.THU_THU),
        XEM_TRA_SACH(ChucVu.THU_THU,ChucVu.QUAN_LY),
        XOA_TRA_SACH(),
        // permission for punish
        THEM_PHAT(ChucVu.THU_THU),
        XEM_PHAT(ChucVu.THU_THU,ChucVu.QUAN_LY),
        XOA_PHAT();

        
        private ChucVu[] chucVu;
        
        Quyen(ChucVu... c){
            this.chucVu = c;
        }
        
        public boolean kiemTra(ChucVu c){
            return Arrays.asList(chucVu).contains(c);
        }
        
        public boolean kiemTra(TaiKhoan u){
            return kiemTra(u.getChucVu());
        }
        
    }

    private String maBaoMat;

    private Integer maChucVu = 0;

    private Integer maTaiKhoan;

    private String matKhau;

    private String taiKhoan;

    private String ten;
    
    private Boolean trangThai;

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

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

}

