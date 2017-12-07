package com.sunlands.uedservice.mapper;

import com.sunlands.uedservice.po.PictureWord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:23
 */
@Mapper
public interface PictureWordMapper {
    /**
     * 向tb_picture_word中插入一条记录
     * @param pictureWord
     */
    @Insert("insert into tb_picture_word(id,picture_url,title,article,type,creator,updater,sequence) values(#{id},#{pictureUrl},#{title},#{article},#{type},#{creator},#{updater},#{sequence})")
    void insertOne(PictureWord pictureWord);

    /**
     * 根据id获取未被删除得单条记录
     * @param id
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,article,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_picture_word where id = #{id} and delete_flag = 0")
    PictureWord selectById(Long id);

    /**
     * 查出tb_picture_word中对应起始值记录
     * @param startNum
     * @param endNum
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,article,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_picture_word where delete_flag = 0 order by sequence limit #{arg0},#{arg1}")
    List<PictureWord> getAllByPageNum(int startNum, int endNum);

    /**
     * 修改tb_picture_word表中某一项对应删除状态位
     * @param id
     */
    @Update("update tb_picture_word set delete_flag = 1 where id = #{id}")
    void updateDeleteFlagById(Long id);

    /**
     * 根据id获取tb_picture_word中信息（包含已删除信息）
     * @param id
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,article,type,download_times as downloadTimes,creator,updater,create_time as createTime,update_time as updateTime,sequence,delete_flag as deleteFlag from tb_picture_word where id = #{id}")
    PictureWord getById(Long id);
}
