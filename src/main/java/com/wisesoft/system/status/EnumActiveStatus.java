package com.wisesoft.system.status;

import com.wisesoft.frame.core.status.BaseEnum;

/**
 * 性别枚举类型
 * 
 * @author wangyong
 * @date 2014年9月12日下午4:45:06
 */
public enum EnumActiveStatus implements BaseEnum {
	INVALID("无效"),
	VALID("有效");

	private String label;

	private EnumActiveStatus(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
