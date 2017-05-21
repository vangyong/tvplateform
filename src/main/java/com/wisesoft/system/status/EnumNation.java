package com.wisesoft.system.status;

import com.wisesoft.frame.core.status.BaseEnum;

/**
 * 国家枚举类型
 * @author wangyong
 * @date 2014年9月12日下午4:45:06
 */
public enum EnumNation {
	CHINA(0), JAPANESE(1), AMERICA(2);
	// 定义私有变量
	private int nCode;

	// 构造函数，枚举类型只能为私有
	private EnumNation(int nCode) {
		this.nCode = nCode;
	}
	@Override
	public String toString() {
		return String.valueOf(this.nCode);
	}
}
