package com.bjsxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.SerializationUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjsxt.mapper.GoodsCategoryMapper;
import com.bjsxt.pojo.GoodsCategory;
import com.bjsxt.pojo.GoodsCategoryExample;
import com.bjsxt.result.CommonResult;
import com.bjsxt.result.EuiTreeResult;
import com.bjsxt.service.GoodsCategoryService;
import com.bjsxt.vo.MenuCateName;

import redis.clients.jedis.JedisCluster;


@Service(interfaceName="com.bjsxt.service.GoodsCategoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService{
	@Autowired
	GoodsCategoryMapper goodsCategoryMapper;
	
	@Autowired
	JedisCluster jedisCluster;
	
	@Value("${goods.cat.menu.key}")
	String goodsCatMenuKey;
	
	/**
	 * 展示树形结构
	 */
	@Override
	public List<EuiTreeResult> findTreeByPid(Short id) {
		List<EuiTreeResult> treeList = new ArrayList<>();
		GoodsCategoryExample example = new GoodsCategoryExample();
		example.createCriteria().andParentIdEqualTo(id);
		List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.selectByExample(example);
		if(goodsCategoryList != null && goodsCategoryList.size() != 0) {
			for (GoodsCategory goodsCategory : goodsCategoryList) {
				EuiTreeResult tree = new EuiTreeResult();
				tree.setId(goodsCategory.getId().intValue());
				tree.setText(goodsCategory.getName());
				tree.setState(goodsCategory.getLevel()==3?"open":"closed");
				treeList.add(tree);
			}
		}
		return treeList;
	}
	
	/**
	 * 返回分类菜单
	 */
	public List<MenuCateName> ShowMenu( Integer pid, Integer level){
		byte[] key = SerializationUtils.serialize(goodsCatMenuKey);
		//1.从redis查询string、hash、list、set、sorted set
		byte[] menuByte=jedisCluster.get(key);
		if(menuByte != null && menuByte.length>0) {
			return (List<MenuCateName>)SerializationUtils.deserialize(menuByte);
		}else {
			//4.不存在，从数据库查询
			List<MenuCateName> menuList = findAllMenuFromDb(pid, level);
			//5.缓存至redis
			jedisCluster.set(key, SerializationUtils.serialize(menuList));
			return menuList;
		}
	}
	
	/**
	 * 从数据库中查询中查询
	 */
	private List<MenuCateName> findAllMenuFromDb( Integer pid, Integer level){
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
					mn.setMenuCateNameList(findAllMenuFromDb(goodsCategory.getId().intValue(), level+1));
				}
				list.add(mn);
			}
		}
		return list;
	}
	
	/**
	 * 清空分类菜单缓存
	 */
	public CommonResult clearGoodsCatMenu() {
		byte[] key  = SerializationUtils.serialize(goodsCatMenuKey);
		jedisCluster.del(key);
		return CommonResult.success();
	}
	
}
