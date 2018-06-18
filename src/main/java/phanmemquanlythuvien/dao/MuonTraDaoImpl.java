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

import phanmemquanlythuvien.qdto.QMuonTra;
import phanmemquanlythuvien.dto.MuonTra;

@Transactional
public class MuonTraDaoImpl implements MuonTraDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QMuonTra muontra = QMuonTra.MuonTra;
    final QBean<MuonTra> muontraBean = bean(MuonTra.class, muontra.all());
    

    @Override
    public MuonTra findById(int id) {
        return queryFactory.select(muontraBean)
                .from(muontra)
                .where(muontra.maMT.eq(id))
                .fetchOne();
    }

    @Override
    public List<MuonTra> findAll(Predicate... where) {
        return queryFactory.select(muontraBean)
                .from(muontra)
                .where(where)
                .fetch();
    }

    @Override
    public MuonTra save(MuonTra p) {
        Integer id = p.getMaMT();

        if (id == null) {
            id = queryFactory.insert(muontra)
                .populate(p)
                .executeWithKey(muontra.maMT);
            p.setMaMT(id);
        } else {
            queryFactory.update(muontra)
                .populate(p)
                .where(muontra.maMT.eq(id)).execute();
        }

        return p;
    }

    @Override
    public long count() {
        return queryFactory.from(muontra).fetchCount();
    }

    @Override
    public void delete(MuonTra p) {
        queryFactory.delete(muontra)
            .where(muontra.maMT.eq(p.getMaMT()))
            .execute();
    }

    @Override
    public MuonTra getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MuonTra> findAll2(Predicate... where) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MuonTra save2(MuonTra p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count2(Predicate... where) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete2(MuonTra p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}