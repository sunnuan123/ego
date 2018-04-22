package com.bjsxt.controller;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.pojo.Content;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiDataGridResult;
import com.bjsxt.service.ContentService;
import com.bjsxt.vo.SlideImg;

@Controller
@RequestMapping("/content")
public class ContentController {
	
	@Reference
	ContentService contentService;

	/**
	 * 通用跳转
	 */
	@RequestMapping("/{page}")
	public String page(@PathVariable("page") String pageStr) {
		return "content/content-"+pageStr;
	}
	
	/**
	 * 分页查询
	 */
	@RequestMapping("/getData")
	@ResponseBody
	public EuiDataGridResult getData(Long categoryId,
			@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="10") Integer rows) {
		return contentService.findByPage(page, rows, categoryId);
	}
	
	/**
	 * 保存或更新
	 */
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public CommonResult saveOrUpdate(Content content) {
		return contentService.saveOrUpdate(content);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public CommonResult delete(String ids) {
		return contentService.deleteByIds(ids);
	}
	
	/**
	 * 查询首页轮播图
	 */
	@RequestMapping("/findSlideIndex")
	@ResponseBody
	public MappingJacksonValue findSlideIndex(String callBack) {
		List<SlideImg>  slideImageList = contentService.findSlideIndex();
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(slideImageList);
		jacksonValue.setJsonpFunction(callBack);
		return jacksonValue;
	}
	/**
	 * 查询首页品牌
	 */
	@RequestMapping("/findCfIndex")
	@ResponseBody
	public MappingJacksonValue findCfIndex(String callBack) {
		List<String> index = contentService.findCfIndex();
		MappingJacksonValue jacksonValue = new MappingJacksonValue(index);
		jacksonValue.setJsonpFunction(callBack);
		return jacksonValue;
	 }
}
