package com.feri.onedrive.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-19 11:46
 */
@SpringBootApplication
@EnableSwagger2
public class ResourceApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApiApplication.class,args);
    }
}
