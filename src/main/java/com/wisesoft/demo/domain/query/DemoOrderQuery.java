package com.wisesoft.demo.domain.query;

import com.wisesoft.demo.domain.DemoOrder;


/**
 * @author wangyong
 */
public class DemoOrderQuery extends DemoOrder {
	
	private static final long serialVersionUID = 2239335166745111671L;
	
	private String userNameLike;
	
	public String getUserNameLike() {
		return userNameLike;
	}
	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}

	
	
}
