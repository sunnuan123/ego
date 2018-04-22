package com.bjsxt.mapper.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjsxt.mapper.ContentCategoryMapper;
import com.bjsxt.pojo.ContentCategory;
import com.bjsxt.pojo.ContentCategoryExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring-*.xml")
public class ContentTreeDelete {
	@Autowired
	ContentCategoryMapper ccm;
	
	List<Long> listId = new ArrayList<Long>();
	
	@Test
	public void testDelete() {
		Long id = 96L;
		delete(id);
		for(Long li:listId) {
			System.out.println(li);
		}
	}
	
	public  void delete(Long id){
		listId.add(id);
		ContentCategoryExample example = new ContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(id);
		List<ContentCategory> list = ccm.selectByExample(example);
		for (ContentCategory contentCategory : list) {
			Long cid = contentCategory.getId();
			delete(cid);
		}
		
	}
	
}
