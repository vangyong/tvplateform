package com.wisesoft.system.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wisesoft.frame.core.dao.impl.BaseDaoImpl;
import com.wisesoft.system.dao.SysSystemDao;
import com.wisesoft.system.domain.SysSystem;
import com.wisesoft.system.domain.vo.SysResourcesVo;
import com.wisesoft.system.domain.vo.SysSystemVo;

/**
 * 用户数据库操作类接口实现类
 * @author wangyong
 * @date 2014年3月3日下午2:27:45
 */
@Repository
public class SysSystemDaoImpl extends BaseDaoImpl<SysSystem> implements SysSystemDao {

	@Override
	public List<SysSystemVo> querySystems() {
		Map params = new HashMap();
		
		List<SysSystemVo> list = sqlSessionTemplate.selectList("selectSystems", params);
		return list;
	}



}
