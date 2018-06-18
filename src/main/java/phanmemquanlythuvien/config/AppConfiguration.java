/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import phanmemquanlythuvien.dao.BanDocDao;
import phanmemquanlythuvien.dao.BanDocDaoImpl;
import phanmemquanlythuvien.dao.ChiTietMuonTraDao;
import phanmemquanlythuvien.dao.ChiTietMuonTraDaoImpl;
import phanmemquanlythuvien.dao.ChuDeDao;
import phanmemquanlythuvien.dao.ChuDeDaoImpl;
import phanmemquanlythuvien.dao.DauSachDao;
import phanmemquanlythuvien.dao.DauSachDaoImpl;
import phanmemquanlythuvien.dao.MuonTraDao;
import phanmemquanlythuvien.dao.MuonTraDaoImpl;
import phanmemquanlythuvien.dao.NxbDao;
import phanmemquanlythuvien.dao.NxbDaoImpl;
import phanmemquanlythuvien.dao.PhatDao;
import phanmemquanlythuvien.dao.PhatDaoImpl;
import phanmemquanlythuvien.dao.SachDao;
import phanmemquanlythuvien.dao.SachDaoImpl;
import phanmemquanlythuvien.dao.TacgiaDao;
import phanmemquanlythuvien.dao.TacgiaDaoImpl;
import phanmemquanlythuvien.dao.TaikhoanDao;
import phanmemquanlythuvien.dao.TaikhoanDaoImpl;

@Configuration
@EnableTransactionManagement
@Import(JdbcConfiguration.class)
public class AppConfiguration {

   @Inject Environment env;

   @Bean
   public TaikhoanDao taikhoanDao() {
       return new TaikhoanDaoImpl();
   }
   
   @Bean
   public ChuDeDao chudeDao(){
       return new ChuDeDaoImpl();
   }
   
   @Bean
   public TacgiaDao tacgiaDao(){
       return new TacgiaDaoImpl();
   }
   
   @Bean
   public NxbDao nxbDao(){
       return new NxbDaoImpl();
   }
   
   @Bean
   public BanDocDao bandocDao(){
       return new BanDocDaoImpl();
   }
   
   @Bean
   public DauSachDao dauSachDao(){
       return new DauSachDaoImpl();
   }
   
   @Bean
   public SachDao sachDao(){
       return new SachDaoImpl();
   }

   @Bean
   public MuonTraDao muonTraDao(){
       return new MuonTraDaoImpl();
   }
   
   @Bean
   public ChiTietMuonTraDao chiTietMuonTraDao(){
       return new ChiTietMuonTraDaoImpl();
   }
   
   @Bean
   public PhatDao phatDao(){
       return new PhatDaoImpl();
   }

}