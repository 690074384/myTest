package com.sunlands.uedservice.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 16:34 2017/12/15
 * @ModifiedBy :
 */
@Component
@ConfigurationProperties
public class DownloadLocationBean {
    private String pictureUrl;
    private String attachmentUrl;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }
}
