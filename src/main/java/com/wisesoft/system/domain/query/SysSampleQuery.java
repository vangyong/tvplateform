package com.wisesoft.system.domain.query;

import com.wisesoft.system.domain.SysSample;

/**
 * 
 * @author wangyong
 * @date 2014年3月3日下午1:31:18
 */
public class SysSampleQuery extends SysSample {
	private static final long serialVersionUID = -794158397333506942L;
	/**
	 * @fields sampleNameLike 样品名称模糊查询
	 */
	private String sampleNameLike;

	public String getSampleNameLike() {
		return sampleNameLike;
	}

	public void setSampleNameLike(String sampleNameLike) {
		this.sampleNameLike = sampleNameLike;
	}
	
}
