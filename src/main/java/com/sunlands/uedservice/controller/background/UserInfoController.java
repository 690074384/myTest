package com.sunlands.uedservice.controller.background;

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.utils.GsonUtil;
import com.sunlands.uedservice.utils.ParamUtils;
import com.sunlands.uedservice.view.View;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录管理
 *
 * @author lvpenghui
 * @date 2017/12/6 10:50
 */
@Controller
@RequestMapping("/background/user")
public class UserInfoController {

    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();
    /**
     * 获取用户信息
     * @param request
     * @param response
     */
    @GetMapping("/get")
    public @ResponseBody
    void list(HttpServletRequest request, HttpServletResponse response) {
        ResultBean resultBean = new ResultBean();
        AttributePrincipal principal =(AttributePrincipal)request.getUserPrincipal();
        String name =  principal.getName();
        String account = name + "@sunlands.com";
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("account",account);
        resultBean.setCode(1);
        resultBean.setMsg("获取成功！");
        resultBean.setData(map);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }


}
