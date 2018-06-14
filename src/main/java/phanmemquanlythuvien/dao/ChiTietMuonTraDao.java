/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import phanmemquanlythuvien.dto.ChiTietMuonTra;

import java.util.List;

public interface ChiTietMuonTraDao extends CommonDao {
    
    ChiTietMuonTra findById(int id);
    ChiTietMuonTra findBySachId(int id);

    List<ChiTietMuonTra> findAll(Predicate... where);

    ChiTietMuonTra save(ChiTietMuonTra p);

    long count();
    void delete(ChiTietMuonTra p);
//    List<ChiTietMuonTra> findByMaMT(int id);
    
}
