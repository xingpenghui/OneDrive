package com.feri.onedrive.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 10:12
 */
@SpringBootApplication
@EnableScheduling  //启用定时任务
@EnableSwagger2
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class,args);
    }
}
