package com.sunlands.uedservice.processor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sunlands.uedservice.bean.PaginationBean;
import com.sunlands.uedservice.bean.ResultBean;
import com.sunlands.uedservice.mapper.AllDao;
import com.sunlands.uedservice.po.PictureWord;
import com.sunlands.uedservice.po.PublishHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        paginationBean.setPageCount((int) Math.ceil((double)maxRecord/pageSize));

        publishHistoryBean.setData(paginationBean);
        publishHistoryBean.setMsg("数据获取成功！");
        publishHistoryBean.setCode(1);
        return publishHistoryBean;
    }

    public ResultBean getOneTypeByPageNum(String param) {
        ResultBean oneTypePublishHistoryBean = new ResultBean();
        PaginationBean paginationBean = new PaginationBean();
        List<PublishHistory> oneTypePublishHistoryList;
        int pageNum;
        int type;
        int pageSize;
        int maxRecord;
        try {
            pageNum = ((JsonObject) jsonParser.parse(param)).get("pageNum").getAsInt();
            pageSize = ((JsonObject) jsonParser.parse(param)).get("pageSize").getAsInt();
            type = ((JsonObject) jsonParser.parse(param)).get("type").getAsInt();
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
        paginationBean.setPageCount((int) Math.ceil((double)maxRecord/pageSize));

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
                    updateDeleteFlagBean.setData(AllDao.getInstance().getBannerManageDao().getById(id));
                    break;
                case "tb_download_message":
                    AllDao.getInstance().getDownloadMessageDao().updateDeleteFlagById(id);
                    updateDeleteFlagBean.setData(AllDao.getInstance().getDownloadMessageDao().getById(id));
                    break;
                default:
                    AllDao.getInstance().getPictureWordDao().updateDeleteFlagById(id);
                    updateDeleteFlagBean.setData(AllDao.getInstance().getPictureWordDao().getById(id));
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

    public ResultBean goDownload(Long id) {
        ResultBean downLoadMessageBean = new ResultBean();
        String tableChoose = AllDao.getInstance().getPublishHistoryDao().getTableChooseById(id);
        if (tableChoose == null) {
            downLoadMessageBean.setMsg("该id记录不存在或已被删除！");
            downLoadMessageBean.setCode(0);
            logger.error("该id记录不存在或已被删除！");
            return downLoadMessageBean;
        }
        try {
            switch (tableChoose) {
                case "tb_banner_manage":
                    downLoadMessageBean.setData(AllDao.getInstance().getBannerManageDao().getById(id).getPictureUrl());
                    break;
                case "tb_download_message":
                    downLoadMessageBean.setData(AllDao.getInstance().getDownloadMessageDao().getById(id).getAttachmentUrl());
                    break;
                default:
                    downLoadMessageBean.setData(AllDao.getInstance().getPictureWordDao().getById(id).getArticle());
                    break;
            }
        } catch (Exception e) {
            downLoadMessageBean.setMsg("信息获取失败！");
            downLoadMessageBean.setCode(0);
            logger.error("信息获取失败！");
            e.printStackTrace();
            return downLoadMessageBean;
        }
        downLoadMessageBean.setMsg("信息获取成功！");
        downLoadMessageBean.setCode(1);
        return downLoadMessageBean;
    }

}
