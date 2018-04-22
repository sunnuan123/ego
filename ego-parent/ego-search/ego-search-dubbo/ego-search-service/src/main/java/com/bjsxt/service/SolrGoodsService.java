package com.bjsxt.service;

import com.bjsxt.bo.GoodsBo;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EgoPageInfo;

public interface SolrGoodsService {
	/**
	 * 保存数据到solr
	 * @param goodsBo
	 * @return
	 */
	public CommonResult addGoodsToSolr(GoodsBo goodsBo);
	/**
	 * 商品检索
	 */
	public EgoPageInfo doSearchForGoods(String keywords, Integer currentPage, Integer pageSize);
}
