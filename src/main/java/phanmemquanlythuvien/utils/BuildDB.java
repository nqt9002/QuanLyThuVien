/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.utils;

import com.querydsl.codegen.BeanSerializer;
import com.querydsl.sql.codegen.MetaDataExporter;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import phanmemquanlythuvien.config.App;

/**
 *
 * @author tainguyen
 */
public class BuildDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MetaDataExporter exporter = new MetaDataExporter();
        exporter.setPackageName("phanmemquanlythuvien.dto_new");
        exporter.setTargetFolder(new File("src/main/java"));
//        exporter.setBeanSerializer(new BeanSerializer());
        exporter.setExportViews(false);
        try { 
            javax.sql.DataSource dataSource = App.ctx.getBean(javax.sql.DataSource.class);
            exporter.export(dataSource.getConnection().getMetaData());
        } catch (SQLException ex) {
            Logger.getLogger(BuildDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
