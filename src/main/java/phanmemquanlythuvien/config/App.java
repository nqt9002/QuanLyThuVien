/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import phanmemquanlythuvien.dto.TaiKhoan;

/**
 *
 * @author tainguyen
 */
public class App {
    public static ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
    public static TaiKhoan activeUser = new TaiKhoan();
}
