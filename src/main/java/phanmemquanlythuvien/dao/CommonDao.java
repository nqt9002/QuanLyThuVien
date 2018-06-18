/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import java.util.List;
import phanmemquanlythuvien.dto.BanDoc;
import phanmemquanlythuvien.dto.MyObject;

/**
 *
 * @author tainguyen
 * @param <T>
 */
public interface CommonDao<T extends MyObject> {
//    T findById(int id);
//    List<T> findAll(Predicate... where);
//    T save(T p);
//    long count();
//    void delete(T p);
    T getById(int id);
    List<T> findAll2(Predicate... where);
    T save2(T p);
    int count2(Predicate... where);
    void delete2(T p);
}
