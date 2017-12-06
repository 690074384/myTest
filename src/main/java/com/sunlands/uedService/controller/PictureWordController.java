package com.sunlands.uedService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 发布图文管理
 * @author lvpenghui
 * @date 2017/12/6 11:18
 */
@Controller
@RequestMapping("/pictureWord")
public class PictureWordController {

    /**
     * 显示图文列表
     * @param session
     * @return
     */
    @PostMapping("/list")
    public @ResponseBody
    Map<String, Object> list(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 图文管理列表

        return map;
    }

    /**
     * 图文管理插入一条记录
     * @param session
     * @return
     */
    @PostMapping("/publish")
    public @ResponseBody
    Map<String, Object> publish(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 插入一条图文管理记录

        return map;
    }

    /**
     * 获取一条图文管理记录
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
