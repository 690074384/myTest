package com.sunlands.uedService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.sunlands.uedService.*")
@MapperScan(basePackages = {"com.sunlands.uedService.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
@ImportResource(locations={"classpath:applicationContext.xml"})
@RestController
public class UedServiceApplication {

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(UedServiceApplication.class, args);
    }
}
