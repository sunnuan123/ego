package com.bjsxt.mapper.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjsxt.mapper.GoodsMapper;
import com.bjsxt.pojo.Goods;
import com.bjsxt.pojo.GoodsExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring-*.xml")
public class GoodsMapperTest {
	@Autowired
	GoodsMapper goodsMapper;
	
	/**
	 * 分页1
	 */
	@Test
	public void findByPage1() {
		PageHelper.offsetPage(1, 10);
		GoodsExample example = new GoodsExample();
		example.createCriteria().andGoodsNameLike("%手机%");
		List<Goods> goodsList = goodsMapper.selectByExample(example);
		//分页对象
		PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodsList);
		System.out.println(pageInfo);
		for (Goods goods : pageInfo.getList()) {
			System.out.println(goods);
		}
	}
	/**
	 * 分页2
	 */
	@Test
	public void findByPage2() {
		GoodsExample example = new GoodsExample();
		example.createCriteria().andGoodsNameLike("%手机%");
		example.setOffset(0);
		example.setLimit(20);
		//查询总数
		Long count = goodsMapper.countByExample(example);
		//查询列表
		List<Goods> goodsList = goodsMapper.selectByExample(example);
		
		//分页对象
		System.out.println("count："+count);
		System.out.println("goodsList:"+goodsList);
	}
	
}
