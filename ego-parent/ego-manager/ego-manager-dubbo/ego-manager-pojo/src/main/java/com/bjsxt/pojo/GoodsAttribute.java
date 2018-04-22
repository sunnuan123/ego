package com.bjsxt.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class GoodsAttribute implements Serializable {
    /**
     * 属性id
     */
    private Integer id;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 属性分类id
     */
    private Short catId;

    /**
     * 0不需要检索 1关键字检索 2范围检索
     */
    private Byte attrIndex;

    /**
     * 0唯一属性 1单选属性 2复选属性
     */
    private Byte attrType;

    /**
     *  0 手工录入 1从列表中选择 2多行文本框
     */
    private Byte attrInputType;

    private Byte orderSort;

    /**
     * 可选值列表
     */
    private String attrValues;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Short getCatId() {
        return catId;
    }

    public void setCatId(Short catId) {
        this.catId = catId;
    }

    public Byte getAttrIndex() {
        return attrIndex;
    }

    public void setAttrIndex(Byte attrIndex) {
        this.attrIndex = attrIndex;
    }

    public Byte getAttrType() {
        return attrType;
    }

    public void setAttrType(Byte attrType) {
        this.attrType = attrType;
    }

    public Byte getAttrInputType() {
        return attrInputType;
    }

    public void setAttrInputType(Byte attrInputType) {
        this.attrInputType = attrInputType;
    }

    public Byte getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(Byte orderSort) {
        this.orderSort = orderSort;
    }

    public String getAttrValues() {
        return attrValues;
    }

    public void setAttrValues(String attrValues) {
        this.attrValues = attrValues;
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
        GoodsAttribute other = (GoodsAttribute) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAttrName() == null ? other.getAttrName() == null : this.getAttrName().equals(other.getAttrName()))
            && (this.getCatId() == null ? other.getCatId() == null : this.getCatId().equals(other.getCatId()))
            && (this.getAttrIndex() == null ? other.getAttrIndex() == null : this.getAttrIndex().equals(other.getAttrIndex()))
            && (this.getAttrType() == null ? other.getAttrType() == null : this.getAttrType().equals(other.getAttrType()))
            && (this.getAttrInputType() == null ? other.getAttrInputType() == null : this.getAttrInputType().equals(other.getAttrInputType()))
            && (this.getOrderSort() == null ? other.getOrderSort() == null : this.getOrderSort().equals(other.getOrderSort()))
            && (this.getAttrValues() == null ? other.getAttrValues() == null : this.getAttrValues().equals(other.getAttrValues()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAttrName() == null) ? 0 : getAttrName().hashCode());
        result = prime * result + ((getCatId() == null) ? 0 : getCatId().hashCode());
        result = prime * result + ((getAttrIndex() == null) ? 0 : getAttrIndex().hashCode());
        result = prime * result + ((getAttrType() == null) ? 0 : getAttrType().hashCode());
        result = prime * result + ((getAttrInputType() == null) ? 0 : getAttrInputType().hashCode());
        result = prime * result + ((getOrderSort() == null) ? 0 : getOrderSort().hashCode());
        result = prime * result + ((getAttrValues() == null) ? 0 : getAttrValues().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attrName=").append(attrName);
        sb.append(", catId=").append(catId);
        sb.append(", attrIndex=").append(attrIndex);
        sb.append(", attrType=").append(attrType);
        sb.append(", attrInputType=").append(attrInputType);
        sb.append(", orderSort=").append(orderSort);
        sb.append(", attrValues=").append(attrValues);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}