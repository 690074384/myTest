package com.sunlands.uedservice.po;

/**
 * 超类
 * @author lvpenghui
 * @date 2017/12/6 11:59
 */
public class Root {
    private Long id;
    private String pictureUrl;
    private Byte deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
