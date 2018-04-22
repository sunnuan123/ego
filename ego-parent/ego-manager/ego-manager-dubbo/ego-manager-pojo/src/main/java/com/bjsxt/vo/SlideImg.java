package com.bjsxt.vo;

import java.io.Serializable;

public class SlideImg implements Serializable{
	private static final long serialVersionUID = -541133315928888554L;
	private String url;
	private String picUrl;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
