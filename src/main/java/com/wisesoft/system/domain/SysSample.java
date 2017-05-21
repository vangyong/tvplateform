package com.wisesoft.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.wisesoft.frame.core.domain.Identifiable;
import com.wisesoft.system.status.EnumActiveStatus;
import com.wisesoft.system.status.EnumSampleType;

public class SysSample implements Identifiable {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 3660184499862071843L;

	/**
	 * @fields id 主键
	 */
	private String sampleId;

	/**
	 * @fields sampleName 样品名称
	 */
	private String sampleName;

	/**
	 * @fields sampleValue 样品值
	 */
	private String sampleValue;
	/**
	 * @fields sampleGroup 样品分组
	 */
	private String sampleGroup;
	/**
	 * @fields sampleType 样品类型
	 */
	private EnumSampleType sampleType;
	/**
	 * @fields sampleOrder 样品排序
	 */
	private Integer sampleOrder;
	/**
	 * @fields sampleStatus 样品状态
	 */
	private EnumActiveStatus sampleStatus;

	public String getSampleId() {
		return sampleId;
	}

	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public String getSampleValue() {
		return sampleValue;
	}

	public void setSampleValue(String sampleValue) {
		this.sampleValue = sampleValue;
	}

	public String getSampleGroup() {
		return sampleGroup;
	}

	public void setSampleGroup(String sampleGroup) {
		this.sampleGroup = sampleGroup;
	}

	public EnumSampleType getSampleType() {
		return sampleType;
	}

	public void setSampleType(EnumSampleType sampleType) {
		this.sampleType = sampleType;
	}

	public Integer getSampleOrder() {
		return sampleOrder;
	}

	public void setSampleOrder(Integer sampleOrder) {
		this.sampleOrder = sampleOrder;
	}

	public EnumActiveStatus getSampleStatus() {
		return sampleStatus;
	}

	public void setSampleStatus(EnumActiveStatus sampleStatus) {
		this.sampleStatus = sampleStatus;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getId() {
		return this.sampleId;
	}

	public void setId(String id) {
		this.sampleId=id;
		
	}

}
