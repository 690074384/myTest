package com.sunlands.uedservice.controller;

/**
 * @author lvpenghui
 * @date 2017/12/6 11:30
 */

import com.google.gson.Gson;
import com.sunlands.uedservice.bean.DownloadLocationBean;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.processor.PublishHistoryProcessor;
import com.sunlands.uedservice.utils.GsonUtil;
import com.sunlands.uedservice.utils.ParamUtils;
import com.sunlands.uedservice.view.View;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private static PublishHistoryProcessor processor = new PublishHistoryProcessor();
    private static Gson gson = GsonUtil.getGson();
    private static View view = new View();

    @Autowired
    private DownloadLocationBean downloadLocationBean;

    /**
     * 根据条件选择显示某一类信息 1--品牌元素；2--ppt模板；3--广告模板；5--精彩分享；
     *
     * @param request
     * @param response
     */
    @PostMapping("/list")
    public @ResponseBody
    void list(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.getOneTypeByPageNum(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response, request);
    }

    /**
     * 下载某项记录
     *
     * @return
     * @throws IOException
     */
    @GetMapping("/goDownload/{id}")
    public ResponseEntity<byte[]> download(@PathVariable("id") Long id) throws IOException {

        String url = processor.goDownload(id);
        File file = new File(downloadLocationBean.getAttachmentUrl() + url);
        byte[] body;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

    /**
     * 查询精彩分享详情
     *
     * @param request
     * @param response
     */
    @PostMapping("/get")
    public @ResponseBody
    void get(HttpServletRequest request, HttpServletResponse response) {
        String param = ParamUtils.getParam(request);
        ResultBean resultBean = processor.getShared(param);
        String resultStr = gson.toJson(resultBean);
        view.viewString(resultStr, response, request);
    }


}
