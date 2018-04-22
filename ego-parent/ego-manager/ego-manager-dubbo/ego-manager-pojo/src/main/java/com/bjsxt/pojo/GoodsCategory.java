package com.bjsxt.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class GoodsCategory implements Serializable {
    /**
     * 商品分类id
     */
    private Short id;

    /**
     * 商品分类名称
     */
    private String name;

    /**
     * 手机端显示的商品分类名
     */
    private String mobileName;

    /**
     * 父id
     */
    private Short parentId;

    /**
     * 家族图谱
     */
    private String parentIdPath;

    /**
     * 等级
     */
    private Byte level;

    /**
     * 顺序排序
     */
    private Byte sortOrder;

    /**
     * 是否显示
     */
    private Byte isShow;

    /**
     * 分类图片
     */
    private String image;

    /**
     * 是否推荐为热门分类
     */
    private Byte isHot;

    /**
     * 分类分组默认0
     */
    private Byte catGroup;

    /**
     * 分佣比例
     */
    private Byte commissionRate;

    private static final long serialVersionUID = 1L;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    public String getParentIdPath() {
        return parentIdPath;
    }

    public void setParentIdPath(String parentIdPath) {
        this.parentIdPath = parentIdPath;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public Byte getCatGroup() {
        return catGroup;
    }

    public void setCatGroup(Byte catGroup) {
        this.catGroup = catGroup;
    }

    public Byte getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Byte commissionRate) {
        this.commissionRate = commissionRate;
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
        GoodsCategory other = (GoodsCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMobileName() == null ? other.getMobileName() == null : this.getMobileName().equals(other.getMobileName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getParentIdPath() == null ? other.getParentIdPath() == null : this.getParentIdPath().equals(other.getParentIdPath()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getSortOrder() == null ? other.getSortOrder() == null : this.getSortOrder().equals(other.getSortOrder()))
            && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()))
            && (this.getCatGroup() == null ? other.getCatGroup() == null : this.getCatGroup().equals(other.getCatGroup()))
            && (this.getCommissionRate() == null ? other.getCommissionRate() == null : this.getCommissionRate().equals(other.getCommissionRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMobileName() == null) ? 0 : getMobileName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getParentIdPath() == null) ? 0 : getParentIdPath().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getSortOrder() == null) ? 0 : getSortOrder().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getCatGroup() == null) ? 0 : getCatGroup().hashCode());
        result = prime * result + ((getCommissionRate() == null) ? 0 : getCommissionRate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", mobileName=").append(mobileName);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentIdPath=").append(parentIdPath);
        sb.append(", level=").append(level);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isShow=").append(isShow);
        sb.append(", image=").append(image);
        sb.append(", isHot=").append(isHot);
        sb.append(", catGroup=").append(catGroup);
        sb.append(", commissionRate=").append(commissionRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}