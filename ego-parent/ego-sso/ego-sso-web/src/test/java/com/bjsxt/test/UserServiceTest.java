package com.bjsxt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.pojo.Users;
import com.bjsxt.result.CommonResult;
import com.bjsxt.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:dubbo-consumer.xml")
public class UserServiceTest {
	@Reference
	UsersService userService;
	
	/**
	 * 登录测试
	 */
	@Test
	public void testLogin() {
		Users user = new Users();
		user.setUsername("sxt");
		user.setPassword("123456");
		CommonResult cr = userService.userLogin(user);
		System.out.println(cr.getStatus()+":"+cr.getMessage());
	}
	/**
	 * 验证测试
	 */
	@Test
	public void testVal() {
		String ticket = "fab8c2c4-08b6-4fca-957f-d086057b47fc";
		Users user = userService.validate(ticket);
		System.out.println(user.getUsername());
		System.out.println(user);
	}
}
