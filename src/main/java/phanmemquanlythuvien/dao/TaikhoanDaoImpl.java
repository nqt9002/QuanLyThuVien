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

import phanmemquanlythuvien.qdto.QTaiKhoan;
import phanmemquanlythuvien.dto.TaiKhoan;

@Transactional
public class TaikhoanDaoImpl implements TaikhoanDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QTaiKhoan taikhoan = QTaiKhoan.TaiKhoan;
    final QBean<TaiKhoan> taikhoanBean = bean(TaiKhoan.class, taikhoan.all());
    

    @Override
    public TaiKhoan findById(int id) {
        return queryFactory.select(taikhoanBean)
                .from(taikhoan)
                .where(taikhoan.maTaiKhoan.eq(id))
                .fetchOne();
    }

    @Override
    public List<TaiKhoan> findAll(Predicate... where) {
        return queryFactory.select(taikhoanBean)
                .from(taikhoan)
                .where(where)
                .fetch();
    }

    @Override
    public TaiKhoan save(TaiKhoan p) {
        Integer id = p.getMaTaiKhoan();

        if (id == null) {
            id = queryFactory.insert(taikhoan)
                .populate(p)
                .executeWithKey(taikhoan.maTaiKhoan);
            p.setMaTaiKhoan(id);
        } else {
            queryFactory.update(taikhoan)
                .populate(p)
                .where(taikhoan.maTaiKhoan.eq(id)).execute();
        }

        return p;
    }
    
    @Override
    public void resetPass(String user, String pass){
        queryFactory.update(taikhoan)
                .set(taikhoan.matKhau, TaiKhoan.hashPass(pass))
                .where(taikhoan.taiKhoan.eq(user))
                .execute();
    }

    @Override
    public long count() {
        return queryFactory.from(taikhoan).fetchCount();
    }

    @Override
    public void delete(TaiKhoan p) {
        queryFactory.delete(taikhoan)
            .where(taikhoan.maTaiKhoan.eq(p.getMaTaiKhoan()))
            .execute();
    }
    
    //kiem tra login
    @Override
    public TaiKhoan login(String user, String pass) {
        return queryFactory.select(taikhoanBean)
            .from(taikhoan)
            .where(taikhoan.taiKhoan.eq(user),taikhoan.matKhau.eq(TaiKhoan.hashPass(pass)))
            .fetchOne();
    }
    //kiem tra ma bao mat
    @Override
    public TaiKhoan reset(String user, String pass) {
        return queryFactory.select(taikhoanBean)
            .from(taikhoan)
            .where(taikhoan.taiKhoan.eq(user),taikhoan.maBaoMat.eq(pass))
            .fetchOne();
    }    

    @Override
    public TaiKhoan getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TaiKhoan> findAll2(Predicate... where) {
        return queryFactory.select(taikhoanBean)
                .from(taikhoan)
                .where(where)
                .fetch();
    }

    @Override
    public TaiKhoan save2(TaiKhoan p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count2(Predicate... where) {
        return (int) queryFactory.from(taikhoan).where(where).fetchCount();
    }

    @Override
    public void delete2(TaiKhoan p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}