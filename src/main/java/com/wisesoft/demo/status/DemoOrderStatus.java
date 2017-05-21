package com.wisesoft.demo.status;

import com.wisesoft.frame.core.status.BaseEnum;

/**
 * 订单状态
 * @author wangyong
 */
public enum DemoOrderStatus implements BaseEnum {
	INVALID("无效"),
	VALID("有效");

	private String label;

	private DemoOrderStatus(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
