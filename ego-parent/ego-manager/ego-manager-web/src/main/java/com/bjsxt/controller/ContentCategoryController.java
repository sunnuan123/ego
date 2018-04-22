package com.bjsxt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.pojo.ContentCategory;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiTreeResult;
import com.bjsxt.service.ContentCategoryService;

@Controller
@RequestMapping("/content/cat")
public class ContentCategoryController {
	@Reference
	ContentCategoryService ccs;
	
	@RequestMapping("/cat-tree")
	public String page() {
		return "content/content-category-tree";
	}
	
	/**
	 * 查询树形结构
	 */
	@RequestMapping("/getTree")
	@ResponseBody
	public List<EuiTreeResult> getTree(@RequestParam(defaultValue="0") Long id){
		return ccs.findById(id);
	}
	
	/**
	 * 添加或更新
	 */
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public CommonResult saveOrUpdate(ContentCategory contentCategory) {
		
		return ccs.addOrUpdate(contentCategory);
	}
	/**
	 * 级联删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public CommonResult delete(Long id) {
		return ccs.delete(id);
	}
	
}
