package com.bjsxt.service;

import com.bjsxt.pojo.GoodsAttribute;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiDataGridResult;

public interface GoodsAttributeService {
	
	/**
	 * 分页查询
	 */
	public EuiDataGridResult findByPage(Integer page, Integer size);
	/**
	 * 根据id查询
	 */
	public GoodsAttribute findById(Integer id);
	/**
	 * 增加或修改
	 */
	public CommonResult saveOrUpdate(GoodsAttribute goodsAttribute);
	/**
	 * 删除
	 */
	public CommonResult deleteByIds(String ids);
}
