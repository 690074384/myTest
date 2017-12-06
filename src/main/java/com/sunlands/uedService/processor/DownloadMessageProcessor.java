package com.sunlands.uedService.processor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sunlands.uedService.bean.ResultBean;
import com.sunlands.uedService.mapper.AllDao;
import com.sunlands.uedService.po.BannerManage;
import com.sunlands.uedService.po.DownLoadMessage;
import com.sunlands.uedService.utils.GsonUtil;
import com.sunlands.uedService.utils.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 18:08 2017/12/6
 * @ModifiedBy :
 */
public class DownloadMessageProcessor {

    private static Logger logger = LoggerFactory.getLogger(BannerManage.class);
    private static JsonParser jsonParser = new JsonParser();
    private static Gson gson = GsonUtil.getGson();

    public ResultBean insert(String param) {

        Long id = SnowflakeIdWorker.getSnowFlakeId();
        String pictureUrl;
        Byte type;
        Integer sequence = 0;
        JsonObject downloadMessageJson;
        ResultBean downloadMessageBean = new ResultBean();
        String title;
        String attachmentUrl = null;
        try {
            downloadMessageJson = (JsonObject) jsonParser.parse(param);
            title = downloadMessageJson.get("title").getAsString();

            pictureUrl = downloadMessageJson.get("pictureUrl").getAsString();
            type = downloadMessageJson.get("type").getAsByte();
            attachmentUrl = downloadMessageJson.get("attachmentUrl").getAsString();
            if (downloadMessageJson.has("sequence"))
                sequence = downloadMessageJson.get("sequence").getAsInt();
        } catch (Exception e) {
            logger.error("参数传递异常！");
            downloadMessageBean.setCode(0);
            downloadMessageBean.setMsg("参数传递异常！");
            return downloadMessageBean;
        }

        DownLoadMessage downLoadMessage = new DownLoadMessage();
        downLoadMessage.setId(id);
        downLoadMessage.setSequence(sequence);
        downLoadMessage.setType(type);
        downLoadMessage.setPictureUrl(pictureUrl);
        downLoadMessage.setTitle(title);
        downLoadMessage.setAttachmentUrl(attachmentUrl);

        // TODO 需要获取session中的用户
        downLoadMessage.setUpdater("lvpenghui");
        downLoadMessage.setCreator("lvpenghui");

        try {
            AllDao.getInstance().getDownloadMessageDao().insertOne(downLoadMessage);
        } catch (Exception e) {
            downloadMessageBean.setCode(0);
            downloadMessageBean.setMsg("数据插入失败！");
            return downloadMessageBean;
        }

        downloadMessageBean.setCode(1);
        downloadMessageBean.setData(AllDao.getInstance().getDownloadMessageDao().selectById(id));
        downloadMessageBean.setMsg("数据插入成功！");
        return downloadMessageBean;
    }

    public ResultBean getById(String param) {
        ResultBean downloadMessageBean = new ResultBean();
        Long id;
        try {
            id = ((JsonObject) jsonParser.parse(param)).get("id").getAsLong();
        } catch (Exception e) {
            downloadMessageBean.setCode(0);
            downloadMessageBean.setMsg("参数传递异常！");
            logger.error("参数传递异常！");
            return downloadMessageBean;
        }
        DownLoadMessage downLoadMessage = AllDao.getInstance().getDownloadMessageDao().selectById(id);
        downloadMessageBean.setData(downLoadMessage);
        downloadMessageBean.setMsg("数据获取成功！");
        downloadMessageBean.setCode(1);
        return downloadMessageBean;
    }

    public ResultBean getAllByPageNum(String param) {
        ResultBean downloadMessageBean = new ResultBean();
        int startNum;
        int endNum;
        try {
            startNum = ((JsonObject) jsonParser.parse(param)).get("startNum").getAsInt();
            endNum = ((JsonObject) jsonParser.parse(param)).get("endNum").getAsInt();
        } catch (Exception e) {
            downloadMessageBean.setCode(0);
            downloadMessageBean.setMsg("参数传递异常！");
            logger.error("参数传递异常！");
            return downloadMessageBean;
        }
        List<DownLoadMessage> downLoadMessageList = AllDao.getInstance().getDownloadMessageDao().getAllByPageNum(startNum,endNum);
        downloadMessageBean.setData(downLoadMessageList);
        downloadMessageBean.setMsg("数据获取成功！");
        downloadMessageBean.setCode(1);
        return downloadMessageBean;
    }
}
