package com.bjsxt.vo;

import java.io.Serializable;
import java.util.List;

public class MenuCateName implements Serializable{
	private static final long serialVersionUID = -7914755498736910089L;
	
	private Integer id;
	private String name;
	private List<MenuCateName> menuCateNameList;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MenuCateName> getMenuCateNameList() {
		return menuCateNameList;
	}
	public void setMenuCateNameList(List<MenuCateName> menuCateNameList) {
		this.menuCateNameList = menuCateNameList;
	}
	@Override
	public String toString() {
		return "MenuCateName [id=" + id + ", name=" + name + ", menuCateNameList=" + menuCateNameList + "]";
	}
	
}
