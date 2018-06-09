/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import java.util.List;

/**
 *
 * @author tainguyen
 */
public interface CommonDao {
    List<?> findAll(Predicate... where);
}
