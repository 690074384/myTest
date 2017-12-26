package com.sunlands.uedservice.po;
/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 11:48 2017/12/7
 * @ModifiedBy :
 */
public class PublishHistory extends Root{
    private String title;
    private Byte type;
    private String tableChoose;
    private Integer downloadNum;
    private String attachmentUrl;

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public Integer getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Integer downloadNum) {
        this.downloadNum = downloadNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }


    public String getTableChoose() {
        return tableChoose;
    }

    public void setTableChoose(String tableChoose) {
        this.tableChoose = tableChoose;
    }
}
