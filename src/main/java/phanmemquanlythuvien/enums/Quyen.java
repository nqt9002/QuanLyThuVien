/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.enums;

import java.util.Arrays;
import phanmemquanlythuvien.dto.TaiKhoan;

/**
 *
 * @author tainguyen
 */
public enum Quyen {
    // permission for account
    THEM_TAI_KHOAN(ChucVu.QUAN_LY),
    XEM_TAI_KHOAN(ChucVu.QUAN_LY),
    XOA_TAI_KHOAN(),
    // permission for category
    THEM_CHU_DE(ChucVu.QUAN_LY),
    XEM_CHU_DE(ChucVu.QUAN_LY,ChucVu.THU_KHO),
    XOA_CHU_DE(),
    // permission for author
    THEM_TAC_GIA(ChucVu.QUAN_LY),
    XEM_TAC_GIA(ChucVu.QUAN_LY,ChucVu.THU_KHO),
    XOA_TAC_GIA(),
    // permission for publisher
    THEM_NXB(ChucVu.QUAN_LY),
    XEM_NXB(ChucVu.QUAN_LY,ChucVu.THU_KHO),
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
    XOA_PHAT(),
    MUON(ChucVu.THU_THU);
    


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
