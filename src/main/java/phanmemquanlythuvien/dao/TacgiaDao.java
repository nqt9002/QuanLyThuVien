/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import phanmemquanlythuvien.dto.TacGia;

import java.util.List;

public interface TacgiaDao extends CommonDao {

    TacGia findById(int id);

    List<TacGia> findAll(Predicate... where);
    
    TacGia save(TacGia p);

    long count();
    void delete(TacGia p);

}