/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import java.util.HashMap;
import phanmemquanlythuvien.dto.Nxb;

import java.util.List;

public interface NxbDao extends CommonDao<Nxb> {

    Nxb findById(int id);

    List<Nxb> findAll(Predicate... where);

    Nxb save(Nxb p);

    long count();
    void delete(Nxb p);
    
    HashMap<Integer, String> getMapNXB();
    String getTenNXB(int maNXB);
}