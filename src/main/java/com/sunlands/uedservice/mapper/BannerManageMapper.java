package com.sunlands.uedservice.mapper;

import com.sunlands.uedservice.po.BannerManage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:21
 */
@Mapper
public interface BannerManageMapper {

    /**
     * 向tb_banner_manage表中插入一条记录
     *
     * @param bannerManage
     */
    @Insert("insert into tb_banner_manage(id,picture_url,type,creator,updater) values(#{id},#{pictureUrl},#{type},#{creator},#{updater})")
    void insertOne(BannerManage bannerManage);

    /**
     * 根据id获取未被删除得单条记录
     *
     * @param id
     * @return
     */
    @Select("select id,picture_url as pictureUrl,type,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_banner_manage where id = #{id} and delete_flag = 0")
    BannerManage selectById(Long id);

    /**
     * 查出tb_banner_manage中对应起始值记录
     *
     * @param startNum
     * @param endNum
     * @return
     */
    @Select("select id,title,picture_url as pictureUrl,type,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_banner_manage where delete_flag = 0 order by update_time desc limit #{param1},#{param2}")
    List<BannerManage> getAllByPageNum(int startNum, int endNum);

    /**
     * 修改tb_banner_manage表中某一项对应删除状态位
     *
     * @param id
     */
    @Update("update tb_banner_manage set delete_flag = 1 where id = #{id}")
    void updateDeleteFlagById(Long id);

    /**
     * 根据id获取tb_banner_manage中信息（包含已删除信息）
     *
     * @param id
     * @return
     */
    @Select("select id,picture_url as pictureUrl,type,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_banner_manage where id = #{id}")
    BannerManage getById(Long id);

    /**
     * 查找出根据id获取tb_banner_manage中最大记录
     *
     * @return
     */
    @Select("select count(*) from tb_banner_manage where delete_flag = 0")
    Integer getMaxRecord();

    /**
     * 根据类型获取banner信息
     * @param type
     * @return
     */
    @Select("select id,picture_url as pictureUrl,type,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_banner_manage where type = #{type} and delete_flag = 0 order by update_time desc limit 0,1")
    BannerManage selectByType(Integer type);
}
