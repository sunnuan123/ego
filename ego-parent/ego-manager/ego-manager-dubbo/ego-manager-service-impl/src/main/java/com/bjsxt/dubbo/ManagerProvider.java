package com.bjsxt.dubbo;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class ManagerProvider {

	public static void main(String[] args) throws InterruptedException {
		//1.加载配置文件
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");
		//2.启动
		context.start();
		//3.禁用程序自动关闭
		while(true) {
			System.out.println("ego-manager发布服务成功！");
			Thread.sleep(60*1000);
		}
	}
}
