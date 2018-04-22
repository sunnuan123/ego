package com.bjsxt.service.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.pojo.UsersExample;
import com.bjsxt.result.CommonResult;
import com.bjsxt.service.UsersService;
import com.bjsxt.util.Md5Util;

import redis.clients.jedis.JedisCluster;

@Service(interfaceName=("com.bjsxt.service.UsersService"))
public class UsersServiceImpl implements UsersService{
	@Autowired
	UsersMapper usersMapper;
	
	@Autowired
	JedisCluster jedisCluster;
	
	private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
	
	/**
	 * 注册
	 */
	@SuppressWarnings("unused")
	@Override
	public CommonResult userReg(Users user) {
		
		CommonResult result = null;
		UsersExample example = new UsersExample();
		UsersExample.Criteria criteria1 = example.createCriteria();
		System.out.println(user.getUsername());
		if(user.getUsername() != null && user.getUsername().length()>0) {
			criteria1.andUsernameEqualTo(user.getUsername().trim());
		}
		UsersExample.Criteria criteria2 = example.createCriteria();
		if(user.getEmail() != null && user.getEmail().length() > 0) {
			criteria2.andPasswordEqualTo(user.getEmail().trim());
		}
		example.or(criteria2);
		List<Users> userList = usersMapper.selectByExample(example);
		if(userList.size() > 0 && userList != null) {
			System.out.println("sahsgdajsg");
			result = CommonResult.fail();
			result.setMessage("用户名或者邮箱已经存在");
			return result;
		}else {
			//判断是否为邮箱
			//设置默认值（目前无需qq、手机）
			user.setQq("");
			user.setMobile("");
			String passwd = user.getPassword();
			String uuid = UUID.randomUUID().toString();
			String salt = uuid.substring(uuid.length()-4);
			String passwordDb = Md5Util.md5WithSalt(passwd, salt);
			user.setPassword(passwordDb);
			user.setSalt(salt);
			usersMapper.insertSelective(user);
			result = CommonResult.success();
		}
		return result;
	}
	
	/**
	 * 登录
	 */
	@Override
	public CommonResult userLogin(Users user) {
		UsersExample example = new UsersExample();
		UsersExample.Criteria criteria1 = example.createCriteria();
		if(user.getUsername() != null && user.getUsername().length()>0) {
			criteria1.andUsernameEqualTo(user.getUsername().trim());
		}
		UsersExample.Criteria criteria2 = example.createCriteria();
		if(user.getEmail() != null && user.getEmail().length() > 0) {
			criteria2.andPasswordEqualTo(user.getEmail().trim());
		}
		example.or(criteria2);
		List<Users> userList = usersMapper.selectByExample(example);
		if(userList.size() == 1 && userList != null) {
			Users userDb = userList.get(0);	
			String pwdDb = userDb.getPassword();
			String pwdInput = user.getPassword();
			String salt = userDb.getSalt();
			String pwdMd5 = Md5Util.md5WithSalt(pwdInput, salt);
			if(pwdMd5.equals(pwdDb)) {
				//生成ticket
				String ticket = UUID.randomUUID().toString();
				//将密码设置为空
				userDb.setPassword(null);
				jedisCluster.set(SerializationUtils.serialize(ticket), 
						SerializationUtils.serialize(userDb));
				//返回数据包含ticket
				CommonResult cr = CommonResult.success();
				cr.setMessage(ticket);
				return cr;
			}
			
		}else {
			logger.error("用户名或邮箱存在多个相同数据");
		}
		return CommonResult.fail();
	}
	/**
	 * 验证
	 */
	@Override
	public Users validate(String ticket) {
		Users user = null;
		byte[] res = jedisCluster.get(SerializationUtils.serialize(ticket));
		if(res != null && res.length>0) {
			 user = (Users)SerializationUtils.deserialize(res);
		}
		return user;
	}
}
