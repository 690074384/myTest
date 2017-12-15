package com.sunlands.uedservice.po;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:07
 */
public class PictureWord extends PublishMessage{
    private String article;
    private Integer viewCount;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

}
