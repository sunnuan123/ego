package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.pojo.GoodsAttribute;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiDataGridResult;
import com.bjsxt.service.GoodsAttributeService;

@Controller
@RequestMapping("/goods/attr")
public class GoodsAttributeController {
	
	@Reference
	GoodsAttributeService goodsAttributeService;
	
	/**
	 * 公共跳转页面
	 * 
	 */
	@RequestMapping("/{page}")
	public String page(@PathVariable("page") String page) {
		return "goods/goods-attribute-"+page;
	}
	/**
	 * 分页查询
	 */
	@RequestMapping("/getData")
	@ResponseBody
	public EuiDataGridResult findByPage(@RequestParam(defaultValue="1") Integer page, 
			@RequestParam(defaultValue="10") Integer rows) {
		return goodsAttributeService.findByPage(page, rows);
	}
	
	/**
	 * 增加或修改
	 */
	@RequestMapping("/saveOrUpdate/{cat_id}")
	@ResponseBody
	public CommonResult  saveOrUpdate(@PathVariable("cat_id") Integer cat_id ,GoodsAttribute goodsAttribute) {
		goodsAttribute.setCatId(cat_id.shortValue());
		return goodsAttributeService.saveOrUpdate(goodsAttribute);
	}
	
	/**
	 * 查询一条数据
	 */
	@RequestMapping("/edit/{id}")
	public String updateById(@PathVariable("id")Integer id, Model model) {
		GoodsAttribute goodsAttribute = goodsAttributeService.findById(id);
		model.addAttribute("goodsAttr", goodsAttribute);
		return "goods/goods-attribute-edit";
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public CommonResult deleteByIds(String ids) {
		return goodsAttributeService.deleteByIds(ids);
	}
}
