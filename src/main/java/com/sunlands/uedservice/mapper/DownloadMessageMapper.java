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
    @Insert("insert into tb_download_message(id,picture_url,title,attachment_url,type,creator,updater,sequence) values(#{id},#{pictureUrl},#{title},#{attachmentUrl},#{type},#{creator},#{updater},#{sequence})")
    void insertOne(DownLoadMessage downLoadMessage);

    @Select("select id,picture_url as pictureUrl,title,attachment_url as attachmentUrl,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_download_message where id = #{id} and delete_flag = 0")
    DownLoadMessage selectById(Long id);

    @Select("select id,picture_url as pictureUrl,title,attachment_url as attachmentUrl,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_download_message where delete_flag = 0 order by sequence limit #{arg0},#{arg1}")
    List<DownLoadMessage> getAllByPageNum(Integer startNum, Integer endNum);

    @Update("update tb_download_message set delete_flag = 1 where id = #{id}")
    void updateDeleteFlagById(Long id);

    @Select("select id,picture_url as pictureUrl,title,attachment_url as attachmentUrl,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_download_message where id = #{id}")
    DownLoadMessage getById(Long id);
}
