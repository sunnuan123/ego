package com.bjsxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
import com.bjsxt.util.CookieUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Value("${cookie.ticket.name}")
	String ticketName;
	@Value("${sso.login.url}")
	String ssoLoginUrl;
	
	@Reference
	UsersService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取ticket
		String ticket = CookieUtil.getCookieValue(request, ticketName);
		if(ticket != null && ticket.length() > 0) {
			Users user = userService.validate(ticket);
			if(user != null) {
				return true;
			}
		}
		String redUrl = request.getRequestURL().toString();
		response.sendRedirect(ssoLoginUrl+"?redirectUrl="+redUrl);
		
		return false;
	}
	
	
	
}
