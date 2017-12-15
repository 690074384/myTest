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
     *
     * @param pictureWord
     */
    @Insert("insert into tb_picture_word(id,picture_url,title,article,type,creator,updater) values(#{id},#{pictureUrl},#{title},#{article},#{type},#{creator},#{updater})")
    void insertOne(PictureWord pictureWord);

    /**
     * 根据id获取未被删除得单条记录
     *
     * @param id
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,article,type,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_picture_word where id = #{id} and delete_flag = 0")
    PictureWord selectById(Long id);

    /**
     * 查出tb_picture_word中对应起始值记录
     *
     * @param startNum
     * @param endNum
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,article,type,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_picture_word where delete_flag = 0 order by sequence limit #{arg0},#{arg1}")
    List<PictureWord> getAllByPageNum(int startNum, int endNum);

    /**
     * 修改tb_picture_word表中某一项对应删除状态位
     *
     * @param id
     */
    @Update("update tb_picture_word set delete_flag = 1 where id = #{id}")
    void updateDeleteFlagById(Long id);

    /**
     * 根据id获取tb_picture_word中信息（包含已删除信息）
     *
     * @param id
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,article,type,creator,updater,create_time as createTime,update_time as updateTime,sequence from tb_picture_word where id = #{id}")
    PictureWord getById(Long id);

    /**
     * 查找出根据id获取tb_picture_word中最大记录
     *
     * @return
     */
    @Select("select count(*) from tb_picture_word where delete_flag = 0")
    Integer getMaxRecord();

    /**
     * 获取精彩分享信息
     *
     * @param id
     * @return
     */
    @Select("select viewCount,title,article ,create_time as createTime from tb_picture_word where id = #{id} and delete_flag=0")
    PictureWord getSharedMessage(Long id);

    /**
     * 增加浏览次数
     * @param id
     */
    @Update("update tb_picture_word set viewCount = viewCount+1 where id = #{id}")
    void updateViewCount(Long id);
}
