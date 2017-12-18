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

    /**
     * 向tb_publish_history中插入一条记录
     * @param publishHistory
     */
    @Insert("insert into tb_publish_history(id,picture_url,title,type,table_choose,delete_flag) values(#{id},#{pictureUrl},#{title},#{type},#{tableChoose},#{deleteFlag})")
    void insertOne(PublishHistory publishHistory);

    /**
     * 查出tb_publish_history中对应起始值记录
     * @param startNum
     * @param endNum
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title,type from tb_publish_history where delete_flag = 0 limit #{param1},#{param2}")
    List<PublishHistory> getAllByPageNum(int startNum, int endNum);

    /**
     * 根据一种类型（分类选择：1--品牌元素；2--ppt模板；3--广告模板；4--可爱元素；5--精彩分享；）获取到该类型全部信息
     * @param type
     * @param startNum
     * @param endNum
     * @return
     */
    @Select("select id,picture_url as pictureUrl,title from tb_publish_history where delete_flag = 0 and type = #{param1} limit #{param2},#{param3}")
    List<PublishHistory> getOneTypeByPageNum(int type , int startNum, int endNum);

    /**
     * 修改tb_publish_history表中某一项对应删除状态位
     * @param id
     */
    @Update("update tb_publish_history set delete_flag = 1 where id = #{id}")
    void updateDeleteFlagById(Long id);

    /**
     * 根据id获取未被删除得单条记录
     * @param id
     * @return
     */
    @Select("select table_choose from tb_publish_history where id = #{id} and delete_flag = 0")
    String getTableChooseById(Long id);

    /**
     * 查找出根据id获取tb_publish_history中最大记录
     * @return
     */
    @Select("select count(*) from tb_publish_history where delete_flag = 0")
    Integer getMaxRecord();

    /**
     * 查找出根据type获取tb_publish_history中对应类型最大记录
     * @param type
     * @return
     */
    @Select("select count(*) from tb_publish_history where type = #{type} and delete_flag = 0")
    int getOneTypeMaxRecord(int type);
}
