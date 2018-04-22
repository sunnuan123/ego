package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.ContentCategory;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiTreeResult;

public interface ContentCategoryService {
	/**
	 * 查询所有
	 */
	public List<EuiTreeResult> findById(Long id);
	
	/**
	 * 添加或更新
	 */
	public CommonResult addOrUpdate(ContentCategory contentCategory);
	/**
	 * 删除
	 */
	public CommonResult delete(Long id);
}
