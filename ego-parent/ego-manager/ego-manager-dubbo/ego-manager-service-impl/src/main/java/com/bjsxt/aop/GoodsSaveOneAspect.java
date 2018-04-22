package com.bjsxt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.bo.GoodsBo;
import com.bjsxt.pojo.Goods;
import com.bjsxt.service.SolrGoodsService;

@Component
@Aspect
public class GoodsSaveOneAspect {
	
	@Reference
	SolrGoodsService solrGoodsService;
	
	@Pointcut("execution(* com.bjsxt.service.impl.GoodsServiceImpl.saveOne(..))")
	public void saveOne() {}
	
	@AfterReturning("saveOne()")
	public void addDocSolr(JoinPoint joinPoint) {
		//获取被调用方法的传参
		Object[] args = joinPoint.getArgs();
		if(args.length > 0 && args != null) {
			Object obj = args[0];
			Goods goods = (Goods)obj;
			GoodsBo goodsBo = new GoodsBo();
			goodsBo.setGoodsName(goods.getGoodsName());
			goodsBo.setOriginalImg(goods.getOriginalImg());
			goodsBo.setShopPrice(goods.getShopPrice());
			solrGoodsService.addGoodsToSolr(goodsBo);
		}
		
		
	}
	
}
