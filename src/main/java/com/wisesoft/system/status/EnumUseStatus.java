package com.wisesoft.system.status;

import com.wisesoft.frame.core.status.BaseEnum;

/**
 * 状态枚举类型
 * @author wangyong
 * @date 2014年3月4日下午5:26:44
 */
public enum EnumUseStatus implements BaseEnum {
	ON("启用"), OFF("注销");

	private EnumUseStatus(String label) {
		this.label = label;
	}

	private String label;

	@Override
	public String getLabel() {
		return this.label;
	}

}
