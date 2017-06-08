package com.wisesoft.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class SysResource implements Serializable {
    private static final long serialVersionUID = 4989087280573499064L;
    private String resourceId;
    private String resourceName;
    private String parentId;
    private String resourceCode;
    private String type;
    private String resourceUrl;
    private String level;
    private String icon;
    private BigDecimal isHide;
    private String description;
    private BigDecimal deleteStatus;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
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
