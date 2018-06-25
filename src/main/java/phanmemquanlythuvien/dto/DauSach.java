package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * DauSach is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class DauSach implements MyObject{

    private Integer lanTaiBan;

    private Integer maCD;

    private Integer maDS;

    private Integer maNXB;

    private Integer maTG;

    private Integer soLuong;

    private String ten;
    
    private Boolean trangThai;

    private String ttnd;

    public Integer getLanTaiBan() {
        return lanTaiBan;
    }

    public void setLanTaiBan(Integer lanTaiBan) {
        this.lanTaiBan = lanTaiBan;
    }

    public Integer getMaCD() {
        return maCD;
    }

    public void setMaCD(Integer maCD) {
        this.maCD = maCD;
    }

    public Integer getMaDS() {
        return maDS;
    }

    public void setMaDS(Integer maDS) {
        this.maDS = maDS;
    }

    public Integer getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(Integer maNXB) {
        this.maNXB = maNXB;
    }

    public Integer getMaTG() {
        return maTG;
    }

    public void setMaTG(Integer maTG) {
        this.maTG = maTG;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }    

    public String getTtnd() {
        return ttnd;
    }

    public void setTtnd(String ttnd) {
        this.ttnd = ttnd;
    }

    public String getTrangThaiString() {
        return trangThai ? "Kích hoạt" : "Khóa";
    }    
    
    @Override
    public String toString(){
        return this.ten;
    }

    @Override
    public boolean isNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getID() {
        return maDS;
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

