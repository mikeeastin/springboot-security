package com.mrc.respository;

/**
 * Created by Administrator on 2017-08-23.
 */

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mrc.domain.Spitter;

/**
 * Jpa 方式操作数据
 * springdata jpa虽然相比hibernate性能上会稍微差点，毕竟是hibernate更上层的封装，但是使用上更加简洁
 * 本应用暂时注释掉 @Repository ，即不使用Jpa，使用spring jdbc
 * JdbcSpitterRepository
 */
//@Repository
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long count() {
        return findAll().size();
    }

    public Spitter save(Spitter spitter) {
        entityManager.persist(spitter);
        return spitter;
    }

    public Spitter findOne(long id) {
        return entityManager.find(Spitter.class, id);
    }

    public Spitter findByUsername(String username) {
        return (Spitter) entityManager.createQuery("select s from Spitter s where s.username=?").setParameter(1, username).getSingleResult();
    }

    public List<Map<String, Object>> findAll() {
        return ( List<Map<String, Object>> ) entityManager.createQuery("select * from Spitter s").getResultList();
    }

    @Override
    public void addSpitter(Spitter spitter) {

    }

    @Override
    public void updateSpitter(Spitter spitter) {

    }

/*    @Override
    public void insertSpitter(Spitter spitter) {

    }*/

}