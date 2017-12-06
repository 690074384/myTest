package com.sunlands.uedService.service.impl;

import com.sunlands.uedService.mapper.BannerManageMapper;
import com.sunlands.uedService.po.BannerManage;
import com.sunlands.uedService.service.BannerManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:32
 */
@Service
public class BannerManageServiceImpl implements BannerManageService{

    @Autowired
    BannerManageMapper bannerManageMapper;


    @Override
    public void insertOne(BannerManage bannerManage) {
        bannerManageMapper.insertOne(bannerManage);
    }
}
