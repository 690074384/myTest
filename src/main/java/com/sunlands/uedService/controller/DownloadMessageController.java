package com.sunlands.uedService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 下载信息管理
 * @author lvpenghui
 * @date 2017/12/6 11:17
 */
@Controller
@RequestMapping("/downloadMessage")
public class DownloadMessageController {

    /**
     * 显示下载信息列表
     * @param session
     * @return
     */
    @PostMapping("/list")
    public @ResponseBody
    Map<String, Object> list(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 下载信息列表

        return map;
    }

    /**
     * 下载信息插入一条记录
     * @param session
     * @return
     */
    @PostMapping("/publish")
    public @ResponseBody
    Map<String, Object> publish(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 插入一条banner记录

        return map;
    }

    /**
     * 获取一条下载信息记录
     * @param session
     * @return
     */
    @PostMapping("/get")
    public @ResponseBody
    Map<String, Object> get(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 获取一条记录

        return map;
    }
}
