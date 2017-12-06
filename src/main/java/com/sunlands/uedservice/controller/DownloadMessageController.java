package com.sunlands.uedservice.controller;

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.processor.DownloadMessageProcessor;
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
 * 下载信息管理
 * @author lvpenghui
 * @date 2017/12/6 11:17
 */
@Controller
@RequestMapping("/downloadMessage")
public class DownloadMessageController {

    private static DownloadMessageProcessor processor = new DownloadMessageProcessor();
    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();

    /**
     * 显示下载信息列表
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
     * 下载信息插入一条记录
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
     * 获取一条下载信息记录
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
