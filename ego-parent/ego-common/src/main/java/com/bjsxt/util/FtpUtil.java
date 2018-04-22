package com.bjsxt.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FtpUtil {
	
	private static String hostCommon = null; 
	
	/**
	 * 初始化
	 * @return
	 * @throws SocketException
	 * @throws IOException
	 */
	public static FTPClient init(String host,Integer port,String username,String password) throws SocketException, IOException {
		hostCommon = host;
		FTPClient client = new FTPClient();
		//1.连接
		client.connect(host, port);
		//2.登录
		client.login(username, password);
		return client;
	}
	
	
	/**
	 * 上传文件
	 * @param client
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static String upload(FTPClient client,String basePath,String suffix,InputStream inputStram) throws IOException, FileNotFoundException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String pathDate = sdf.format(new Date());
		String path = basePath+"/"+pathDate;
		
		String pathArray[] = path.split("/");
		String realPath = "/";
		for(String p:pathArray) {
			if(p!=null && p.trim().length()>0) {
				realPath += (p+"/");
				//3.指定上传路径  返回true路径存在 反之路径不存在
				boolean exists = client.changeWorkingDirectory(realPath);
				if(!exists) {
					//4.创建目录
					client.makeDirectory(realPath);
				}
			}
		}
		//重新指定上传路径
		client.changeWorkingDirectory(path);
		
		//5.指定文件类型
		client.setFileType(FTP.BINARY_FILE_TYPE);
		//获取文件后缀
		//6.执行上传 参数1:上传成功后的文件名  参数2：输入流
		String remote = UUID.randomUUID().toString();
		client.storeFile(remote+"."+suffix,inputStram);
		return "http://"+hostCommon+"/"+pathDate+"/"+remote+"."+suffix;
	}
	
	/**
	 * 销毁
	 * @param client
	 * @throws IOException
	 */
	public static void destory(FTPClient client) throws IOException {
		//7.退出
		client.logout();
		//8.断开连接
		client.disconnect();
	}
}
