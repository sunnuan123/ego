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
public class GoodsUpdateByIdAspect {
	@Reference
	SolrGoodsService solrGoodsService;
	
	@Pointcut("execution(* com.bjsxt.service.impl.GoodsServiceImpl.updateById(..))")
	public void updateById() {}
	
	@AfterReturning("updateById()")
	public void addDocSolr(JoinPoint joinPoint) {
		//获取被调用方法的传参
		Object[] args = joinPoint.getArgs();
		if(args != null && args.length>0) {
			Object obj = args[0];
			Goods goods = (Goods)obj;
			GoodsBo goodsBo = new GoodsBo();
			goodsBo.setId(goods.getId());
			goodsBo.setGoodsName(goods.getGoodsName());
			goodsBo.setOriginalImg(goods.getOriginalImg());
			goodsBo.setShopPrice(goods.getShopPrice());
			solrGoodsService.addGoodsToSolr(goodsBo);
		}
	}
}
