package com.sunlands.uedservice.po;

import java.util.Date;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:09
 */
public class PublishMessage extends Root {
	private Byte type;
	private Integer downloadTimes;
	private String creator;
	private String updater;
	private Date createTime;
	private Date updateTime;
	private Integer sequence;
	
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
	
	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String getUpdater() {
		return updater;
	}
	
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Integer getSequence() {
		return sequence;
	}
	
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
}
