package phanmemquanlythuvien.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * MuonTra is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class MuonTra implements MyObject {

    private Integer maBD;

    private Integer maMT;
    
    private java.sql.Date ngayMuon;

    private java.sql.Date ngayPhaiTra;
    
    private Integer tongSoMuon;
    
    private Integer tongSoTra;
    
    private Boolean daTraHet;

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
    
    public Integer getTongSoMuon(){
        return tongSoMuon;
    }

    public void setTongSoMuon(Integer tongSoMuon){
        this.tongSoMuon = tongSoMuon;
    }
    
    public Integer getTongSoTra(){
        return tongSoTra;
    }
    
    public void setTongSoTra(Integer tongSoTra){
        this.tongSoTra = tongSoTra;
    }
    
    public Boolean getDaTraHet() {
        return daTraHet;
    }

    public void setDaTraHet(Boolean daTraHet) {
        this.daTraHet = daTraHet;
    }    
    
    public void traThemSach(int soluong){
        this.tongSoTra += soluong;
        this.daTraHet = Objects.equals(tongSoMuon, tongSoTra);
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

