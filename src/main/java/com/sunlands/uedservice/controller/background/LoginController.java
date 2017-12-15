package com.sunlands.uedservice.controller.background;

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.CasConfigBean;
import com.sunlands.uedservice.utils.GsonUtil;
import com.sunlands.uedservice.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 登录管理
 * @author lvpenghui
 * @date 2017/12/6 10:50
 */
@Controller
@RequestMapping("/background/login")
public class LoginController {

    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();
    @Autowired
    private CasConfigBean casConfigBean;

    /**
     * @Author : lvpenghui
     * @Description :
     * @Date : Created in 18:20 2017/12/13
     * @ModifiedBy :
     *
    */
    @GetMapping("/login/{userName}")
    public void login(@PathVariable String userName, HttpServletResponse response) {

        System.out.println(casConfigBean.getCasServer());
        String s = casConfigBean.getCasServer()+"/getPrivilege?userName="+userName;
        System.out.println(s);
        view.viewString(s, response);
    }


    /**
     * 退出登录,预留，不一定用的上
     * @param request
     * @return
     *
     *
     *
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
