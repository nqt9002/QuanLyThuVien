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
import java.util.HashMap;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import phanmemquanlythuvien.qdto.QNxb;
import phanmemquanlythuvien.dto.Nxb;

@Transactional
public class NxbDaoImpl implements NxbDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QNxb nxb = QNxb.nxb;
    final QBean<Nxb> nxbBean = bean(Nxb.class, nxb.all());
    

    @Override
    public Nxb findById(int id) {
        return queryFactory.select(nxbBean)
                .from(nxb)
                .where(nxb.maNXB.eq(id))
                .fetchOne();
    }

    @Override
    public List<Nxb> findAll(Predicate... where) {
        return queryFactory.select(nxbBean)
                .from(nxb)
                .where(where)
                .fetch();
    }

    @Override
    public Nxb save(Nxb p) {
        Integer id = p.getMaNXB();

        if (id == null) {
            id = queryFactory.insert(nxb)
                .populate(p)
                .executeWithKey(nxb.maNXB);
            p.setMaNXB(id);
        } else {
            queryFactory.update(nxb)
                .populate(p)
                .where(nxb.maNXB.eq(id)).execute();
        }

        return p;
    }

    @Override
    public long count() {
        return queryFactory.from(nxb).fetchCount();
    }

    @Override
    public void delete(Nxb p) {
        queryFactory.delete(nxb)
            .where(nxb.maNXB.eq(p.getMaNXB()))
            .execute();
    }
    
    static HashMap<Integer, String> mapNXB;
    
    @Override
    public HashMap<Integer, String> getMapNXB(){
        if(mapNXB == null){
            mapNXB = new HashMap<>();
            findAll().stream()
                    .forEach(item -> mapNXB.put(item.getMaNXB(), item.getTenNXB()));
        }
        
        return mapNXB;
    }
    
    @Override
    public String getTenNXB(int maNXB){
        
        HashMap<Integer, String> localMap = getMapNXB();
        
        if(localMap.get(maNXB) == null) {
            Nxb item = findById(maNXB);
            
            if(nxb != null){
                localMap.put(item.getMaNXB(), item.getTenNXB());
            }
        }
        
        return localMap.get(maNXB);
    }

    @Override
    public Nxb getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nxb> findAll2(Predicate... where) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nxb save2(Nxb p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count2(Predicate... where) {
        return (int) queryFactory.from(nxb).where(where).fetchCount();
    }

    @Override
    public void delete2(Nxb p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}