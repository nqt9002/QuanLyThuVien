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

import phanmemquanlythuvien.dto.QPhat;
import phanmemquanlythuvien.dto.Phat;

@Transactional
public class PhatDaoImpl implements PhatDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QPhat phat = QPhat.Phat;
    final QBean<Phat> phatBean = bean(Phat.class, phat.all());
    

    @Override
    public Phat findById(int id) {
        return queryFactory.select(phatBean)
                .from(phat)
                .where(phat.maPhat.eq(id))
                .fetchOne();
    }

    @Override
    public List<Phat> findAll(Predicate... where) {
        return queryFactory.select(phatBean)
                .from(phat)
                .where(where)
                .fetch();
    }

    @Override
    public Phat save(Phat p) {
        Integer id = p.getMaPhat();

        if (id == null) {
            id = queryFactory.insert(phat)
                .populate(p)
                .executeWithKey(phat.maPhat);
            p.setMaPhat(id);
        } else {
            queryFactory.update(phat)
                .populate(p)
                .where(phat.maPhat.eq(id)).execute();
        }

        return p;
    }

    @Override
    public long count() {
        return queryFactory.from(phat).fetchCount();
    }

    @Override
    public void delete(Phat p) {
        queryFactory.delete(phat)
            .where(phat.maPhat.eq(p.getMaPhat()))
            .execute();
    }

}