/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import phanmemquanlythuvien.dto.Phat;

import java.util.List;

public interface PhatDao extends CommonDao {
    
    Phat findById(int id);

    List<Phat> findAll(Predicate... where);

    Phat save(Phat p);

    long count();
    void delete(Phat p);
    
}
