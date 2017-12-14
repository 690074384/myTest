package com.sunlands.uedservice.controller;

/**
 * @author lvpenghui
 * @date 2017/12/6 11:30
 */

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.processor.PublishHistoryProcessor;
import com.sunlands.uedservice.utils.GsonUtil;
import com.sunlands.uedservice.utils.ParamUtils;
import com.sunlands.uedservice.view.View;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/history")
public class PublishHistoryController {

    private static PublishHistoryProcessor processor = new PublishHistoryProcessor();
    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();

    /**
     * 显示全部信息列表
     *
     * @param request
     * @param response
     */
    @PostMapping("/listAll")
    public @ResponseBody
    void listAll(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.getAllByPageNum(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

    /**
     * 根据条件选择显示某一类信息 1--品牌元素；2--ppt模板；3--广告模板；
     * @param request
     * @param response
     */
    @PostMapping("/list")
    public @ResponseBody
    void list(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.getOneTypeByPageNum(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

    /**
     * 删除某一项信息
     * @param request
     * @param response
     */
    @PostMapping("/delete")
    public @ResponseBody
    void delete(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.updateDeleteFlagById(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

    /**
     * 下载某项记录
     * @param id
     * @param response
     */
    @GetMapping("/goDownload/{id}")
    public @ResponseBody
    void goDownload(@PathVariable Long id, HttpServletResponse response) {
        ResultBean resultBean = processor.goDownload(id);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }
    
    /**
     * 使用get或者post请求？
     * @param request
     * @param response
     */
    @PostMapping("/get")
    public @ResponseBody
    void get(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.getOneDetail(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

}
