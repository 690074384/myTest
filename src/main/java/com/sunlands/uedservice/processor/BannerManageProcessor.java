package com.sunlands.uedservice.processor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sunlands.uedservice.bean.PaginationBean;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.mapper.AllDao;
import com.sunlands.uedservice.po.BannerManage;
import com.sunlands.uedservice.po.PublishHistory;
import com.sunlands.uedservice.utils.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 15:01 2017/12/6
 * @ModifiedBy :
 */
public class BannerManageProcessor {

    private static Logger logger = LoggerFactory.getLogger(BannerManage.class);
    private static JsonParser jsonParser = new JsonParser();

    /**
     * 插入一条banner记录
     *
     * @param param
     * @return
     */
    public ResultBean insert(String param) {
        String pictureUrl;
        Byte type;
        JsonObject bannerManageJson;
        ResultBean bannerManageBean = new ResultBean();
        Long id = SnowflakeIdWorker.getSnowFlakeId();
        try {
            bannerManageJson = (JsonObject) jsonParser.parse(param);
            pictureUrl = bannerManageJson.get("pictureUrl").getAsString();
            type = bannerManageJson.get("type").getAsByte();
        } catch (Exception e) {
            logger.error("参数传递异常！");
            bannerManageBean.setCode(0);
            bannerManageBean.setMsg("参数传递异常！");
            return bannerManageBean;
        }

        BannerManage bannerManage = new BannerManage();
        bannerManage.setId(id);
        bannerManage.setType(type);
        bannerManage.setPictureUrl(pictureUrl);

        // TODO 需要获取session中的用户
        bannerManage.setUpdater("lvpenghui");
        bannerManage.setCreator("lvpenghui");


        PublishHistory publishHistory = new PublishHistory();
        publishHistory.setId(id);
        publishHistory.setPictureUrl(pictureUrl);
        publishHistory.setType(type);
        publishHistory.setTableChoose("tb_banner_manage");
        publishHistory.setDeleteFlag((byte) 0);
        publishHistory.setTitle("");

        try {
            AllDao.getInstance().getBannerManageDao().insertOne(bannerManage);
            AllDao.getInstance().getPublishHistoryDao().insertOne(publishHistory);
        } catch (Exception e) {
            e.printStackTrace();
            bannerManageBean.setCode(0);
            bannerManageBean.setMsg("数据插入失败！");
            return bannerManageBean;
        }

        bannerManageBean.setCode(1);
        bannerManageBean.setMsg("数据插入成功！");
        return bannerManageBean;
    }

    public ResultBean getById(String param) {
        ResultBean bannerManageBean = new ResultBean();
        Long id;
        try {
            id = ((JsonObject) jsonParser.parse(param)).get("id").getAsLong();
        } catch (Exception e) {
            logger.error("参数传递异常！");
            bannerManageBean.setCode(0);
            bannerManageBean.setMsg("参数传递异常！");
            return bannerManageBean;
        }

        BannerManage bannerManage = AllDao.getInstance().getBannerManageDao().selectById(id);
        if (bannerManage == null) {
            logger.error("该id记录不存在或已被删除！");
            bannerManageBean.setCode(0);
            bannerManageBean.setMsg("该id记录不存在或已被删除！");
            return bannerManageBean;
        }

        Map<String ,String> map = new HashMap<>();
        map.put("bannerPicUrl",bannerManage.getPictureUrl());
        bannerManageBean.setData(map);
        bannerManageBean.setMsg("数据获取成功！");
        bannerManageBean.setCode(1);
        return bannerManageBean;
    }

    public ResultBean getAllByPageNum(String param) {
        ResultBean bannerManageBean = new ResultBean();
        PaginationBean paginationBean = new PaginationBean();
        List<BannerManage> bannerManageList;
        int pageNum;
        int pageSize;
        int maxRecord;
        try {
            pageNum = ((JsonObject) jsonParser.parse(param)).get("pageNum").getAsInt();
            pageSize = ((JsonObject) jsonParser.parse(param)).get("pageSize").getAsInt();
            bannerManageList = AllDao.getInstance().getBannerManageDao().getAllByPageNum((pageNum - 1) * pageSize, pageNum * pageSize);
            paginationBean.setList(bannerManageList);
        } catch (Exception e) {
            bannerManageBean.setCode(0);
            logger.error("参数传递异常！");
            bannerManageBean.setMsg("参数传递异常！");
            return bannerManageBean;
        }
        maxRecord = AllDao.getInstance().getBannerManageDao().getMaxRecord();
        paginationBean.setPageSize(pageSize);
        paginationBean.setMaxRecord(maxRecord);
        paginationBean.setPageCount((int) Math.ceil((double) maxRecord / pageSize));

        bannerManageBean.setData(paginationBean);
        bannerManageBean.setMsg("数据获取成功！");
        bannerManageBean.setCode(1);
        return bannerManageBean;
    }
}
