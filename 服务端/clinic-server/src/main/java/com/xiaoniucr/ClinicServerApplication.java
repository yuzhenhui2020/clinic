package com.xiaoniucr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目启动
 */
@MapperScan("com.xiaoniucr.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class ClinicServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicServerApplication.class, args);
    }

}
