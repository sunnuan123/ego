package com.bjsxt.bo;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsBo implements Serializable{
	private static final long serialVersionUID = 728541440014975970L;
	private Integer id;
	private String goodsName;
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
		return "GoodsBo [id=" + id + ", goodsName=" + goodsName + ", shopPrice=" + shopPrice + ", originalImg="
				+ originalImg + "]";
	}
	
}
