package com.bjsxt.service;

import java.util.List;

import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiTreeResult;
import com.bjsxt.vo.MenuCateName;

public interface GoodsCategoryService {
	/**
	 * 树形目录结构
	 * @param id
	 * @return
	 */
	public List<EuiTreeResult> findTreeByPid(Short id);
	/**
	 * 展示商品目录
	 */
	public List<MenuCateName> ShowMenu( Integer pid, Integer level); 
	/**
	 * 清除缓存
	 * @return
	 */
	
	public CommonResult clearGoodsCatMenu();
}
