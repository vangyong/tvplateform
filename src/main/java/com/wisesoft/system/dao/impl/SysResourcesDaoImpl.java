package com.wisesoft.system.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wisesoft.frame.core.dao.impl.BaseDaoImpl;
import com.wisesoft.system.dao.SysResourcesDao;
import com.wisesoft.system.domain.SysResources;
import com.wisesoft.system.domain.vo.SysResourcesVo;

/**
 * 用户数据库操作类接口实现类
 * @author wangyong
 * @date 2014年3月3日下午2:27:45
 */
@Repository
public class SysResourcesDaoImpl extends BaseDaoImpl<SysResources> implements SysResourcesDao {

	@Override
	public List<SysResourcesVo> queryResources() {
		Map params = new HashMap();
		
		List<SysResourcesVo> list = sqlSessionTemplate.selectList("selectResources", params);
		return list;
	}



}
