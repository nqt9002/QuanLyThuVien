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

import phanmemquanlythuvien.dto.QDauSach;
import phanmemquanlythuvien.dto.DauSach;
import phanmemquanlythuvien.dto.QTacGia;

@Transactional
public class DauSachDaoImpl implements DauSachDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QDauSach dausach = QDauSach.DauSach;
    final QBean<DauSach> dausachBean = bean(DauSach.class, dausach.all());
    

    @Override
    public DauSach findById(int id) {
        return queryFactory.select(dausachBean)
                .from(dausach)
                .where(dausach.maDS.eq(id))
                .fetchOne();
    }

    @Override
    public List<DauSach> findAll(Predicate... where) {
        return queryFactory.select(dausachBean)
                .from(dausach)
                .where(where)
                .fetch();
    }

    @Override
    public DauSach save(DauSach p) {
        Integer id = p.getMaDS();

        if (id == null) {
            id = queryFactory.insert(dausach)
                .populate(p)
                .executeWithKey(dausach.maDS);
            p.setMaDS(id);
        } else {
            queryFactory.update(dausach)
                .populate(p)
                .where(dausach.maDS.eq(id)).execute();
        }

        return p;
    }

    @Override
    public long count() {
        return queryFactory.from(dausach).fetchCount();
    }

    @Override
    public void delete(DauSach p) {
        queryFactory.delete(dausach)
            .where(dausach.maDS.eq(p.getMaDS()))
            .execute();
    }

}