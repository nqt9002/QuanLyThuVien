/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import phanmemquanlythuvien.dto.TaiKhoan;
import phanmemquanlythuvien.config.AppConfiguration;
import org.springframework.context.annotation.*;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.ChuDeDao;
import phanmemquanlythuvien.dao.TaikhoanDao;
import javax.sql.DataSource;
import phanmemquanlythuvien.dao.SachDao;
import phanmemquanlythuvien.dto.Sach;


class Parent
{
    int value = 1000;
    Parent()
    {
        System.out.println("Parent Constructor");
    }
    
    int getValue(){
        return value;
    }
}
 
class Child extends Parent
{
    Child()
    {
        value = 10;
        System.out.println("Child Constructor");
    }
}

/**
 *
 * @author tainguyen
 */
@Import(AppConfiguration.class)
public class TestFly {
    
    private static final Logger logger = Logger.getLogger(TestFly.class);
    static TaikhoanDao tkDao = App.ctx.getBean(TaikhoanDao.class);
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

// testLogin();
//        testChuDe();

//        String query = "select MuonTra.DaTraHet, MuonTra.MaBD, MuonTra.MaMT, MuonTra.NgayMuon, MuonTra.NgayPhaiTra, MuonTra.TongSoMuon, MuonTra.TongSoTra\n" +
//"from MuonTra MuonTra\n" +
//"where MuonTra.MaMT = 1";
//
//        DataSource ds = App.ctx.getBean(DataSource.class);
//        try{
//            Connection conn = ds.getConnection();
//            Statement stmt = conn.createStatement();
//            PreparedStatement statement = conn.prepareStatement(query);
//            ResultSet r = statement.executeQuery();
//
//            
//            while(r.next()){
//                logger.info("====data=====");
//                logger.info(r.getDate(4));
//            }
//            
//        } catch(Exception e){
//            logger.info(e);
//        }
        
//
//        MuonTraDao dao = App.ctx.getBean(MuonTraDao.class);
//        logger.info(dao.test(1));

//        logger.info(java.sql.Date.valueOf("1990-06-08"));
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//        LocalDateTime now = LocalDateTime.now();  
//        System.out.println(dtf.format(now));  
    }
    
    
    public static void testChuDe(){
        ChuDeDao cDD = App.ctx.getBean(ChuDeDao.class);
        logger.info("So chu de:");
        logger.info(cDD.count());
        logger.info("So tk:");
        logger.info(tkDao.count());
    }
    public static void testLogin() {
        TaiKhoan loggedIn = tkDao.login("quanly", "123456");
        
        if(loggedIn != null){
            logger.info(loggedIn.getTen());
        } else {
            logger.info("login failed");
        }
    }
}
