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

import phanmemquanlythuvien.dto.QBanDoc;
import phanmemquanlythuvien.dto.BanDoc;

@Transactional
public class BanDocDaoImpl implements BanDocDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QBanDoc bandoc = QBanDoc.BanDoc;
    final QBean<BanDoc> bandocBean = bean(BanDoc.class, bandoc.all());
    

    @Override
    public BanDoc findById(int id) {
        return queryFactory.select(bandocBean)
                .from(bandoc)
                .where(bandoc.maBD.eq(id))
                .fetchOne();
    }

    @Override
    public List<BanDoc> findAll(Predicate... where) {
        return queryFactory.select(bandocBean)
                .from(bandoc)
                .where(where)
                .fetch();
    }

    @Override
    public BanDoc save(BanDoc p) {
        Integer id = p.getMaBD()       ;

        if (id == null) {
            id = queryFactory.insert(bandoc)
                .populate(p)
                .executeWithKey(bandoc.maBD);
            p.setMaBD(id);
        } else {
            queryFactory.update(bandoc)
                .populate(p)
                .where(bandoc.maBD.eq(id)).execute();
        }

        return p;
    }

    @Override
    public long count() {
        return queryFactory.from(bandoc).fetchCount();
    }

    @Override
    public void delete(BanDoc p) {
        queryFactory.delete(bandoc)
            .where(bandoc.maBD.eq(p.getMaBD()))
            .execute();
    }

}