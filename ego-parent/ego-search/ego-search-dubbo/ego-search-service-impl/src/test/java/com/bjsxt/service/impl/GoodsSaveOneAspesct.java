package com.bjsxt.service.impl;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GoodsSaveOneAspesct {
	@Pointcut("execution(* com.bjsxt.service.impl.GoodsServiceImpl.saveOne(..))")
	public void saveOne() {}
	
	@AfterReturning("saveOne()")
	public void addSolr() {
		System.out.println("正在添加solr");
	}
	
}
