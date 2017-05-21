package com.wisesoft.system.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wisesoft.frame.core.constants.SqlId;
import com.wisesoft.frame.core.dao.impl.BaseDaoImpl;
import com.wisesoft.system.dao.SysSampleDao;
import com.wisesoft.system.domain.SysSample;

/**
 * 样品操作类接口实现类
 * @author wangyong
 * @date 2014年3月3日下午2:27:45
 */
@Repository
public class SysSampleDaoImpl extends BaseDaoImpl<SysSample> implements SysSampleDao {

	@Override
	public List<SysSample> testSelectList(String id) {
		Map params = new HashMap();
		params.put("sampleId", id);
		
		List<SysSample> list = sqlSessionTemplate.selectList("testSelectList", params);
		return list;
	}

	
}
