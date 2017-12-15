package com.sunlands.uedservice.controller.background;

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.ResultBean;
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
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 18:00 2017/12/15
 * @ModifiedBy :
 */
@Controller
@RequestMapping("/background/upload")
public class UploadController {

    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();
    /**
     * 上传附件
     * @param request
     * @param response
     */
    @PostMapping("/attachment")
    public @ResponseBody
    void attachment(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = new ResultBean();
//TODO All
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }

    /**
     * 上传图片
     * @param request
     * @param response
     */
    @PostMapping("/picture")
    public @ResponseBody
    void picture(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = new ResultBean();

        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response);
    }


}
