package com.sunlands.uedservice.po;


/**
 * @author lvpenghui
 * @date 2017/12/6 12:03
 */
public class DownLoadMessage extends PublishMessage{
    private String attachmentUrl;

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }
}
