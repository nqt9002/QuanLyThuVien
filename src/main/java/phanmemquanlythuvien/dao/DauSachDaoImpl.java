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

import phanmemquanlythuvien.dto.DauSach;
import phanmemquanlythuvien.qdto.QDauSach;

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

    static HashMap<Integer, String> mapDauSach;
    
    @Override
    public HashMap<Integer, String> getMapDauSach(){
        if(mapDauSach == null){
            mapDauSach = new HashMap<>();
            findAll().stream()
                    .forEach(item -> mapDauSach.put(item.getMaDS(), item.getTen()));
        }
        
        return mapDauSach;
    }
    
    @Override
    public String getTenDauSach(int maDS){
        
        HashMap<Integer, String> localMap = getMapDauSach();
        
        if(localMap.get(maDS) == null) {
            DauSach item = findById(maDS);
            
            if(dausach != null){
                localMap.put(item.getMaDS(), item.getTen());
            }
        }
        
        return localMap.get(maDS);
    }

    @Override
    public void updateSoLuong(int mDauSach, int soluong) {
        queryFactory.update(dausach)
                .set(dausach.soLuong, soluong)
                .where(dausach.maDS.eq(mDauSach))
                .execute();
    }

    @Override
    public DauSach getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DauSach> findAll2(Predicate... where) {
        return queryFactory.select(dausachBean)
                .from(dausach)
                .where(where)
                .fetch();       
    }

    @Override
    public DauSach save2(DauSach p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count2(Predicate... where) {
        return (int) queryFactory.from(dausach).where(where).fetchCount();
    }

    @Override
    public void delete2(DauSach p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}