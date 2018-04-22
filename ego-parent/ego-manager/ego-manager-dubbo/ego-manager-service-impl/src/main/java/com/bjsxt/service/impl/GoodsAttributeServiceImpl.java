package com.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjsxt.mapper.GoodsAttributeMapper;
import com.bjsxt.pojo.GoodsAttribute;
import com.bjsxt.pojo.GoodsAttributeExample;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiDataGridResult;
import com.bjsxt.service.GoodsAttributeService;
import com.bjsxt.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(interfaceName="com.bjsxt.service.GoodsAttributeService")
public class GoodsAttributeServiceImpl implements GoodsAttributeService{
	
	@Autowired
	GoodsAttributeMapper goodsAttributeMapper;
	/**
	 * 分页查询
	 */
	@Override
	public EuiDataGridResult findByPage(Integer page, Integer size) {
		PageHelper.startPage(page, size);
		GoodsAttributeExample example = new GoodsAttributeExample();
		example.setOrderByClause("id desc");
		List<GoodsAttribute> goodsAttribute = goodsAttributeMapper.selectByExample(example);
		PageInfo<GoodsAttribute> pageInfo = new PageInfo<GoodsAttribute>(goodsAttribute);
		EuiDataGridResult result = new EuiDataGridResult();
		result.setRows(goodsAttribute);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	/**
	 * 增加或修改
	 */
	@Override
	public CommonResult saveOrUpdate(GoodsAttribute goodsAttribute) {
		CommonResult cr = new CommonResult();
		Integer id = goodsAttribute.getId();
		Integer res;
		if(id != null && id > 0) {
			//更新
			res = goodsAttributeMapper.updateByPrimaryKeySelective(goodsAttribute);
		}else {
			//保存
			res = goodsAttributeMapper.insertSelective(goodsAttribute);
		}
		if(1==res){
			return cr.success();
		}
		return cr.fail();
	}
	/**
	 * 查询
	 */
	@Override
	public GoodsAttribute findById(Integer id) {
		GoodsAttribute goodsAttribute = goodsAttributeMapper.selectByPrimaryKey(id);
		return goodsAttribute;
	}
	/**
	 * 批量删除
	 */
	@Override
	public CommonResult deleteByIds(String ids) {
		List<Integer> list = StringUtil.Str2List(ids);
		GoodsAttributeExample example = new GoodsAttributeExample();
		example.createCriteria().andIdIn(list);
		Integer res = goodsAttributeMapper.deleteByExample(example);
		CommonResult cr = new CommonResult();
		if(res>0){
			return cr.success();
		}
		return cr.fail();
	}

}
