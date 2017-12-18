package com.sunlands.uedservice.processor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sunlands.uedservice.bean.PaginationBean;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.mapper.AllDao;
import com.sunlands.uedservice.po.DownLoadMessage;
import com.sunlands.uedservice.po.PublishHistory;
import com.sunlands.uedservice.utils.SnowflakeIdWorker;
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

    private static Logger logger = LoggerFactory.getLogger(DownLoadMessage.class);
    private static JsonParser jsonParser = new JsonParser();

    public ResultBean insert(String param,String account) {

        Long id = SnowflakeIdWorker.getSnowFlakeId();
        String pictureUrl;
        Byte type;
        JsonObject downloadMessageJson;
        ResultBean downloadMessageBean = new ResultBean();
        String title;
        String attachmentUrl;
        try {
            downloadMessageJson = (JsonObject) jsonParser.parse(param);
            title = downloadMessageJson.get("title").getAsString();

            pictureUrl = downloadMessageJson.get("pictureUrl").getAsString();
            type = downloadMessageJson.get("type").getAsByte();
            attachmentUrl = downloadMessageJson.get("attachmentUrl").getAsString();
        } catch (Exception e) {
            logger.error("参数传递异常！");
            downloadMessageBean.setCode(0);
            downloadMessageBean.setMsg("参数传递异常！");
            return downloadMessageBean;
        }

        DownLoadMessage downLoadMessage = new DownLoadMessage();
        downLoadMessage.setId(id);
        downLoadMessage.setType(type);
        downLoadMessage.setPictureUrl(pictureUrl);
        downLoadMessage.setTitle(title);
        downLoadMessage.setAttachmentUrl(attachmentUrl);

        downLoadMessage.setUpdater(account);
        downLoadMessage.setCreator(account);

        PublishHistory publishHistory = new PublishHistory();
        publishHistory.setId(id);
        publishHistory.setPictureUrl(pictureUrl);
        publishHistory.setTitle(title);
        publishHistory.setType(type);
        publishHistory.setTableChoose("tb_download_message");
        publishHistory.setDeleteFlag((byte) 0);

        try {
            AllDao.getInstance().getDownloadMessageDao().insertOne(downLoadMessage);
            AllDao.getInstance().getPublishHistoryDao().insertOne(publishHistory);
        } catch (Exception e) {
            downloadMessageBean.setCode(0);
            downloadMessageBean.setMsg("数据插入失败！");
            e.printStackTrace();
            return downloadMessageBean;
        }

        downloadMessageBean.setCode(1);
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
        DownLoadMessage downLoadMessage = AllDao.getInstance().getDownloadMessageDao().getById(id);
        downloadMessageBean.setData(downLoadMessage);
        downloadMessageBean.setMsg("数据获取成功！");
        downloadMessageBean.setCode(1);
        return downloadMessageBean;
    }

    public ResultBean getAllByPageNum(String param) {
        ResultBean downloadMessageBean = new ResultBean();
        PaginationBean paginationBean = new PaginationBean();
        List<DownLoadMessage> downLoadMessageList;
        int pageNum;
        int pageSize;
        int maxRecord;
        try {
            pageNum = ((JsonObject) jsonParser.parse(param)).get("pageNum").getAsInt();
            pageSize = ((JsonObject) jsonParser.parse(param)).get("pageSize").getAsInt();
            downLoadMessageList = AllDao.getInstance().getDownloadMessageDao().getAllByPageNum((pageNum - 1) * pageSize, pageNum * pageSize);
            paginationBean.setList(downLoadMessageList);
        } catch (Exception e) {
            e.printStackTrace();
            downloadMessageBean.setCode(0);
            downloadMessageBean.setMsg("参数传递异常！");
            logger.error("参数传递异常！");
            return downloadMessageBean;
        }

        maxRecord = AllDao.getInstance().getDownloadMessageDao().getMaxRecord();
        paginationBean.setPageSize(pageSize);
        paginationBean.setMaxRecord(maxRecord);
        paginationBean.setPageCount((int) Math.ceil((double)maxRecord/pageSize));

        downloadMessageBean.setData(paginationBean);
        downloadMessageBean.setMsg("数据获取成功！");
        downloadMessageBean.setCode(1);
        return downloadMessageBean;
    }
}
