package com.wisesoft.system.domain;

import com.wisesoft.frame.core.domain.Identifiable;

public class SysUser implements Identifiable {
	private static final long serialVersionUID = 48387695771475528L;
	private String userId;// id 主键
	private String userName;
	private String nickName;
	private String password;
	private String mobileNumber;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String getId() {
		return this.userId;
	}

	@Override
	public void setId(String id) {
		this.userId = id;
	}
}
