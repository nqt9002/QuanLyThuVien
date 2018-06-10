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

import phanmemquanlythuvien.dto.QTacGia;
import phanmemquanlythuvien.dto.TacGia;

@Transactional
    public class TacgiaDaoImpl implements TacgiaDao {

    @Inject
    SQLQueryFactory queryFactory;

    final QTacGia tacgia = QTacGia.TacGia;
    final QBean<TacGia> tacgiaBean = bean(TacGia.class, tacgia.all());
    

    @Override
    public TacGia findById(int id) {
        return queryFactory.select(tacgiaBean)
                .from(tacgia)
                .where(tacgia.maTG.eq(id))
                .fetchOne();
    }
    
    @Override
    public List<TacGia> findAll(Predicate... where) {
        return queryFactory.select(tacgiaBean)
                .from(tacgia)
                .where(where)
                .fetch();
    }

    @Override
    public TacGia save(TacGia p) {
        Integer id = p.getMaTG();

        if (id == null) {
            id = queryFactory.insert(tacgia)
                .populate(p)
                .executeWithKey(tacgia.maTG);
            p.setMaTG(id);
        } else {
            queryFactory.update(tacgia)
                .populate(p)
                .where(tacgia.maTG.eq(id)).execute();
        }
        
        mapTacGia.put(p.getMaTG(), p.getTen());

        return p;
    }

    @Override
    public long count() {
        return queryFactory.from(tacgia).fetchCount();
    }

    @Override
    public void delete(TacGia p) {
        queryFactory.delete(tacgia)
            .where(tacgia.maTG.eq(p.getMaTG()))
            .execute();
    }
    
    static HashMap<Integer, String> mapTacGia;
    
    @Override
    public HashMap<Integer, String> getMapTacGia(){
        if(mapTacGia == null){
            mapTacGia = new HashMap<>();
            findAll().stream()
                    .forEach(item -> mapTacGia.put(item.getMaTG(), item.getTen()));
        }
        
        return mapTacGia;
    }
    
    @Override
    public String getTenTacGia(int maTG){
        
        HashMap<Integer, String> localMap = getMapTacGia();
        
        if(localMap.get(maTG) == null) {
            TacGia item = findById(maTG);
            
            if(tacgia != null){
                localMap.put(item.getMaTG(), item.getTen());
            }
        }
        
        return localMap.get(maTG);
    }

}