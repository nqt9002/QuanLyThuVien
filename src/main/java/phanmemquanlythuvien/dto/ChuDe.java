package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * ChuDe is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class ChuDe implements MyObject{

    private Integer maCD;

    private String tenChuDe;
    
    private boolean trangThai;

    public Integer getMaCD() {
        return maCD;
    }

    public void setTrangThai(boolean flag){
        this.trangThai = flag;
    }    
    
    public void setMaCD(Integer maCD) {
        this.maCD = maCD;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }
    
    public boolean getTrangThai(){
        return trangThai;
    }    

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }
    
    public String getTrangThaiString() {
        return trangThai ? "Kích hoạt" : "Khóa";
    }
    
    @Override
    public String toString(){
        return tenChuDe;
    }

    @Override
    public boolean isNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getID() {
        return maCD;
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

