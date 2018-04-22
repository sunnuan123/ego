package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Content;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiDataGridResult;
import com.bjsxt.vo.SlideImg;

public interface ContentService {

	/**
	 * 分页查询
	 */
	EuiDataGridResult findByPage(Integer pageNum,Integer pageSize,Long categoryId);
	/**
	 * 保存或更新
	 */
	CommonResult saveOrUpdate(Content content);
	/**
	 * 根据ids删除
	 */
	CommonResult deleteByIds(String ids);
	/**
	 * 查询首页轮播图
	 */
	List<SlideImg> findSlideIndex();
	/**
	 * 查询首页品牌
	 */
	List<String> findCfIndex();
	
}
