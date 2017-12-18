package com.sunlands.uedservice.controller;

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.processor.BannerManageProcessor;
import com.sunlands.uedservice.utils.GsonUtil;
import com.sunlands.uedservice.utils.ParamUtils;
import com.sunlands.uedservice.view.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * banner管理
 *
 * @author lvpenghui
 * @date 2017/12/6 11:06
 */
@Controller
@RequestMapping("/banner")
public class BannerController {

    private static BannerManageProcessor processor = new BannerManageProcessor();
    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();

    /**
     * 获取一条banner记录
     * @param request
     * @param response
     */
    @PostMapping("/get")
    public @ResponseBody
    void get(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.getByType(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

}
