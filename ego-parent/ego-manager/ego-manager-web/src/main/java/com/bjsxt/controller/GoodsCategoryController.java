package com.bjsxt.controller;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiTreeResult;
import com.bjsxt.service.GoodsCategoryService;
import com.bjsxt.vo.MenuCateName;

@Controller
@RequestMapping("/goods/cat")
public class GoodsCategoryController {
	@Reference
	GoodsCategoryService goodsCategoryService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EuiTreeResult> list(@RequestParam(defaultValue="0") Short id){
		return goodsCategoryService.findTreeByPid(id);
	}
	
	/**
	 * 查询菜单分类
	 * @param pid
	 * @param level
	 * @return
	 */
	@RequestMapping("/findAllMenu")
	@ResponseBody
	public MappingJacksonValue findAllMenu(String callBack,
			@RequestParam(defaultValue="0") Integer pid, 
			@RequestParam(defaultValue="1") Integer level){
		
		List<MenuCateName> menuList = goodsCategoryService.ShowMenu(pid, level);
		MappingJacksonValue mjv = new MappingJacksonValue(menuList);
		mjv.setJsonpFunction(callBack);
		return mjv;
	}
	/**
	 * 清空商品分类缓存
	 */
	@RequestMapping("/clearCache")
	@ResponseBody
	public CommonResult clearCache() {
		return goodsCategoryService.clearGoodsCatMenu();
	}
	
	
}
