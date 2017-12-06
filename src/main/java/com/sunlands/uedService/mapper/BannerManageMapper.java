package com.sunlands.uedService.mapper;

import com.sunlands.uedService.po.BannerManage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:21
 */
@Mapper
public interface BannerManageMapper {

    @Insert("insert into tb_banner_manage(id,picture_url,type,creator,updater,sequence) values(#{id},#{pictureUrl},#{type},#{creator},#{updater},#{sequence})")
    void insertOne(BannerManage bannerManage);

    @Select("select id,picture_url as pictureUrl,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_banner_manage where id = #{id} and delete_flag = 0")
    BannerManage selectById(Long id);

    @Select("select id,picture_url as pictureUrl,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_banner_manage where delete_flag = 0 order by sequence limit #{arg0},#{arg1}")
    List<BannerManage> getAllByPageNum(int startNum, int endNum);
}
