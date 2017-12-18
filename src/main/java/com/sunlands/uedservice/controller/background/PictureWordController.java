package com.sunlands.uedservice.controller.background;

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.processor.PictureWordProcessor;
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
 * 发布图文管理
 *
 * @author lvpenghui
 * @date 2017/12/6 11:18
 */
@Controller
@RequestMapping("/background/pictureWord")
public class PictureWordController {
    private static PictureWordProcessor processor = new PictureWordProcessor();
    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();

    /**
     * 显示图文列表
     * @param request
     * @param response
     */
    @PostMapping("/list")
    public @ResponseBody
    void list(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.getAllByPageNum(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

    /**
     * 图文管理插入一条记录
     *
     * @param request
     * @param response
     */
    @PostMapping("/publish")
    public @ResponseBody
    void publish(HttpServletRequest request, HttpServletResponse response) {

        AttributePrincipal principal =(AttributePrincipal)request.getUserPrincipal();
        String account =  principal.getName() + "@sunlands.com";
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.insert(param,account);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

    /**
     * 获取一条图文管理记录
     * @param request
     * @param response
     */
    @PostMapping("/get")
    public @ResponseBody
    void get(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.getById(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }
}
