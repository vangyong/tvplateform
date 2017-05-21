package com.wisesoft.system.status;


/**
 * 性别枚举类型
 * @author wangyong
 * @date 2014年9月12日下午4:45:06
 */
public enum EnumGender {
	MALE(0), FEMALE(1), SECRET(2);
	// 定义私有变量
	private int nCode;

	// 构造函数，枚举类型只能为私有
	private EnumGender(int nCode) {
		this.nCode = nCode;
	}
	@Override
	public String toString() {
		return String.valueOf(this.nCode);
	}
}
