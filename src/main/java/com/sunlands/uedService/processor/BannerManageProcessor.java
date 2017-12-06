package com.sunlands.uedService.processor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sunlands.uedService.bean.ResultBean;
import com.sunlands.uedService.mapper.AllDao;
import com.sunlands.uedService.po.BannerManage;
import com.sunlands.uedService.utils.GsonUtil;
import com.sunlands.uedService.utils.SnowflakeIdWorker;
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
    private static Gson gson = GsonUtil.getGson();


    public ResultBean insert(String param) {
        String pictureUrl;
        Byte type;
        Integer sequence = 0;
        JsonObject bannerManageJson;
        ResultBean bannerManageBean = new ResultBean();
        Long id = SnowflakeIdWorker.getSnowFlakeId();
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
            return bannerManageBean;
        }

        BannerManage bannerManage = new BannerManage();
        bannerManage.setId(id);
        bannerManage.setSequence(sequence);
        bannerManage.setType(type);
        bannerManage.setPictureUrl(pictureUrl);

        // TODO 需要获取session中的用户
        bannerManage.setUpdater("lvpenghui");
        bannerManage.setCreator("lvpenghui");

        try {
            AllDao.getInstance().getBannerManageDao().insertOne(bannerManage);
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
            id = ((JsonObject)jsonParser.parse(param)).get("id").getAsLong();
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
        int startNum;
        int endNum;
        try {
            startNum = ((JsonObject) jsonParser.parse(param)).get("startNum").getAsInt();
            endNum = ((JsonObject) jsonParser.parse(param)).get("endNum").getAsInt();
        } catch (Exception e) {
            bannerManageBean.setCode(0);
            logger.error("参数传递异常！");
            bannerManageBean.setMsg("参数传递异常！");
            return bannerManageBean;
        }
        List<BannerManage> bannerManageList = AllDao.getInstance().getBannerManageDao().getAllByPageNum(startNum,endNum);
        bannerManageBean.setData(bannerManageList);
        bannerManageBean.setMsg("数据获取成功！");
        bannerManageBean.setCode(1);
        return bannerManageBean;
    }
}
