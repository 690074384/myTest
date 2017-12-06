package com.sunlands.uedService.service;

import com.sunlands.uedService.po.BannerManage;
import org.springframework.stereotype.Component;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:31
 */
@Component
public interface BannerManageService{
    void insertOne(BannerManage bannerManage);
}
