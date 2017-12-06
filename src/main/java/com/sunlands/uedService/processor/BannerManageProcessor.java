package com.sunlands.uedService.processor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sunlands.uedService.bean.ResultBean;
import com.sunlands.uedService.mapper.AllDao;
import com.sunlands.uedService.mapper.BannerManageMapper;
import com.sunlands.uedService.po.BannerManage;
import com.sunlands.uedService.service.BannerManageService;
import com.sunlands.uedService.utils.GsonUtil;
import com.sunlands.uedService.utils.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 15:01 2017/12/6
 * @ModifiedBy :
 */
public class BannerManageProcessor {

    private static Logger logger = LoggerFactory.getLogger(BannerManage.class);
    private static JsonParser jsonParser = new JsonParser();
    private static Gson gson = GsonUtil.getGson();


    public ResultBean insert(String param) {
        String pictureUrl = null;
        Byte type = 1;
        Integer sequence = 0;
        JsonObject bannerManageJson;
        ResultBean bannerManageBean = new ResultBean();
        try {
            bannerManageJson = (JsonObject) jsonParser.parse(param);
            pictureUrl = bannerManageJson.get("pictureUrl").getAsString();
            type = bannerManageJson.get("type").getAsByte();
            if (bannerManageJson.has("sequence"))
                sequence = bannerManageJson.get("sequence").getAsInt();
        } catch (Exception e) {
            logger.error("参数传递异常！");
            bannerManageBean.setCode(0);
            bannerManageBean.setMsg("参数传递异常！");
        }

        BannerManage bannerManage = new BannerManage();
        bannerManage.setId(SnowflakeIdWorker.getSnowFlakeId());
        bannerManage.setSequence(sequence);
        bannerManage.setType(type);
        bannerManage.setPictureUrl(pictureUrl);

        // TODO 需要获取session中的用户
        bannerManage.setUpdater("lvpenghui");
        bannerManage.setCreator("lvpenghui");


        //creator,updater
        try {
            AllDao.getInstance().getBannerManageDao().insertOne(bannerManage);
        } catch (Exception e) {
            bannerManageBean.setCode(0);
            bannerManageBean.setMsg("数据插入失败！");
        }

        bannerManageBean.setCode(1);

        return bannerManageBean;
    }
}
