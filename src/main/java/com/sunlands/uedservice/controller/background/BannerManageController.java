package com.sunlands.uedservice.controller.background;

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.processor.BannerManageProcessor;
import com.sunlands.uedservice.utils.GsonUtil;
import com.sunlands.uedservice.utils.ParamUtils;
import com.sunlands.uedservice.view.View;
import org.jasig.cas.client.authentication.AttributePrincipal;
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
@RequestMapping("/background/banner")
public class BannerManageController {

    private static BannerManageProcessor processor = new BannerManageProcessor();
    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();

    /**
     * banner信息列表
     *
     * @param request
     * @param response
     */
    @PostMapping("/list")
    public @ResponseBody
    void list(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.getAllByPageNum(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response, request);
    }

    /**
     * banner中插入一条记录
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/publish")
    public @ResponseBody
    void publish(HttpServletRequest request, HttpServletResponse response) {
        AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
        String param = ParamUtils.getParam(request);
        String account = principal.getName() + "@sunlands.com";
        ResultBean resultBean = processor.insert(param, account);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response, request);
    }

}
