package com.mrc.respository;

/**
 * Created by Administrator on 2017-08-23.
 */


import com.mrc.domain.Spitter;

import java.util.List;

public interface SpitterRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}