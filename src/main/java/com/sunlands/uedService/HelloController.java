package com.sunlands.uedService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lvpenghui
 * @date 2017/12/4 17:06
 */
@Controller
@EnableAutoConfiguration
public class HelloController {
   /* @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Hello World!";
    }

    public static void main(String[]args){
        SpringApplication.run(HelloController.class);
    }*/
}
