package com.mrc.respository;

import com.mrc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017-06-12.
 */
public interface GirlResponsitory  extends JpaRepository<Girl, Integer>{
    public List<Girl>  findByAge(int age);
}
