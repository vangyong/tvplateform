package com.wisesoft.system.dao;

import java.util.List;

import com.wisesoft.frame.core.dao.BaseDao;
import com.wisesoft.system.domain.SysSample;

/**
 * 样品操作类接口
 * @author wangyong
 * @date 2014年3月3日下午1:30:20
 */
public interface SysSampleDao extends BaseDao<SysSample> {
	
	public List<SysSample> testSelectList(String id); 
	

}
