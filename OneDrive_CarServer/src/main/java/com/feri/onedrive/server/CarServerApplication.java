package com.feri.onedrive.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-16 14:42
 */
@SpringBootApplication
@MapperScan("com.feri.onedrive.server.dao")  //扫描Mybatis的Dao层
@EnableDiscoveryClient //注册服务
public class CarServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarServerApplication.class,args);
    }
}
