package com.sunlands.uedservice.mapper;

import com.sunlands.uedservice.utils.SpringContextUtil;
import org.springframework.context.ApplicationContext;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 16:52 2017/12/6
 * @ModifiedBy :
 */
public class AllDao {
    private BannerManageMapper bannerManageDao;
    private DownloadMessageMapper downloadMessageDao;
    private LoginMapper loginDao;
    private PictureWordMapper pictureWordDao;
    private PublishHistoryMapper publishHistoryDao;

    private static AllDao instance = null;
    public static AllDao getInstance() {
        if (instance == null) {
            ApplicationContext context = SpringContextUtil.getApplicationContext();
            instance = (AllDao) context.getBean("allDao");
        }
        return instance;
    }

    public BannerManageMapper getBannerManageDao() {
        return bannerManageDao;
    }

    public void setBannerManageDao(BannerManageMapper bannerManageDao) {
        this.bannerManageDao = bannerManageDao;
    }

    public DownloadMessageMapper getDownloadMessageDao() {
        return downloadMessageDao;
    }

    public void setDownloadMessageDao(DownloadMessageMapper downloadMessageDao) {
        this.downloadMessageDao = downloadMessageDao;
    }

    public LoginMapper getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginMapper loginDao) {
        this.loginDao = loginDao;
    }

    public PictureWordMapper getPictureWordDao() {
        return pictureWordDao;
    }

    public void setPictureWordDao(PictureWordMapper pictureWordDao) {
        this.pictureWordDao = pictureWordDao;
    }

    public PublishHistoryMapper getPublishHistoryDao() {
        return publishHistoryDao;
    }

    public void setPublishHistoryDao(PublishHistoryMapper publishHistoryDao) {
        this.publishHistoryDao = publishHistoryDao;
    }
}
