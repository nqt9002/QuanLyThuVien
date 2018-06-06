package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * ChuDe is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class ChuDe {

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

}

