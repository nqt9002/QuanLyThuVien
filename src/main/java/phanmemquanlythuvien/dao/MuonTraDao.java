/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import phanmemquanlythuvien.dto.MuonTra;

import java.util.List;

public interface MuonTraDao extends CommonDao<MuonTra> {
    
    MuonTra findById(int id);

    List<MuonTra> findAll(Predicate... where);

    MuonTra save(MuonTra p);

    long count();
    void delete(MuonTra p);
    
    Object test(int id);
    
}
