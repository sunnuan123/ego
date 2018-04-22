package com.bjsxt.result;

import java.io.Serializable;

public class CommonResult implements Serializable{
	private static final long serialVersionUID = -7327051531422625498L;
	
	//状态码
	private Integer status;
	//状态描述
	private String message;
	//成功
	public static CommonResult success() {
		CommonResult commonResult = new CommonResult();
		commonResult.setStatus(200);
		commonResult.setMessage("success");
		return commonResult;
	}
	//失败
	public static CommonResult fail() {
		CommonResult commonResult = new CommonResult();
		commonResult.setStatus(500);
		commonResult.setMessage("fail");
		return commonResult;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
