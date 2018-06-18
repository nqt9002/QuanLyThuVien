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
import java.util.Set;
import phanmemquanlythuvien.dto.MyObject;

import phanmemquanlythuvien.qdto.QSach;
import phanmemquanlythuvien.dto.Sach;
import phanmemquanlythuvien.enums.TrangThaiSach;

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
    public int countDS(int mDauSach,int trangthai){
        return (int) queryFactory
                .select(sachBean)
                .from(sach)
                .where(sach.maDS.eq(mDauSach),sach.trangThai.eq(trangthai))
                .fetchCount();
    }
    
    @Override
    public void delete(Sach p) {
        queryFactory.delete(sach)
            .where(sach.maSach.eq(p.getMaSach()))
            .execute();
    }

    @Override
    public int countDS(int mDauSach, TrangThaiSach trangthai) {
        return countDS(mDauSach, trangthai.ordinal());
    }

    @Override
    public int countDS(int mDauSach) {
        return countDS(mDauSach, TrangThaiSach.SAN_SANG);
    }

    @Override
    public void doiTrangThai(Set<Integer> idSach, TrangThaiSach trangthai) {
        queryFactory.update(sach)
                .set(sach.trangThai, trangthai.ordinal())
                .where(sach.maSach.in(idSach))
                .execute();
    }

    @Override
    public Sach getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sach> findAll2(Predicate... where) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sach save2(Sach p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count2(Predicate... where) {
        return (int) queryFactory.from(sach).where(where).fetchCount();
    }

    @Override
    public void delete2(Sach p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}