package com.bjsxt.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjsxt.result.EgoPageInfo;
import com.bjsxt.service.SolrGoodsService;

@Controller
public class SearchController {
	
	@Reference
	SolrGoodsService solrGoodsService;
	/**
	 * 跳转
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/search")
	public String search(String keywords, String charset, Map<String, Object> map) throws UnsupportedEncodingException {
		keywords = new String(keywords.getBytes("iso-8859-1"), charset);
		map.put("keywords", keywords);
		return "search";
	}
	
	/**
	 * 执行检索
	 */
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public EgoPageInfo search(String keywords, @RequestParam(defaultValue="1") Integer currentPage,
			@RequestParam(defaultValue="12") Integer pageSize) {
		return solrGoodsService.doSearchForGoods(keywords, currentPage, pageSize);
	}
	
}
