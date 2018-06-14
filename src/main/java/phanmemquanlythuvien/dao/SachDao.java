/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import phanmemquanlythuvien.dto.Sach;

import java.util.List;
import phanmemquanlythuvien.enums.TrangThaiSach;

public interface SachDao extends CommonDao {
    
    Sach findById(int id);

    List<Sach> findAll(Predicate... where);

    Sach save(Sach p);

    long count();
    void delete(Sach p);
    int countDS(int mDauSach, int trangthai);
    int countDS(int mDauSach, TrangThaiSach trangthai);
    int countDS(int mDauSach);
    
}
