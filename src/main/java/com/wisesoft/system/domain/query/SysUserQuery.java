package com.wisesoft.system.domain.query;

import com.wisesoft.system.domain.SysUser;

/**
 * 
 * @author wangyong
 * @date 2014年3月3日下午1:31:18
 */
public class SysUserQuery extends SysUser {
	
	private static final long serialVersionUID = 2239335166745111671L;
	
	private String userNameLike;
	
	public String getUserNameLike() {
		return userNameLike;
	}
	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}

	
	
}
