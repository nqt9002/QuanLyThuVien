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

import phanmemquanlythuvien.dto.QChuDe;
import phanmemquanlythuvien.dto.ChuDe;

@Transactional
public class ChuDeDaoImpl implements ChuDeDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QChuDe chude = QChuDe.ChuDe;
    final QBean<ChuDe> chudeBean = bean(ChuDe.class, chude.all());
    

    @Override
    public ChuDe findById(int id) {
        return queryFactory.select(chudeBean)
                .from(chude)
                .where(chude.maCD.eq(id))
                .fetchOne();
    }

    @Override
    public List<ChuDe> findAll(Predicate... where) {
        return queryFactory.select(chudeBean)
                .from(chude)
                .where(where)
                .fetch();
    }

    @Override
    public ChuDe save(ChuDe p) {
        Integer id = p.getMaCD();

        if (id == null) {
            id = queryFactory.insert(chude)
                .populate(p)
                .executeWithKey(chude.maCD);
            p.setMaCD(id);
        } else {
            queryFactory.update(chude)
                .populate(p)
                .where(chude.maCD.eq(id)).execute();
        }

        return p;
    }

    @Override
    public long count() {
        return queryFactory.from(chude).fetchCount();
    }

    @Override
    public void delete(ChuDe p) {
        queryFactory.delete(chude)
            .where(chude.maCD.eq(p.getMaCD()))
            .execute();
    }

}