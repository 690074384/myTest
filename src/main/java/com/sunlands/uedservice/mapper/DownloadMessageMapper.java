package com.sunlands.uedservice.mapper;

import com.sunlands.uedservice.po.DownLoadMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:22
 */
@Mapper
public interface DownloadMessageMapper {
    /**
     * 向tb_download_message中插入一条记录
     * @param downLoadMessage
     */
    @Insert("insert into tb_download_message(id,picture_url,title,attachment_url,type,creator,updater,sequence) values(#{id},#{pictureUrl},#{title},#{attachmentUrl},#{type},#{creator},#{updater},#{sequence})")
    void insertOne(DownLoadMessage downLoadMessage);

    /**
     * 根据id获取未被删除得单条记录
     * @param id
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,attachment_url as attachmentUrl,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_download_message where id = #{id} and delete_flag = 0")
    DownLoadMessage selectById(Long id);

    /**
     * 查出tb_download_message中对应起始值记录
     * @param startNum
     * @param endNum
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,attachment_url as attachmentUrl,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_download_message where delete_flag = 0 order by sequence limit #{arg0},#{arg1}")
    List<DownLoadMessage> getAllByPageNum(Integer startNum, Integer endNum);

    /**
     * 修改tb_download_message表中某一项对应删除状态位
     * @param id
     */
    @Update("update tb_download_message set delete_flag = 1 where id = #{id}")
    void updateDeleteFlagById(Long id);

    /**
     * 根据id获取tb_download_message中信息（包含已删除信息）
     * @param id
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,attachment_url as attachmentUrl,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_download_message where id = #{id}")
    DownLoadMessage getById(Long id);

    /**
     * 查找出根据id获取tb_banner_manage中最大记录
     * @return
     */
    @Select("select count(*) from tb_download_message where delete_flag = 0")
    Integer getMaxRecord();
}
