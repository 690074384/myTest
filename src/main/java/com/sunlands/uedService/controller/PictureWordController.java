package com.sunlands.uedService.controller;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.sunlands.uedService.bean.ResultBean;
import com.sunlands.uedService.processor.PictureWordProcessor;
import com.sunlands.uedService.utils.GsonUtil;
import com.sunlands.uedService.utils.ParamUtils;
import com.sunlands.uedService.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/pictureWord")
public class PictureWordController {
    private Logger logger = LoggerFactory.getLogger(BannerManageController.class);
    private static PictureWordProcessor processor = new PictureWordProcessor();
    private static JsonParser jsonParser = new JsonParser();
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
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.insert(param);
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
