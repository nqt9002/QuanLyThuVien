/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import phanmemquanlythuvien.dto.BanDoc;

import java.util.List;

public interface BanDocDao {
    
    BanDoc findById(int id);

    List<BanDoc> findAll(Predicate... where);

    BanDoc save(BanDoc p);

    long count();
    void delete(BanDoc p);
    
}
