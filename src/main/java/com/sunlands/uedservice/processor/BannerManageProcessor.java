package com.sunlands.uedservice.processor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.mapper.AllDao;
import com.sunlands.uedservice.po.BannerManage;
import com.sunlands.uedservice.po.PublishHistory;
import com.sunlands.uedservice.utils.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 15:01 2017/12/6
 * @ModifiedBy :
 */
public class BannerManageProcessor {

    private static Logger logger = LoggerFactory.getLogger(BannerManage.class);
    private static JsonParser jsonParser = new JsonParser();
    private static String SEQUENCE = "sequence";

    /**
     * TODO
     * @param param
     * @return
     */
    public ResultBean insert(String param) {
        String pictureUrl;
        Byte type;
        Integer sequence = 0;
        JsonObject bannerManageJson;
        String title;
        ResultBean bannerManageBean = new ResultBean();
        Long id = SnowflakeIdWorker.getSnowFlakeId();
        try {
            bannerManageJson = (JsonObject) jsonParser.parse(param);
            title = bannerManageJson.get("title").getAsString();
            pictureUrl = bannerManageJson.get("pictureUrl").getAsString();
            type = bannerManageJson.get("type").getAsByte();
            if (bannerManageJson.has(SEQUENCE)) {
                sequence = bannerManageJson.get(SEQUENCE).getAsInt();
            }
        } catch (Exception e) {
            logger.error("参数传递异常！");
            bannerManageBean.setCode(0);
            bannerManageBean.setMsg("参数传递异常！");
            return bannerManageBean;
        }

        BannerManage bannerManage = new BannerManage();
        bannerManage.setId(id);
        bannerManage.setSequence(sequence);
        bannerManage.setType(type);
        bannerManage.setPictureUrl(pictureUrl);
        bannerManage.setTitle(title);

        // TODO 需要获取session中的用户
        bannerManage.setUpdater("lvpenghui");
        bannerManage.setCreator("lvpenghui");


        PublishHistory publishHistory = new PublishHistory();
        publishHistory.setId(id);
        publishHistory.setPictureUrl(pictureUrl);
        publishHistory.setTitle(title);
        publishHistory.setType(type);
        publishHistory.setDownloadTimes(0);
        publishHistory.setTableChoose("tb_banner_manage");
        publishHistory.setDeleteFlag((byte) 0);

        try {
            AllDao.getInstance().getBannerManageDao().insertOne(bannerManage);
            AllDao.getInstance().getPublishHistoryDao().insertOne(publishHistory);
        } catch (Exception e) {
            bannerManageBean.setCode(0);
            bannerManageBean.setMsg("数据插入失败！");
            return bannerManageBean;
        }

        bannerManageBean.setCode(1);
        bannerManageBean.setData(AllDao.getInstance().getBannerManageDao().selectById(id));
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
        bannerManageBean.setData(bannerManage);
        bannerManageBean.setMsg("数据获取成功！");
        bannerManageBean.setCode(1);
        return bannerManageBean;
    }

    public ResultBean getAllByPageNum(String param) {
        ResultBean bannerManageBean = new ResultBean();
        int pageNum;
        try {
            pageNum = ((JsonObject) jsonParser.parse(param)).get("pageNum").getAsInt();
        } catch (Exception e) {
            bannerManageBean.setCode(0);
            logger.error("参数传递异常！");
            bannerManageBean.setMsg("参数传递异常！");
            return bannerManageBean;
        }
        List<BannerManage> bannerManageList = AllDao.getInstance().getBannerManageDao().getAllByPageNum((pageNum - 1) * 12, pageNum * 12);
        bannerManageBean.setData(bannerManageList);
        bannerManageBean.setMsg("数据获取成功！");
        bannerManageBean.setCode(1);
        return bannerManageBean;
    }
}
