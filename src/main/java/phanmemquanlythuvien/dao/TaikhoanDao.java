/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import phanmemquanlythuvien.dto.TaiKhoan;

import java.util.List;

public interface TaikhoanDao extends CommonDao {

    TaiKhoan findById(int id);
    TaiKhoan login(String user, String pass);

    List<TaiKhoan> findAll(Predicate... where);

    TaiKhoan save(TaiKhoan p);

    long count();
    void delete(TaiKhoan p);

}