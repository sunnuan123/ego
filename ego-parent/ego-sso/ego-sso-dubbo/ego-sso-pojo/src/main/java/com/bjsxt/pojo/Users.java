package com.bjsxt.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class Users implements Serializable {
    /**
     * 表id
     */
    private Integer id;

    /**
     * 邮件
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 0 保密 1 男 2 女
     */
    private Byte sex;

    /**
     * 生日
     */
    private Integer birthday;

    /**
     * 用户金额
     */
    private BigDecimal userMoney;

    /**
     * 冻结金额
     */
    private BigDecimal frozenMoney;

    /**
     * 累积分佣金额
     */
    private BigDecimal distributMoney;

    /**
     * 消费积分
     */
    private Integer payPoints;

    /**
     * 默认收货地址
     */
    private Integer addressId;

    /**
     * 注册时间
     */
    private Integer regTime;

    /**
     * 最后登录时间
     */
    private Integer lastLogin;

    /**
     * 最后登录ip
     */
    private String lastIp;

    /**
     * QQ
     */
    private String qq;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 是否验证手机
     */
    private Byte mobileValidated;

    /**
     * 第三方来源 wx weibo alipay
     */
    private String oauth;

    /**
     * 第三方唯一标示
     */
    private String openid;

    /**
     * 头像
     */
    private String headPic;

    /**
     * 省份
     */
    private Integer province;

    /**
     * 市区
     */
    private Integer city;

    /**
     * 县
     */
    private Integer district;

    /**
     * 是否验证电子邮箱
     */
    private Byte emailValidated;

    /**
     * 第三方返回昵称
     */
    private String nickname;

    /**
     * 会员等级
     */
    private Byte level;

    /**
     * 会员折扣，默认1不享受
     */
    private BigDecimal discount;

    /**
     * 消费累计额度
     */
    private BigDecimal totalAmount;

    /**
     * 是否被锁定冻结
     */
    private Byte isLock;

    /**
     * 是否为分销商 0 否 1 是
     */
    private Byte isDistribut;

    /**
     * 第一个上级
     */
    private Integer firstLeader;

    /**
     * 第二个上级
     */
    private Integer secondLeader;

    /**
     * 第三个上级
     */
    private Integer thirdLeader;

    /**
     * 用于app 授权类似于session_id
     */
    private String token;

    /**
     * 用户名
     */
    private String username;

    /**
     * 加密盐
     */
    private String salt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public BigDecimal getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(BigDecimal frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    public BigDecimal getDistributMoney() {
        return distributMoney;
    }

    public void setDistributMoney(BigDecimal distributMoney) {
        this.distributMoney = distributMoney;
    }

    public Integer getPayPoints() {
        return payPoints;
    }

    public void setPayPoints(Integer payPoints) {
        this.payPoints = payPoints;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getRegTime() {
        return regTime;
    }

    public void setRegTime(Integer regTime) {
        this.regTime = regTime;
    }

    public Integer getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getMobileValidated() {
        return mobileValidated;
    }

    public void setMobileValidated(Byte mobileValidated) {
        this.mobileValidated = mobileValidated;
    }

    public String getOauth() {
        return oauth;
    }

    public void setOauth(String oauth) {
        this.oauth = oauth;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Byte getEmailValidated() {
        return emailValidated;
    }

    public void setEmailValidated(Byte emailValidated) {
        this.emailValidated = emailValidated;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Byte getIsLock() {
        return isLock;
    }

    public void setIsLock(Byte isLock) {
        this.isLock = isLock;
    }

    public Byte getIsDistribut() {
        return isDistribut;
    }

    public void setIsDistribut(Byte isDistribut) {
        this.isDistribut = isDistribut;
    }

    public Integer getFirstLeader() {
        return firstLeader;
    }

    public void setFirstLeader(Integer firstLeader) {
        this.firstLeader = firstLeader;
    }

    public Integer getSecondLeader() {
        return secondLeader;
    }

    public void setSecondLeader(Integer secondLeader) {
        this.secondLeader = secondLeader;
    }

    public Integer getThirdLeader() {
        return thirdLeader;
    }

    public void setThirdLeader(Integer thirdLeader) {
        this.thirdLeader = thirdLeader;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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
        Users other = (Users) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getUserMoney() == null ? other.getUserMoney() == null : this.getUserMoney().equals(other.getUserMoney()))
            && (this.getFrozenMoney() == null ? other.getFrozenMoney() == null : this.getFrozenMoney().equals(other.getFrozenMoney()))
            && (this.getDistributMoney() == null ? other.getDistributMoney() == null : this.getDistributMoney().equals(other.getDistributMoney()))
            && (this.getPayPoints() == null ? other.getPayPoints() == null : this.getPayPoints().equals(other.getPayPoints()))
            && (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getLastLogin() == null ? other.getLastLogin() == null : this.getLastLogin().equals(other.getLastLogin()))
            && (this.getLastIp() == null ? other.getLastIp() == null : this.getLastIp().equals(other.getLastIp()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getMobileValidated() == null ? other.getMobileValidated() == null : this.getMobileValidated().equals(other.getMobileValidated()))
            && (this.getOauth() == null ? other.getOauth() == null : this.getOauth().equals(other.getOauth()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getHeadPic() == null ? other.getHeadPic() == null : this.getHeadPic().equals(other.getHeadPic()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getEmailValidated() == null ? other.getEmailValidated() == null : this.getEmailValidated().equals(other.getEmailValidated()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getIsLock() == null ? other.getIsLock() == null : this.getIsLock().equals(other.getIsLock()))
            && (this.getIsDistribut() == null ? other.getIsDistribut() == null : this.getIsDistribut().equals(other.getIsDistribut()))
            && (this.getFirstLeader() == null ? other.getFirstLeader() == null : this.getFirstLeader().equals(other.getFirstLeader()))
            && (this.getSecondLeader() == null ? other.getSecondLeader() == null : this.getSecondLeader().equals(other.getSecondLeader()))
            && (this.getThirdLeader() == null ? other.getThirdLeader() == null : this.getThirdLeader().equals(other.getThirdLeader()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getUserMoney() == null) ? 0 : getUserMoney().hashCode());
        result = prime * result + ((getFrozenMoney() == null) ? 0 : getFrozenMoney().hashCode());
        result = prime * result + ((getDistributMoney() == null) ? 0 : getDistributMoney().hashCode());
        result = prime * result + ((getPayPoints() == null) ? 0 : getPayPoints().hashCode());
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getLastLogin() == null) ? 0 : getLastLogin().hashCode());
        result = prime * result + ((getLastIp() == null) ? 0 : getLastIp().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getMobileValidated() == null) ? 0 : getMobileValidated().hashCode());
        result = prime * result + ((getOauth() == null) ? 0 : getOauth().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getHeadPic() == null) ? 0 : getHeadPic().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getEmailValidated() == null) ? 0 : getEmailValidated().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getIsLock() == null) ? 0 : getIsLock().hashCode());
        result = prime * result + ((getIsDistribut() == null) ? 0 : getIsDistribut().hashCode());
        result = prime * result + ((getFirstLeader() == null) ? 0 : getFirstLeader().hashCode());
        result = prime * result + ((getSecondLeader() == null) ? 0 : getSecondLeader().hashCode());
        result = prime * result + ((getThirdLeader() == null) ? 0 : getThirdLeader().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", userMoney=").append(userMoney);
        sb.append(", frozenMoney=").append(frozenMoney);
        sb.append(", distributMoney=").append(distributMoney);
        sb.append(", payPoints=").append(payPoints);
        sb.append(", addressId=").append(addressId);
        sb.append(", regTime=").append(regTime);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", qq=").append(qq);
        sb.append(", mobile=").append(mobile);
        sb.append(", mobileValidated=").append(mobileValidated);
        sb.append(", oauth=").append(oauth);
        sb.append(", openid=").append(openid);
        sb.append(", headPic=").append(headPic);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", emailValidated=").append(emailValidated);
        sb.append(", nickname=").append(nickname);
        sb.append(", level=").append(level);
        sb.append(", discount=").append(discount);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", isLock=").append(isLock);
        sb.append(", isDistribut=").append(isDistribut);
        sb.append(", firstLeader=").append(firstLeader);
        sb.append(", secondLeader=").append(secondLeader);
        sb.append(", thirdLeader=").append(thirdLeader);
        sb.append(", token=").append(token);
        sb.append(", username=").append(username);
        sb.append(", salt=").append(salt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}