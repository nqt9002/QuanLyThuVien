/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanmemquanlythuvien.dao;

import com.querydsl.core.types.Predicate;
import static com.querydsl.core.types.Projections.bean;
import com.querydsl.core.types.QBean;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import phanmemquanlythuvien.dto.QSach;
import phanmemquanlythuvien.dto.Sach;

@Transactional
public class SachDaoImpl implements SachDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QSach sach = QSach.Sach;
    final QBean<Sach> sachBean = bean(Sach.class, sach.all());
    

    @Override
    public Sach findById(int id) {
        return queryFactory.select(sachBean)
                .from(sach)
                .where(sach.maSach.eq(id))
                .fetchOne();
    }

    @Override
    public List<Sach> findAll(Predicate... where) {
        return queryFactory.select(sachBean)
                .from(sach)
                .where(where)
                .fetch();
    }

    @Override
    public Sach save(Sach p) {
        Integer id = p.getMaSach();

        if (id == null) {
            id = queryFactory.insert(sach)
                .populate(p)
                .executeWithKey(sach.maSach);
            p.setMaSach(id);
        } else {
            queryFactory.update(sach)
                .populate(p)
                .where(sach.maSach.eq(id)).execute();
        }

        return p;
    }

    @Override
    public long count() {
        return queryFactory.from(sach).fetchCount();
    }

    @Override
    public void delete(Sach p) {
        queryFactory.delete(sach)
            .where(sach.maSach.eq(p.getMaSach()))
            .execute();
    }

}