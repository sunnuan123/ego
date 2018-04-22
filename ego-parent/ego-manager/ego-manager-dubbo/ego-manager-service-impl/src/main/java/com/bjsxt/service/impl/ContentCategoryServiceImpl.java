package com.bjsxt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjsxt.mapper.ContentCategoryMapper;
import com.bjsxt.pojo.ContentCategory;
import com.bjsxt.pojo.ContentCategoryExample;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiTreeResult;
import com.bjsxt.service.ContentCategoryService;

@Service(interfaceName="com.bjsxt.service.ContentCategoryService")
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	ContentCategoryMapper ccm;
	
	/**
	 * 查询树形菜单
	 */
	@Override
	public List<EuiTreeResult> findById(Long id) {
		List<EuiTreeResult> treeList = new ArrayList<EuiTreeResult>();
		ContentCategoryExample example = new ContentCategoryExample();
		ContentCategoryExample.Criteria criteria  = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		criteria.andStatusEqualTo(1);
		List<ContentCategory> contentCategory = ccm.selectByExample(example);
		if(contentCategory != null && contentCategory.size()>0) {
			for (ContentCategory cc : contentCategory) {
				EuiTreeResult er = new EuiTreeResult();
				er.setId(cc.getId().intValue());
				er.setText(cc.getName());
				er.setState(cc.getIsParent()==1?"closed":"open");
				treeList.add(er);
			}
		}
		return treeList;
	}
	

	/**
	 * 添加或更新
	 */
	public CommonResult addOrUpdate(ContentCategory contentCategory) {
		Long id = contentCategory.getId();
		Integer res;
		if(null == id) {
			//插入数据
			contentCategory.setCreated(new Date());
			contentCategory.setUpdated(new Date());
			contentCategory.setStatus(1);
			contentCategory.setSortOrder(1);
			contentCategory.setIsParent((byte)0);
			res = ccm.insertSelective(contentCategory);
		}else {
			//更新
			contentCategory.setUpdated(new Date());
			res = ccm.updateByPrimaryKeySelective(contentCategory);
		}
		CommonResult cr = new CommonResult();
		if(1 == res) {
			cr.setMessage(contentCategory.getId()+"");
			return cr.success();
		}
		return cr.fail();
	}
	
	/**
	 * 查询要删除的编号
	 */
	List<Long> listId = new ArrayList<Long>();
	public  List<Long> findDeleteId(Long id){
		listId.add(id);
		ContentCategoryExample example = new ContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(id);
		List<ContentCategory> list = ccm.selectByExample(example);
		if(list != null && list.size() > 0) {
			for (ContentCategory contentCategory : list) {
				Long cid = contentCategory.getId();
				delete(cid);
			}
		}
		return listId;
	}
	
	/**
	 * 删除
	 */
	public CommonResult delete(Long id) {
		//获取所有的id
		List<Long> idList = findDeleteId(id);
		
		ContentCategoryExample example = new ContentCategoryExample();
		example.createCriteria().andIdIn(idList);
		ContentCategory cc = new ContentCategory();
		//问题
		cc.setStatus(2);
		
		Integer res = ccm.updateByExampleSelective(cc, example);
		CommonResult cr = new CommonResult();
		if(res > 0) {
			return cr.success();
		}
		return cr.fail();
	}
	
	
	
	
}
