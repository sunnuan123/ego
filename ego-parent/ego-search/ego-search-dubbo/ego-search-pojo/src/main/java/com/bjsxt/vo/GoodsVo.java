package com.bjsxt.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsVo implements Serializable{
	private static final long serialVersionUID = 5113289589504219045L;
	private Integer id;
	private String goodsName;
	private String goodsNameHl;
	private BigDecimal shopPrice;
	private String originalImg;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsNameHl() {
		return goodsNameHl;
	}
	public void setGoodsNameHl(String goodsNameHl) {
		this.goodsNameHl = goodsNameHl;
	}
	public BigDecimal getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(BigDecimal shopPrice) {
		this.shopPrice = shopPrice;
	}
	public String getOriginalImg() {
		return originalImg;
	}
	public void setOriginalImg(String originalImg) {
		this.originalImg = originalImg;
	}
	@Override
	public String toString() {
		return "GoodsVo [id=" + id + ", goodsName=" + goodsName + ", goodsNameHl=" + goodsNameHl + ", shopPrice="
				+ shopPrice + ", originalImg=" + originalImg + "]";
	}
	
	
}
