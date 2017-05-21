package com.wisesoft.demo.web.parameter;

import java.math.BigDecimal;

public class DemoOrderParameter {
	
	private String userId;
	
	private String name;
	
	private BigDecimal price;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	

}
