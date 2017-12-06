package com.sunlands.uedService.mapper;

import com.sunlands.uedService.po.BannerManage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:21
 */
@Mapper
public interface BannerManageMapper {

    @Insert("insert into tb_banner_manage(id,picture_url,type,creator,updater,sequence) values(#{id},#{pictureUrl},#{type},#{creator},#{updater},#{sequence})")
    void insertOne(BannerManage bannerManage);
}
