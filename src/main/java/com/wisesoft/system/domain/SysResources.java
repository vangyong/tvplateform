package com.wisesoft.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class SysResources implements Serializable {
	private static final long serialVersionUID = 4989087280573499064L;
	private String resourcesId;
	private String resourcesName;
	private String parentId;
	private String resourcesCode;
	private String type;
	private String resourcesUrl;
	private String level;
	private String icon;
	private BigDecimal isHide;
	private String description;
	private BigDecimal deleteStatus;

	public String getResourcesId() {
		return resourcesId;
	}
	public void setResourcesId(String resourcesId) {
		this.resourcesId = resourcesId;
	}
	public String getResourcesName() {
		return resourcesName;
	}
	public void setResourcesName(String resourcesName) {
		this.resourcesName = resourcesName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getResourcesCode() {
		return resourcesCode;
	}
	public void setResourcesCode(String resourcesCode) {
		this.resourcesCode = resourcesCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getResourcesUrl() {
		return resourcesUrl;
	}
	public void setResourcesUrl(String resourcesUrl) {
		this.resourcesUrl = resourcesUrl;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public BigDecimal getIsHide() {
		return isHide;
	}
	public void setIsHide(BigDecimal isHide) {
		this.isHide = isHide;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(BigDecimal deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
}
