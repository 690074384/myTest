package com.sunlands.uedService.controller;

/**
 * @author lvpenghui
 * @date 2017/12/6 11:30
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/history")
public class HistoryController {

    /**
     * 显示全部信息列表
     * @param session
     * @return
     */
    @PostMapping("/listAll")
    public @ResponseBody
    Map<String, Object> listAll(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 全部信息列表

        return map;
    }

    /**
     * 根据条件选择显示某一类信息 1--品牌元素；2--ppt模板；3--广告模板；
     * @param session
     * @return
     */
    @PostMapping("/list")
    public @ResponseBody
    Map<String, Object> list(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 根据条件选择显示某一种信息

        return map;
    }

    /**
     * 删除某一项信息
     * @param session
     * @return
     */
    @PostMapping("/delete")
    public @ResponseBody
    Map<String, Object> delete(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 删除某一项信息，修改delete_flag

        return map;
    }

    /**
     * 下载某一项信息
     * @param session
     * @return
     */
    @PostMapping("/download")
    public @ResponseBody
    Map<String, Object> download(HttpSession session) {
        Map<String, Object> map = new HashMap<>();

        //TODO 下载某一项信息

        return map;
    }
}
