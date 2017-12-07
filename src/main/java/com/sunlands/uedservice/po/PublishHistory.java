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
    private Integer downloadTimes;
    private String tableChoose;

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

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public String getTableChoose() {
        return tableChoose;
    }

    public void setTableChoose(String tableChoose) {
        this.tableChoose = tableChoose;
    }
}
