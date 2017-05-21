package com.wisesoft.system.status;


/**
 * 血型类型枚举类型
 * @author wangyong
 * @date 2014年9月12日下午4:45:06
 */
public enum EnumBloodType {
	A(0), B(1), AB(2), O(3), RH(4);
	// 定义私有变量
	private int nCode;

	// 构造函数，枚举类型只能为私有
	private EnumBloodType(int nCode) {
		this.nCode = nCode;
	}
	@Override
	public String toString() {
		return String.valueOf(this.nCode);
	}
}
