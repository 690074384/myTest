package com.sunlands.uedservice.mapper;

import com.sunlands.uedservice.po.PublishHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author : lvpenghui
 * @Description : 发布历史
 * @Date : Created in 11:52 2017/12/7
 * @ModifiedBy :
 */

@Mapper
public interface PublishHistoryMapper {

    @Insert("insert into tb_publish_history(id,picture_url,title,type,download_times,table_choose,delete_flag) values(#{id},#{pictureUrl},#{title},#{type},#{downloadTimes},#{tableChoose},#{deleteFlag})")
    void insertOne(PublishHistory publishHistory);

    @Select("select id,picture_url as pictureUrl,title,type,download_times as downloadTimes,table_choose as tableChoose,delete_flag as deleteFlag from tb_publish_history where delete_flag = 0 order by download_times limit #{arg0},#{arg1}")
    List<PublishHistory> getAllByPageNum(int startNum, int endNum);

    @Select("select id,picture_url as pictureUrl,title,type,download_times as downloadTimes,table_choose as tableChoose,delete_flag as deleteFlag from tb_publish_history where delete_flag = 0 and type = #{arg0} order by download_times limit #{arg1},#{arg2}")
    List<PublishHistory> getOneTypeByPageNum(int type , int startNum, int endNum);

    @Update("update tb_publish_history set delete_flag = 1 where id = #{id}")
    void updateDeleteFlagById(Long id);

    @Select("select table_choose from tb_publish_history where id = #{id} and delete_flag = 0")
    String getTableChooseById(Long id);
}
