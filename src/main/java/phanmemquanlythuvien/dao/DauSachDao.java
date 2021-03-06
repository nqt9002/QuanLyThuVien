/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import java.util.HashMap;
import phanmemquanlythuvien.dto.DauSach;

import java.util.List;

public interface DauSachDao extends CommonDao<DauSach> {
    
    DauSach findById(int id);

    List<DauSach> findAll(Predicate... where);

    DauSach save(DauSach p);

    long count();
    void delete(DauSach p);

    HashMap<Integer, String> getMapDauSach();
    String getTenDauSach(int maDS);
    void updateSoLuong(int mDauSach, int soluong);
}
