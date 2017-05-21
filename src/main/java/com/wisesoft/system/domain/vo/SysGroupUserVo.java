package com.wisesoft.system.domain.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.wisesoft.system.domain.SysGroup;
import com.wisesoft.system.status.EnumBloodType;
import com.wisesoft.system.status.EnumGender;

/**
 * 
 * @author wangyong
 * @date 2014年3月3日下午1:32:09
 */
public class SysGroupUserVo extends SysGroup {
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -1742693268284282756L;

	private String userId;

	private String loginName;

	private String password;

	private String nickName;

	private String mobileNumber;

	private EnumGender gender;

	private String bornAddress;

	private Timestamp bornDate;

	private BigDecimal weight;

	private BigDecimal height;

	private EnumBloodType bloodType;

	private String email;

	private String address;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public EnumGender getGender() {
		return gender;
	}

	public void setGender(EnumGender gender) {
		this.gender = gender;
	}

	public String getBornAddress() {
		return bornAddress;
	}

	public void setBornAddress(String bornAddress) {
		this.bornAddress = bornAddress;
	}

	public Timestamp getBornDate() {
		return bornDate;
	}

	public void setBornDate(Timestamp bornDate) {
		this.bornDate = bornDate;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public EnumBloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(EnumBloodType bloodType) {
		this.bloodType = bloodType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SysGroupUserVo [userId=" + userId + ", loginName=" + loginName
				+ ", password=" + password + ", nickName=" + nickName
				+ ", mobileNumber=" + mobileNumber + ", gender=" + gender
				+ ", bornAddress=" + bornAddress + ", bornDate=" + bornDate
				+ ", weight=" + weight + ", height=" + height + ", bloodType="
				+ bloodType + ", email=" + email + ", address=" + address + "]";
	}

}
