/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import phanmemquanlythuvien.dto.ChuDe;

import java.util.List;

public interface ChuDeDao extends CommonDao {

    ChuDe findById(int id);

    List<ChuDe> findAll(Predicate... where);

    ChuDe save(ChuDe p);

    long count();
    void delete(ChuDe p);

}