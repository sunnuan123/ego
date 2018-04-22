package com.bjsxt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.util.FtpUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping("/pic")
public class PicController {
	@Value("${ftp.host}")
	private String host;
	
	@Value("${ftp.port}")
	private Integer port;
	
	@Value("${ftp.username}")
	private String username;
	
	@Value("${ftp.password}")
	private String password;
	
	@Value("${ftp.basePath}")
	private String basePath;
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile uploadFile) {
		System.out.println(uploadFile);
		//返回结果
		Map<String, Object> result = new HashMap<>();
		FTPClient client = null;
		
		try {
			client = FtpUtil.init(host, port, username, password);
			//获取后缀名
			String fileName = uploadFile.getOriginalFilename();
			String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
			//上传
			String picUrl = FtpUtil.upload(client, basePath, suffix, uploadFile.getInputStream());
			System.out.println("picUrl是"+picUrl);
			//回显
			result.put("error", 0);
			result.put("url", picUrl);
			
		}catch (IOException e) {
			result.put("error", 1);
			result.put("message", "系统正在升级中，请稍后再试!");
		}finally {
			try {
				if(client != null) {
					FtpUtil.destory(client);
				}
			} catch (IOException e) {
				result.put("error", 1);
				result.put("message", "系统正在升级中，请稍后再试!");
			}
		}
		
		return new Gson().toJson(result);
	}
}
