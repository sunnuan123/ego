package com.bjsxt.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjsxt.bo.GoodsBo;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EgoPageInfo;
import com.bjsxt.service.SolrGoodsService;
import com.bjsxt.vo.GoodsVo;

@Service(interfaceName="com.bjsxt.service.SolrGoodsService")
public class SolrGoodsServiceImpl implements SolrGoodsService{
	@Value("${zookeeper.url}")
	String zkUrl;
	
	@Value("${solr.default.collection}")
	String defaultCollection;
	
	/**
	 * 保存至solr
	 */
	@Override
	public CommonResult addGoodsToSolr(GoodsBo goodsBo) {
		CloudSolrClient csc = null;
		
		try {
			csc = new CloudSolrClient.Builder().withZkHost(zkUrl).build();
			csc.setDefaultCollection(defaultCollection);
			
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", goodsBo.getId());
			doc.addField("goodsName",goodsBo.getGoodsName());
			doc.addField("shopPrice",goodsBo.getShopPrice().doubleValue());
			doc.addField("originalImg",goodsBo.getOriginalImg());
			//执行添加
			csc.add(doc);
		} catch (Exception e) {
			return CommonResult.fail();
		}finally {
			if(csc != null) {
				try {
					csc.commit();
					csc.close();
				} catch (Exception e) {
					
				}
			}
		}
		return CommonResult.success();
	}
	/**
	 * 商品检索
	 */
	@Override
	public EgoPageInfo doSearchForGoods(String keywords, Integer currentPage, Integer pageSize) {
		CloudSolrClient solrClient = null;
		EgoPageInfo pageInfo = null;//返回结果
		
		try {
			solrClient = new CloudSolrClient.Builder().withZkHost(zkUrl).build();
			solrClient.setDefaultCollection(defaultCollection);
			//设置参数
			SolrQuery params = setParams(keywords, currentPage, pageSize);
			//执行查询
			QueryResponse response = solrClient.query(params);
			//获取结果集
			SolrDocumentList docList = response.getResults();
			//获取高亮
			Map<String, Map<String, List<String>>>  mapHl = response.getHighlighting();
			//封装返回结果
			pageInfo = genEgoPageInfo(currentPage, pageSize, docList, mapHl);
		} catch (Exception e) {
			System.out.println("出错了"+e.getMessage());
		}finally {
			if(solrClient!=null) {
				try {
					//提交
					solrClient.commit();
					solrClient.close();
				} catch (Exception e) {
				}
			}

		}
		
		
		return pageInfo;
	}
	
	/**
	 * 封装返回的结果
	 */
	private EgoPageInfo genEgoPageInfo(Integer currentPage, Integer pageSize, SolrDocumentList docList,
			Map<String, Map<String, List<String>>> mapHl) {
		EgoPageInfo pageInfo;
		//封装列表
		List<GoodsVo> goodsVoList = new ArrayList<>();
		if(docList!=null && docList.size()>0) {
			for(SolrDocument doc:docList) {
				String id = (String)doc.getFieldValue("id");
				String goodsName = (String)doc.getFieldValue("goodsName");
				String shopPrice = (String)doc.getFieldValue("shopPrice");
				String originalImg = (String)doc.getFieldValue("originalImg");
				String goodsNameHl = mapHl.get(id).get("goodsName").get(0);
				
				GoodsVo goodsVo = new GoodsVo();
				goodsVo.setId(Integer.parseInt(id));
				goodsVo.setGoodsName(goodsName);
				goodsVo.setShopPrice(new BigDecimal(shopPrice));
				goodsVo.setOriginalImg(originalImg);
				goodsVo.setGoodsNameHl(goodsNameHl);
				goodsVoList.add(goodsVo);

			}
		}
		//总条数
		Long count = docList.getNumFound();
		//最终返回结果
		pageInfo = new EgoPageInfo(currentPage, pageSize, count);
		pageInfo.setRows(goodsVoList);
		return pageInfo;
	}
	/**
	 * 设置参数
	 * @param keywords
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	private SolrQuery setParams(String keywords, Integer currentPage, Integer pageSize) {
		SolrQuery params = new SolrQuery();
		//分页
		params.setStart((currentPage-1)*pageSize);
		params.setRows(pageSize);
		
		//检索关键字
		params.setQuery("goodsName:"+keywords);
		
		//高亮查询
		params.setHighlight(true);
		//高亮字段
		params.addHighlightField("goodsName");
		//前后缀
		params.setHighlightSimplePre("<font color='red'>");
		params.setHighlightSimplePost("</font>");
		return params;
	}

}
