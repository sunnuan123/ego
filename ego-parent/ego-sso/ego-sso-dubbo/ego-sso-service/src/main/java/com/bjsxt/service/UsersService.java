package com.bjsxt.service;

import com.bjsxt.pojo.Users;
import com.bjsxt.result.CommonResult;

public interface UsersService {
	/**
	 * 注册
	 */
	CommonResult userReg(Users user);
	/**
	 * 登录
	 */
	CommonResult userLogin (Users user);
	
	/**
	 * 验证
	 */
	Users validate(String ticket);
}
