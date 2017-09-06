package com.mrc.respository;

import com.mrc.domain.Spitter;

import java.util.List;
import java.util.Map;

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

    List<Map<String, Object>> findAll();

    void addSpitter(Spitter spitter);

    void updateSpitter(Spitter spitter);
   // void insertSpitter(Spitter spitter);
}