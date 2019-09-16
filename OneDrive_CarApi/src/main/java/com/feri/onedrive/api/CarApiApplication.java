package com.feri.onedrive.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-16 15:36
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient //进行服务发现
@EnableSwagger2 //启用Swagger
@EnableFeignClients //启用Feign
public class CarApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarApiApplication.class,args);
    }
}
