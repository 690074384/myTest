package com.sunlands.uedservice.po;

import java.util.Date;

/**
 * @author lvpenghui
 * @date 2017/12/6 12:08
 */
public class User extends Root {
	private String name;
	private String email;
	private Date loginTime;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getLoginTime() {
		return loginTime;
	}
	
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
}
