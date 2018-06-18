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

import phanmemquanlythuvien.qdto.QChiTietMuonTra;
import phanmemquanlythuvien.dto.ChiTietMuonTra;

@Transactional
public class ChiTietMuonTraDaoImpl implements ChiTietMuonTraDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QChiTietMuonTra chitietmuontra = QChiTietMuonTra.ChiTietMuonTra;
    final QBean<ChiTietMuonTra> chitietmuontraBean = bean(ChiTietMuonTra.class, chitietmuontra.all());
    

    @Override
    public ChiTietMuonTra findById(int id) {
        return queryFactory.select(chitietmuontraBean)
                .from(chitietmuontra)
                .where(chitietmuontra.maCTMT.eq(id))
                .fetchOne();
    }
    
    @Override
    public ChiTietMuonTra findBySachId(int id) {
        return queryFactory.select(chitietmuontraBean)
                .from(chitietmuontra)
                .where(chitietmuontra.maSach.eq(id))
                .fetchOne();
    }

    @Override
    public List<ChiTietMuonTra> findAll(Predicate... where) {
        return queryFactory.select(chitietmuontraBean)
                .from(chitietmuontra)
                .where(where)
                .fetch();
    }

    @Override
    public ChiTietMuonTra save(ChiTietMuonTra p) {
        Integer id = p.getMaCTMT();

        if (id == null) {
            id = queryFactory.insert(chitietmuontra)
                .populate(p)
                .executeWithKey(chitietmuontra.maCTMT);
            p.setMaCTMT(id);
        } else {
            queryFactory.update(chitietmuontra)
                .populate(p)
                .where(chitietmuontra.maCTMT.eq(id)).execute();
        }

        return p;
    }

    @Override
    public long count() {
        return queryFactory.from(chitietmuontra).fetchCount();
    }

    @Override
    public void delete(ChiTietMuonTra p) {
        queryFactory.delete(chitietmuontra)
            .where(chitietmuontra.maCTMT.eq(p.getMaCTMT()))
            .execute();
    }

    @Override
    public ChiTietMuonTra getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChiTietMuonTra> findAll2(Predicate... where) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChiTietMuonTra save2(ChiTietMuonTra p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count2(Predicate... where) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete2(ChiTietMuonTra p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}