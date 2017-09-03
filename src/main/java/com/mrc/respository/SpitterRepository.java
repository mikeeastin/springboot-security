package com.mrc.respository;

import com.mrc.domain.Spitter;

import java.util.List;

/**
 * Created by Administrator on 2017-08-23.
 */

/**
 * SpitterRepository 接口，实现方式可以是 jpa or  spring jdbc template
 */
public interface SpitterRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();

    void addSpitter(Spitter spitter);
}