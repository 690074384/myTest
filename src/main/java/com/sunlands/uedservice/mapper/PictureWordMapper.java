package com.sunlands.uedservice.mapper;

import com.sunlands.uedservice.po.PictureWord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:23
 */
@Mapper
public interface PictureWordMapper {
    @Insert("insert into tb_picture_word(id,picture_url,title,article,type,creator,updater,sequence) values(#{id},#{pictureUrl},#{title},#{article},#{type},#{creator},#{updater},#{sequence})")
    void insertOne(PictureWord pictureWord);

    @Select("select id,picture_url as pictureUrl,title,article,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_picture_word where id = #{id} and delete_flag = 0")
    PictureWord selectById(Long id);

    @Select("select id,picture_url as pictureUrl,title,article,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_picture_word where delete_flag = 0 order by sequence limit #{arg0},#{arg1}")
    List<PictureWord> getAllByPageNum(int startNum, int endNum);
}
