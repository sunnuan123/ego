package com.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjsxt.mapper.GoodsMapper;
import com.bjsxt.pojo.Goods;
import com.bjsxt.pojo.GoodsExample;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiDataGridResult;
import com.bjsxt.service.GoodsService;
import com.bjsxt.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(interfaceName="com.bjsxt.service.GoodsService")
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	GoodsMapper goodsMapper;
	
	/**
	 * 保存商品
	 */
	@Override
	public CommonResult save(Goods goods) {
		Integer res = goodsMapper.insertSelective(goods);
		if(1 == res) {
			return CommonResult.success();
		}else {
			return CommonResult.fail();
		}
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public EuiDataGridResult findByPage(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="10") Integer rows) {
		PageHelper.startPage(page, rows);
		
		GoodsExample example = new GoodsExample();
		example.setOrderByClause("id desc");
		List<Goods> goodsList = goodsMapper.selectByExample(example);
		PageInfo<Goods> pageInfo  = new PageInfo<Goods>(goodsList);
		EuiDataGridResult result = new EuiDataGridResult();
		
		result.setRows(goodsList);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}
	
	/**
	 * 更新商品
	 */
	@Override
	public CommonResult updateById(Goods goods) {
		CommonResult cr = new CommonResult();
		Integer res = goodsMapper.updateByPrimaryKeySelective(goods);
		if(1==res) {
			return cr.success();
		}
		return cr.fail();
	}
	
	/**
	 * 批量删除
	 */
	@Override
	public CommonResult deleteByIds(String ids) {
		List<Integer> values = StringUtil.Str2List(ids);
		GoodsExample example = new GoodsExample();
		example.createCriteria().andIdIn(values);
		Integer res = goodsMapper.deleteByExample(example);
		CommonResult cr = new CommonResult();
		if(res>0) {
			return cr.success();
		}
		return cr.fail();
	}

}
