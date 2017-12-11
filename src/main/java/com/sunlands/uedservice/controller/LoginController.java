package com.sunlands.uedservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录管理
 * @author lvpenghui
 * @date 2017/12/6 10:50
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 退出登录,预留，不一定用的上
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession();
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }

        return "redirect:http://172.16.116.136:9091/cas/logout?service=http://localhost:8081";
    }
}
