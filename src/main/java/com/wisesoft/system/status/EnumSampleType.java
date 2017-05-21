package com.wisesoft.system.status;

import com.wisesoft.frame.core.status.BaseEnum;

/**
	 * 样品类型枚举类型 food 食物，tool 工具
	 * @author wangyong
	 * @date 2014年3月4日下午4:45:06
	 */
public enum EnumSampleType implements BaseEnum {
	FOOD("食物"), TOOL("工具");

	private String label;

	private EnumSampleType(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
