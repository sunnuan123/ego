package com.bjsxt.service;

import com.bjsxt.pojo.Goods;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiDataGridResult;

public interface GoodsService {
	/**
	 * 保存商品
	 * @param goods
	 * @return
	 */
	public CommonResult save(Goods goods);
	/**
	 * 分页查询
	 */
	public EuiDataGridResult findByPage(Integer page, Integer size);
	
	/**
	 * 更新商品
	 */
	public CommonResult updateById(Goods goods);
	
	/**
	 * 批量删除商品
	 */
	public CommonResult deleteByIds(String ids);
	
}
