package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.pojo.Goods;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiDataGridResult;
import com.bjsxt.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Reference
	GoodsService goodsService;
	
	/**
	 * 公共跳转
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String page(@PathVariable("page") String page) {
		return "/goods/goods-"+page;
	}
	
	/**
	 * 保存
	 * @param goods
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public CommonResult save(Goods goods) {
		return goodsService.save(goods);
	}
	
	/**
	 * 查询分页
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/getData")
	@ResponseBody
	public EuiDataGridResult findByPage(@RequestParam(defaultValue="1") Integer page, 
			@RequestParam(defaultValue="10") Integer rows) {
		return goodsService.findByPage(page, rows);
	}
	
	/**
	 * 修改更新数据
	 */
	@RequestMapping("/update")
	@ResponseBody
	public CommonResult updateById(Goods goods) {
		return goodsService.updateById(goods);
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public CommonResult delete (String ids) {
		System.out.println(ids);
		return goodsService.deleteByIds(ids);
	}
	
}
