package com.bjsxt.mapper.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjsxt.mapper.GoodsCategoryMapper;
import com.bjsxt.pojo.GoodsCategory;
import com.bjsxt.pojo.GoodsCategoryExample;
import com.bjsxt.vo.MenuCateName;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring-*.xml")
public class GoodsCategoryMapperTest {
	
	@Autowired
	GoodsCategoryMapper goodsCategoryMapper;
	
	/**
	 * 测试添加1
	 */
	@Test
	public void save() {
		GoodsCategory goodsCate = new GoodsCategory();
		goodsCate.setName("406");
		goodsCate.setParentId((short)1);
		goodsCate.setLevel((byte)1);
		goodsCate.setSortOrder((byte)1);
		goodsCate.setIsShow((byte)1);
		goodsCategoryMapper.insert(goodsCate);
	}
	
	/**
	 * 测试添加2
	 */
	@Test
	public void save2() {
		GoodsCategory goodsCate = new GoodsCategory();
		goodsCate.setName("406");
		goodsCate.setParentId((short)1);
		goodsCate.setLevel((byte)1);
		goodsCate.setSortOrder((byte)1);
		goodsCate.setIsShow((byte)1);
		goodsCategoryMapper.insertSelective(goodsCate);
	}
	
	/**
	 * 根据主键删除
	 */
	@Test
	public void deleteByPrimaryKey() {
		goodsCategoryMapper.deleteByPrimaryKey((short)844);
	}
	
	/**
	 * 根据条件删除
	 */
	@Test
	public void deleteByExample() {
		GoodsCategoryExample example = new GoodsCategoryExample();
		//指定条件
		example.createCriteria().andNameEqualTo("406");
		goodsCategoryMapper.deleteByExample(example);
	}
	/**
	 * 根据主键查询
	 */
	@Test
	public void selectByPrimaryKey() {
		GoodsCategory goods = goodsCategoryMapper.selectByPrimaryKey((short)50);
		System.out.println(goods);
	}
	/**
	 * 根据条件查询and
	 */
	@Test
	public void selectByExample() {
		GoodsCategoryExample example = new GoodsCategoryExample();
		example.createCriteria().andNameEqualTo("功能箱包").andLevelEqualTo((byte)2);
		List<GoodsCategory> goods = goodsCategoryMapper.selectByExample(example);
		for (GoodsCategory goodsCategory : goods) {
			System.out.println(goodsCategory);
		}
	}
	/**
	 * 根据条件查询or
	 */
	@Test
	public void selectByExampleOr() {
		GoodsCategoryExample example = new GoodsCategoryExample();
		GoodsCategoryExample.Criteria criteria1 = example.createCriteria();
		criteria1.andNameLike("%功能箱包%");
		GoodsCategoryExample.Criteria criteria2 = example.createCriteria();
		criteria2.andLevelEqualTo((byte)7);
		example.or(criteria2);
		List<GoodsCategory> goods = goodsCategoryMapper.selectByExample(example);
		for (GoodsCategory goodsCategory : goods) {
			System.out.println(goodsCategory);
		}
	}
	/**
	 * 根据条件修改
	 */
	@Test
	public void updateByExampleSelective() {
		//更改内容
		GoodsCategory goods = new GoodsCategory();
		goods.setName("箱包");
		//条件
		GoodsCategoryExample example = new GoodsCategoryExample();
		example.createCriteria().andMobileNameEqualTo("功能箱包")
		.andLevelEqualTo((byte)2);
		//更新
		goodsCategoryMapper.updateByExampleSelective(goods, example);
		
	}
	/**
	 * 根据id修改
	 */
	@Test
	public void updateByPrimaryKeySelective() {
		//更改内容
		GoodsCategory record = new GoodsCategory();
		record.setName("功能箱包");
		record.setId((short)50);
		//更新
		goodsCategoryMapper.updateByPrimaryKeySelective(record);
		
	}
	
	/**
	 * 展示商品目录
	 */
	@Test
	public void ShowMenu(){
		List<MenuCateName>  list = ShowMenuReal(0, 1);
		for (MenuCateName menuCateName : list) {
			System.out.println(menuCateName);
		}
	}
	
	public List<MenuCateName> ShowMenuReal( Integer pid, Integer level){
		List<MenuCateName> list = new ArrayList<MenuCateName>();
		GoodsCategoryExample example = new GoodsCategoryExample();
		example.createCriteria().andParentIdEqualTo(pid.shortValue()).andLevelEqualTo(level.byteValue());
		List<GoodsCategory> cateList = goodsCategoryMapper.selectByExample(example);
		if(cateList.size()>0 && cateList != null) {
			for (GoodsCategory goodsCategory : cateList) {
				MenuCateName mn = new MenuCateName();
				mn.setId(goodsCategory.getId().intValue());
				mn.setName(goodsCategory.getName());
				if(level < 3) {
					mn.setMenuCateNameList(ShowMenuReal(goodsCategory.getId().intValue(), level+1));
				}
				list.add(mn);
			}
		}
		return list;
	}
}
