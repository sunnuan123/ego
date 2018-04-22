package com.bjsxt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjsxt.mapper.ContentMapper;
import com.bjsxt.pojo.Content;
import com.bjsxt.pojo.ContentExample;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiDataGridResult;
import com.bjsxt.service.ContentService;
import com.bjsxt.util.StringUtil;
import com.bjsxt.vo.SlideImg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(interfaceName="com.bjsxt.service.ContentService")
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	ContentMapper contentMapper;
	
	@Value("${index.slide.cat.id}")
	private Long categoryId;
	
	@Value("${index.cf.cat.id}")
	private Long iccd;
	/**
	 * 分页查询
	 */
	@Override
	public EuiDataGridResult findByPage(Integer pageNum,Integer pageSize,Long categoryId) {
		
		//分页
		PageHelper.startPage(pageNum,pageSize);
		
		ContentExample example = new ContentExample();
		example.setOrderByClause("id desc");
		if(categoryId!=null && categoryId!=0) {
			//条件
			example.createCriteria().andCategoryIdEqualTo(categoryId);
		}
		//查询
		List<Content> contentList = contentMapper.selectByExample(example);
		
		//封装分页对象
		PageInfo<Content> pageInfo = new PageInfo<>(contentList);
		
		//返回结果
		EuiDataGridResult result = new EuiDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(contentList);
		return result; 
	}
	/**
	 * 保存或更新
	 */
	@Override
	public CommonResult saveOrUpdate(Content content) {
		Long id = content.getId();
		content.setUpdated(new Date());
		
		int updateCount = 0;
		if(id!=null && id>0) {//更新
			updateCount = contentMapper.updateByPrimaryKeySelective(content);
		}else {//保存
			content.setCreated(new Date());
			updateCount = contentMapper.insertSelective(content);
		}
		
		if(1==updateCount) {
			return CommonResult.success();
		}
		return CommonResult.fail();
	}
	
	/**
	 * 根据ids删除
	 */
	@Override
	public CommonResult deleteByIds(String ids) {
		//将ids转换为list
		List<Long> idList =  StringUtil.str2ListLong(ids);
		
		if(idList!=null && idList.size()>0) {
			ContentExample example = new ContentExample();
			example.createCriteria().andIdIn(idList);
			int count = contentMapper.deleteByExample(example);
			if(count>0) {
				return CommonResult.success();
			}
		}
		return CommonResult.fail();
	}
	
	/**
	 * 查询首页轮播图
	 */
	@Override
	public List<SlideImg> findSlideIndex() {
		//返回结果
		List<SlideImg> imageList = new ArrayList<>();
		
		ContentExample example = new ContentExample();
		//条件
		example.createCriteria().andCategoryIdEqualTo(categoryId);
		List<Content> contentList = contentMapper.selectByExample(example);
		
		if(contentList!=null && contentList.size()>0) {
			for(Content content:contentList) {
				SlideImg img = new SlideImg();
				img.setUrl(content.getUrl());
				img.setPicUrl(content.getPic());
				imageList.add(img);
			}
		}
		return imageList;
	}
	/**
	 * 查询首页品牌
	 */
	@Override
	public List<String> findCfIndex() {
		ContentExample ce = new ContentExample();
		//条件
		ce.createCriteria().andCategoryIdEqualTo(iccd);
		List<Content> list = contentMapper.selectByExampleWithBLOBs(ce);
		List<String> listStr = new ArrayList<>();
		for (Content content : list) {
			listStr.add(content.getContent());
		}
		return listStr;
	}
	
}
