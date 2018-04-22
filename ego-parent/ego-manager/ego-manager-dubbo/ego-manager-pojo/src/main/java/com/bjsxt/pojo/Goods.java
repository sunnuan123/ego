package com.bjsxt.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class Goods implements Serializable {
    /**
     * 商品id
     */
    private Integer id;

    /**
     * 分类id
     */
    private Integer catId;

    /**
     * 扩展分类id
     */
    private Integer extendCatId;

    /**
     * 商品编号
     */
    private String goodsSn;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 点击数
     */
    private Integer clickCount;

    /**
     * 品牌id
     */
    private Short brandId;

    /**
     * 库存数量
     */
    private Short storeCount;

    /**
     * 商品评论数
     */
    private Short commentCount;

    /**
     * 商品重量克为单位
     */
    private Integer weight;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 本店价
     */
    private BigDecimal shopPrice;

    /**
     * 商品成本价
     */
    private BigDecimal costPrice;

    /**
     * 商品关键词
     */
    private String keywords;

    /**
     * 商品简单描述
     */
    private String goodsRemark;

    /**
     * 商品上传原始图
     */
    private String originalImg;

    /**
     * 是否为实物
     */
    private Byte isReal;

    /**
     * 是否上架
     */
    private Byte isOnSale;

    /**
     * 是否包邮0否1是
     */
    private Byte isFreeShipping;

    /**
     * 商品上架时间
     */
    private Integer onTime;

    /**
     * 商品排序
     */
    private Short sort;

    /**
     * 是否推荐
     */
    private Byte isRecommend;

    /**
     * 是否新品
     */
    private Byte isNew;

    /**
     * 是否热卖
     */
    private Byte isHot;

    /**
     * 最后更新时间
     */
    private Integer lastUpdate;

    /**
     * 商品所属类型id，取值表goods_type的cat_id
     */
    private Short goodsType;

    /**
     * 商品规格类型，取值表goods_type的cat_id
     */
    private Short specType;

    /**
     * 购买商品赠送积分
     */
    private Integer giveIntegral;

    /**
     * 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     */
    private Integer exchangeIntegral;

    /**
     * 供货商ID
     */
    private Short suppliersId;

    /**
     * 商品销量
     */
    private Integer salesSum;

    /**
     * 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     */
    private Byte promType;

    /**
     * 优惠活动id
     */
    private Integer promId;

    /**
     * 佣金用于分销分成
     */
    private BigDecimal commission;

    /**
     * SPU
     */
    private String spu;

    /**
     * SKU
     */
    private String sku;

    /**
     * 商品详细描述
     */
    private String goodsContent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getExtendCatId() {
        return extendCatId;
    }

    public void setExtendCatId(Integer extendCatId) {
        this.extendCatId = extendCatId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Short getBrandId() {
        return brandId;
    }

    public void setBrandId(Short brandId) {
        this.brandId = brandId;
    }

    public Short getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Short storeCount) {
        this.storeCount = storeCount;
    }

    public Short getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Short commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark;
    }

    public String getOriginalImg() {
        return originalImg;
    }

    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg;
    }

    public Byte getIsReal() {
        return isReal;
    }

    public void setIsReal(Byte isReal) {
        this.isReal = isReal;
    }

    public Byte getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Byte isOnSale) {
        this.isOnSale = isOnSale;
    }

    public Byte getIsFreeShipping() {
        return isFreeShipping;
    }

    public void setIsFreeShipping(Byte isFreeShipping) {
        this.isFreeShipping = isFreeShipping;
    }

    public Integer getOnTime() {
        return onTime;
    }

    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Byte getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Byte isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Byte getIsNew() {
        return isNew;
    }

    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public Integer getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Short getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Short goodsType) {
        this.goodsType = goodsType;
    }

    public Short getSpecType() {
        return specType;
    }

    public void setSpecType(Short specType) {
        this.specType = specType;
    }

    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    public void setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    public Integer getExchangeIntegral() {
        return exchangeIntegral;
    }

    public void setExchangeIntegral(Integer exchangeIntegral) {
        this.exchangeIntegral = exchangeIntegral;
    }

    public Short getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }

    public Integer getSalesSum() {
        return salesSum;
    }

    public void setSalesSum(Integer salesSum) {
        this.salesSum = salesSum;
    }

    public Byte getPromType() {
        return promType;
    }

    public void setPromType(Byte promType) {
        this.promType = promType;
    }

    public Integer getPromId() {
        return promId;
    }

    public void setPromId(Integer promId) {
        this.promId = promId;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getSpu() {
        return spu;
    }

    public void setSpu(String spu) {
        this.spu = spu;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getExtendCatId() == null ? other.getExtendCatId() == null : this.getExtendCatId().equals(other.getExtendCatId()))
            && (this.getGoodsSn() == null ? other.getGoodsSn() == null : this.getGoodsSn().equals(other.getGoodsSn()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getClickCount() == null ? other.getClickCount() == null : this.getClickCount().equals(other.getClickCount()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getStoreCount() == null ? other.getStoreCount() == null : this.getStoreCount().equals(other.getStoreCount()))
            && (this.getCommentCount() == null ? other.getCommentCount() == null : this.getCommentCount().equals(other.getCommentCount()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getShopPrice() == null ? other.getShopPrice() == null : this.getShopPrice().equals(other.getShopPrice()))
            && (this.getCostPrice() == null ? other.getCostPrice() == null : this.getCostPrice().equals(other.getCostPrice()))
            && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(other.getKeywords()))
            && (this.getGoodsRemark() == null ? other.getGoodsRemark() == null : this.getGoodsRemark().equals(other.getGoodsRemark()))
            && (this.getOriginalImg() == null ? other.getOriginalImg() == null : this.getOriginalImg().equals(other.getOriginalImg()))
            && (this.getIsReal() == null ? other.getIsReal() == null : this.getIsReal().equals(other.getIsReal()))
            && (this.getIsOnSale() == null ? other.getIsOnSale() == null : this.getIsOnSale().equals(other.getIsOnSale()))
            && (this.getIsFreeShipping() == null ? other.getIsFreeShipping() == null : this.getIsFreeShipping().equals(other.getIsFreeShipping()))
            && (this.getOnTime() == null ? other.getOnTime() == null : this.getOnTime().equals(other.getOnTime()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getIsRecommend() == null ? other.getIsRecommend() == null : this.getIsRecommend().equals(other.getIsRecommend()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()))
            && (this.getLastUpdate() == null ? other.getLastUpdate() == null : this.getLastUpdate().equals(other.getLastUpdate()))
            && (this.getGoodsType() == null ? other.getGoodsType() == null : this.getGoodsType().equals(other.getGoodsType()))
            && (this.getSpecType() == null ? other.getSpecType() == null : this.getSpecType().equals(other.getSpecType()))
            && (this.getGiveIntegral() == null ? other.getGiveIntegral() == null : this.getGiveIntegral().equals(other.getGiveIntegral()))
            && (this.getExchangeIntegral() == null ? other.getExchangeIntegral() == null : this.getExchangeIntegral().equals(other.getExchangeIntegral()))
            && (this.getSuppliersId() == null ? other.getSuppliersId() == null : this.getSuppliersId().equals(other.getSuppliersId()))
            && (this.getSalesSum() == null ? other.getSalesSum() == null : this.getSalesSum().equals(other.getSalesSum()))
            && (this.getPromType() == null ? other.getPromType() == null : this.getPromType().equals(other.getPromType()))
            && (this.getPromId() == null ? other.getPromId() == null : this.getPromId().equals(other.getPromId()))
            && (this.getCommission() == null ? other.getCommission() == null : this.getCommission().equals(other.getCommission()))
            && (this.getSpu() == null ? other.getSpu() == null : this.getSpu().equals(other.getSpu()))
            && (this.getSku() == null ? other.getSku() == null : this.getSku().equals(other.getSku()))
            && (this.getGoodsContent() == null ? other.getGoodsContent() == null : this.getGoodsContent().equals(other.getGoodsContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCatId() == null) ? 0 : getCatId().hashCode());
        result = prime * result + ((getExtendCatId() == null) ? 0 : getExtendCatId().hashCode());
        result = prime * result + ((getGoodsSn() == null) ? 0 : getGoodsSn().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getClickCount() == null) ? 0 : getClickCount().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getStoreCount() == null) ? 0 : getStoreCount().hashCode());
        result = prime * result + ((getCommentCount() == null) ? 0 : getCommentCount().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getShopPrice() == null) ? 0 : getShopPrice().hashCode());
        result = prime * result + ((getCostPrice() == null) ? 0 : getCostPrice().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getGoodsRemark() == null) ? 0 : getGoodsRemark().hashCode());
        result = prime * result + ((getOriginalImg() == null) ? 0 : getOriginalImg().hashCode());
        result = prime * result + ((getIsReal() == null) ? 0 : getIsReal().hashCode());
        result = prime * result + ((getIsOnSale() == null) ? 0 : getIsOnSale().hashCode());
        result = prime * result + ((getIsFreeShipping() == null) ? 0 : getIsFreeShipping().hashCode());
        result = prime * result + ((getOnTime() == null) ? 0 : getOnTime().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getIsRecommend() == null) ? 0 : getIsRecommend().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getLastUpdate() == null) ? 0 : getLastUpdate().hashCode());
        result = prime * result + ((getGoodsType() == null) ? 0 : getGoodsType().hashCode());
        result = prime * result + ((getSpecType() == null) ? 0 : getSpecType().hashCode());
        result = prime * result + ((getGiveIntegral() == null) ? 0 : getGiveIntegral().hashCode());
        result = prime * result + ((getExchangeIntegral() == null) ? 0 : getExchangeIntegral().hashCode());
        result = prime * result + ((getSuppliersId() == null) ? 0 : getSuppliersId().hashCode());
        result = prime * result + ((getSalesSum() == null) ? 0 : getSalesSum().hashCode());
        result = prime * result + ((getPromType() == null) ? 0 : getPromType().hashCode());
        result = prime * result + ((getPromId() == null) ? 0 : getPromId().hashCode());
        result = prime * result + ((getCommission() == null) ? 0 : getCommission().hashCode());
        result = prime * result + ((getSpu() == null) ? 0 : getSpu().hashCode());
        result = prime * result + ((getSku() == null) ? 0 : getSku().hashCode());
        result = prime * result + ((getGoodsContent() == null) ? 0 : getGoodsContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", catId=").append(catId);
        sb.append(", extendCatId=").append(extendCatId);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", brandId=").append(brandId);
        sb.append(", storeCount=").append(storeCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", weight=").append(weight);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(shopPrice);
        sb.append(", costPrice=").append(costPrice);
        sb.append(", keywords=").append(keywords);
        sb.append(", goodsRemark=").append(goodsRemark);
        sb.append(", originalImg=").append(originalImg);
        sb.append(", isReal=").append(isReal);
        sb.append(", isOnSale=").append(isOnSale);
        sb.append(", isFreeShipping=").append(isFreeShipping);
        sb.append(", onTime=").append(onTime);
        sb.append(", sort=").append(sort);
        sb.append(", isRecommend=").append(isRecommend);
        sb.append(", isNew=").append(isNew);
        sb.append(", isHot=").append(isHot);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", specType=").append(specType);
        sb.append(", giveIntegral=").append(giveIntegral);
        sb.append(", exchangeIntegral=").append(exchangeIntegral);
        sb.append(", suppliersId=").append(suppliersId);
        sb.append(", salesSum=").append(salesSum);
        sb.append(", promType=").append(promType);
        sb.append(", promId=").append(promId);
        sb.append(", commission=").append(commission);
        sb.append(", spu=").append(spu);
        sb.append(", sku=").append(sku);
        sb.append(", goodsContent=").append(goodsContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}