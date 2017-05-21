package com.wisesoft.system.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.wisesoft.frame.core.domain.Identifiable;

public class SysSystem implements Identifiable {
	private static final long serialVersionUID = 7320889646723116007L;
	private String systemId;// id 主键
	private String systemName;
	private String systemCode;
	private String description;
	private Timestamp createTime;
	private BigDecimal deleteStatus;

	
	
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(BigDecimal deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	@Override
	public String getId() {
		return this.systemId;
	}
	@Override
	public void setId(String systemId) {
		this.systemId = systemId;
	}
}
