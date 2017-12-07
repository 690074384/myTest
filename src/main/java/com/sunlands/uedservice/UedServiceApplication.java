package com.sunlands.uedservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.sunlands.uedservice.*")
@MapperScan(basePackages = {"com.sunlands.uedService.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
@ImportResource(locations={"classpath:applicationContext.xml"})
@RestController
@ServletComponentScan
/**
 * @Author : lvpenghui
 * @Description : 启动方法
 * @Date : Created in 19:24 2017/12/7
 * @ModifiedBy :
 *
*/
public class UedServiceApplication {

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(UedServiceApplication.class, args);
        System.out.println("1111111111111111111111111");
        System.out.print(System.getProperty("contextConfigLocation"));
        System.out.println("1111111111111111111111111");

    }
}
