package com.nineclock.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nineclock.system.mapper")

public class NcSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(NcSystemApplication.class, args);
    }
}
