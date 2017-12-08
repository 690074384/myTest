package com.sunlands.uedservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
     *  登录管理
     * @param account
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/loginPost")
    public @ResponseBody
    Map<String, Object> loginPost(String account, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>(10);


        // TODO 调用接口 设置session

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // TODO 移除session

        return "redirect:/login";
    }
}
