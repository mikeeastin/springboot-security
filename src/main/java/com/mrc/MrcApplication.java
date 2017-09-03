package com.mrc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// mapper 接口类扫描包配置
@MapperScan("com.mrc.dao")
@SpringBootApplication
public class MrcApplication {


    public static void main(String[] args) {
        SpringApplication.run(MrcApplication.class, args);
    }

}
