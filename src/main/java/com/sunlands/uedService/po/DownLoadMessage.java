package com.sunlands.uedService.po;


/**
 * @author lvpenghui
 * @date 2017/12/6 12:03
 */
public class DownLoadMessage extends PublishMessage{
    private String title;
    private String attachmentUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }
}
