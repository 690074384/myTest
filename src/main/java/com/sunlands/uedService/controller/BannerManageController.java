package com.sunlands.uedService.controller;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.sunlands.uedService.bean.ResultBean;
import com.sunlands.uedService.mapper.AllDao;
import com.sunlands.uedService.po.BannerManage;
import com.sunlands.uedService.processor.BannerManageProcessor;
import com.sunlands.uedService.utils.GsonUtil;
import com.sunlands.uedService.utils.ParamUtils;
import com.sunlands.uedService.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * banner管理
 *
 * @author lvpenghui
 * @date 2017/12/6 11:06
 */
@Controller
@RequestMapping("/banner")
public class BannerManageController {

    private Logger logger = LoggerFactory.getLogger(BannerManageController.class);
    private static BannerManageProcessor processor = new BannerManageProcessor();
    private static JsonParser jsonParser = new JsonParser();
    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();

    /**
     * banner信息列表
     *
     * @param session
     * @return
     */
    @PostMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    Map<String, Object> list(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 显示banner列表
        System.out.println("bannerList");
        BannerManage bm = new BannerManage();
        bm.setId(123L);
        //id,picture_url,type,creator,updater,sequence
        bm.setPictureUrl("http://www.baidu.com");
        bm.setType((byte) 1);
        bm.setCreator("lvpenghui");
        bm.setUpdater("lvpenghui");
        bm.setSequence(1);
        AllDao.getInstance().getBannerManageDao().insertOne(bm);
        System.out.println(bm.getId());

        return map;
    }


    /**
     * banner中插入一条记录
     *
     * @param request
     * @param response
     * @return
     */

    //id,picture_url,type,creator,updater,sequence
    @PostMapping("/publish")
    public @ResponseBody
    void publish(HttpServletRequest request, HttpServletResponse response) {


        String param = ParamUtils.getParam(request);

        processor.insert(param);


        ResultBean resultBean = new ResultBean();
        resultBean.setCode(1);
        resultBean.setData(1);
        String resultStr = gson.toJson(resultBean);

        view.viewString(resultStr, response);
    }

    /**
     * 获取一条banner记录
     *
     * @param request
     * @return
     */
    @PostMapping("/get")
    public @ResponseBody
    Map<String, Object> get(HttpRequest request) {
        Map<String, Object> map = new HashMap<>();

        //TODO 获取一条记录

        return map;
    }

}
