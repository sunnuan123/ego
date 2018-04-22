package com.bjsxt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.pojo.Users;
import com.bjsxt.result.CommonResult;
import com.bjsxt.service.UsersService;
import com.bjsxt.util.CookieUtil;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Reference
	UsersService userService;
	
	@Value("${cookie.ticket.name}")
	String ticketName;
	
	/**
	 * 转发到注册页面
	 * @return
	 */
	@RequestMapping("/register")
	public String register() {
		return "registor";
	}
	/**
	 * 用户注册
	 */
	@RequestMapping("/reg")
	@ResponseBody
	public CommonResult reg(Users users, String usernameOrmail) {
		if (usernameOrmail.contains("@")) {
			users.setEmail(usernameOrmail);
		}else {
			users.setUsername(usernameOrmail);
		}
		CommonResult cr = userService.userReg(users);
		System.out.println(cr);
		return cr;
	}
	
	/**
	 * 跳转到登录页
	 */
	@RequestMapping("/toLogin")
	public String toLogin(String redirectUrl, Map<String, Object> map) {
		map.put("redirectUrl", redirectUrl);
		return "login";
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping("/login")
	@ResponseBody
	public CommonResult login(String usernameOrEmail, String password, 
			HttpServletRequest request, HttpServletResponse response){
		Users user = new Users();
		user.setPassword(password);
		if(usernameOrEmail.contains("@")) {
			user.setEmail(usernameOrEmail);
		}else {
			user.setUsername(usernameOrEmail);
		}
		CommonResult result = userService.userLogin(user);
		if(200 == result.getStatus()) {
			String ticket = result.getMessage();
			CookieUtil.setCookie(request, response, ticketName, ticket);
		}
		return result;
	}
	
}
