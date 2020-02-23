package com.cyn.mallstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenyn
 */
@SpringBootApplication
@MapperScan("com.cyn.mallstudy.dao")
public class MallstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallstudyApplication.class, args);
    }

}
