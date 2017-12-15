package com.sunlands.uedservice.processor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sunlands.uedservice.bean.PaginationBean;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.mapper.AllDao;
import com.sunlands.uedservice.po.DownLoadMessage;
import com.sunlands.uedservice.po.PictureWord;
import com.sunlands.uedservice.po.PublishHistory;
import com.sunlands.uedservice.utils.NameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 11:05 2017/12/7
 * @ModifiedBy :
 */

public class PublishHistoryProcessor {
    private static Logger logger = LoggerFactory.getLogger(PictureWord.class);
    private static JsonParser jsonParser = new JsonParser();

    public ResultBean getAllByPageNum(String param) {
        ResultBean publishHistoryBean = new ResultBean();
        PaginationBean paginationBean = new PaginationBean();
        int pageSize;
        int pageNum;
        int maxRecord;
        List<PublishHistory> publishHistoryList;
        try {
            pageNum = ((JsonObject) jsonParser.parse(param)).get("pageNum").getAsInt();
            pageSize = ((JsonObject) jsonParser.parse(param)).get("pageSize").getAsInt();
            publishHistoryList = AllDao.getInstance().getPublishHistoryDao().getAllByPageNum((pageNum - 1) * pageSize, pageNum * pageSize);
            paginationBean.setList(publishHistoryList);
        } catch (Exception e) {
            publishHistoryBean.setCode(0);
            publishHistoryBean.setMsg("参数传递异常！");
            logger.error("参数传递异常！");
            e.printStackTrace();
            return publishHistoryBean;
        }

        maxRecord = AllDao.getInstance().getPublishHistoryDao().getMaxRecord();
        paginationBean.setPageSize(pageSize);
        paginationBean.setMaxRecord(maxRecord);
        paginationBean.setPageCount((int) Math.ceil((double) maxRecord / pageSize));

        publishHistoryBean.setData(paginationBean);
        publishHistoryBean.setMsg("数据获取成功！");
        publishHistoryBean.setCode(1);
        return publishHistoryBean;
    }

    public ResultBean getOneTypeByPageNum(String param) {
        ResultBean oneTypePublishHistoryBean = new ResultBean();
        PaginationBean paginationBean = new PaginationBean();
        List<PublishHistory> oneTypePublishHistoryList;
        JsonObject oneTypeJson;
        int pageNum = 1;
        int type = 1;
        int pageSize = 12;
        int maxRecord;
        try {
            if (param != null && param.trim().length() != 0) {
                oneTypeJson = (JsonObject) jsonParser.parse(param);
                if (oneTypeJson.has(NameUtil.PAGENUM)) {
                    pageNum = ((JsonObject) jsonParser.parse(param)).get("pageNum").getAsInt();
                }
                if (oneTypeJson.has(NameUtil.PAGESIZE)) {
                    pageSize = ((JsonObject) jsonParser.parse(param)).get("pageSize").getAsInt();
                }
                if (oneTypeJson.has(NameUtil.TYPE)) {
                    type = ((JsonObject) jsonParser.parse(param)).get("type").getAsInt();
                }
            }

            oneTypePublishHistoryList = AllDao.getInstance().getPublishHistoryDao().getOneTypeByPageNum(type, (pageNum - 1) * pageSize, pageNum * pageSize);
            paginationBean.setList(oneTypePublishHistoryList);
        } catch (Exception e) {
            oneTypePublishHistoryBean.setCode(0);
            oneTypePublishHistoryBean.setMsg("参数传递异常！");
            e.printStackTrace();
            logger.error("参数传递异常！");
            return oneTypePublishHistoryBean;
        }

        maxRecord = AllDao.getInstance().getPublishHistoryDao().getOneTypeMaxRecord(type);
        paginationBean.setPageSize(pageSize);
        paginationBean.setMaxRecord(maxRecord);
        paginationBean.setPageCount((int) Math.ceil((double) maxRecord / pageSize));

        oneTypePublishHistoryBean.setData(paginationBean);
        oneTypePublishHistoryBean.setMsg("数据获取成功！");
        oneTypePublishHistoryBean.setCode(1);
        return oneTypePublishHistoryBean;
    }

    public ResultBean updateDeleteFlagById(String param) {
        ResultBean updateDeleteFlagBean = new ResultBean();
        Long id;
        try {
            id = ((JsonObject) jsonParser.parse(param)).get("id").getAsLong();
        } catch (Exception e) {
            updateDeleteFlagBean.setCode(0);
            e.printStackTrace();
            updateDeleteFlagBean.setMsg("参数传递异常！");
            logger.error("参数传递异常！");
            return updateDeleteFlagBean;
        }

        String tableChoose = AllDao.getInstance().getPublishHistoryDao().getTableChooseById(id);
        if (tableChoose == null) {
            updateDeleteFlagBean.setCode(0);
            updateDeleteFlagBean.setMsg("该id记录不存在或已被删除！");
            logger.error("该id记录不存在或已被删除！");
            return updateDeleteFlagBean;
        }
        try {
            AllDao.getInstance().getPublishHistoryDao().updateDeleteFlagById(id);
            switch (tableChoose) {
                case "tb_banner_manage":
                    AllDao.getInstance().getBannerManageDao().updateDeleteFlagById(id);
                    break;
                case "tb_download_message":
                    AllDao.getInstance().getDownloadMessageDao().updateDeleteFlagById(id);
                    break;
                default:
                    AllDao.getInstance().getPictureWordDao().updateDeleteFlagById(id);
                    break;
            }
        } catch (Exception e) {
            updateDeleteFlagBean.setCode(0);
            e.printStackTrace();
            updateDeleteFlagBean.setMsg("删除失败！");
            logger.error("删除失败！");
            return updateDeleteFlagBean;
        }

        updateDeleteFlagBean.setMsg("删除成功！");
        updateDeleteFlagBean.setCode(1);
        return updateDeleteFlagBean;
    }

    public String goDownload(Long id) {
        DownLoadMessage downLoadMessage = AllDao.getInstance().getDownloadMessageDao().selectById(id);
        if (downLoadMessage == null) {
            return null;
        }else{
            return downLoadMessage.getAttachmentUrl();
        }

    }


    public ResultBean getShared(String param) {
        ResultBean sharedBean = new ResultBean();
        Long id;
        PictureWord pictureWord;
        PictureWord returnPictureWord = new PictureWord();
        try {
            id = ((JsonObject) jsonParser.parse(param)).get("id").getAsLong();
        } catch (Exception e) {
            e.printStackTrace();
            sharedBean.setMsg("参数传递异常！");
            logger.error("参数传递异常！");
            sharedBean.setCode(0);
            return sharedBean;
        }

        pictureWord = AllDao.getInstance().getPictureWordDao().selectById(id);
        if (pictureWord == null) {
            sharedBean.setMsg("该id记录不存在或已被删除！");
            logger.error("该id记录不存在或已被删除！");
            sharedBean.setCode(0);
            return sharedBean;
        }

        try {
            pictureWord = AllDao.getInstance().getPictureWordDao().getSharedMessage(id);
        } catch (Exception e) {
            sharedBean.setMsg("详细信息获取失败！");
            sharedBean.setCode(0);
            logger.error("详细信息获取失败！");
            e.printStackTrace();
            return sharedBean;
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-DD");
        Date d = pictureWord.getCreateTime();

        returnPictureWord.setDate(df.format(d));
        returnPictureWord.setArticle(pictureWord.getArticle());
        returnPictureWord.setViewCount(pictureWord.getViewCount());
        returnPictureWord.setTitle(pictureWord.getTitle());

        sharedBean.setData(returnPictureWord);
        sharedBean.setMsg("信息获取成功！");
        sharedBean.setCode(1);
        return sharedBean;
    }
}
