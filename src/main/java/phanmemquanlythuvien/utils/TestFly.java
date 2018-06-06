/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.utils;

import org.apache.log4j.Logger;
import phanmemquanlythuvien.dto.TaiKhoan;
import phanmemquanlythuvien.config.AppConfiguration;
import org.springframework.context.annotation.*;
import phanmemquanlythuvien.config.App;
import phanmemquanlythuvien.dao.ChuDeDao;
import phanmemquanlythuvien.dao.TaikhoanDao;

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
        testChuDe();
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
