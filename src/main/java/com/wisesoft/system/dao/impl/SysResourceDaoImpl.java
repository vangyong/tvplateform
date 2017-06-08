package com.wisesoft.system.dao.impl;

import com.wisesoft.frame.core.dao.impl.BaseDaoImpl;
import com.wisesoft.system.dao.SysResourceDao;
import com.wisesoft.system.domain.SysResource;
import com.wisesoft.system.domain.vo.SysResourceVo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户数据库操作类接口实现类
 * @author wangyong
 * @date 2014年3月3日下午2:27:45
 */
@Repository
public class SysResourceDaoImpl extends BaseDaoImpl<SysResource> implements SysResourceDao {

	@Override
	public List<SysResourceVo> queryResources() {
		Map params = new HashMap();
		
		List<SysResourceVo> list = sqlSessionTemplate.selectList("selectResources", params);
		return list;
	}

}
