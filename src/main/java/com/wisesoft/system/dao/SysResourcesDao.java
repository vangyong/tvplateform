package com.wisesoft.system.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wisesoft.frame.core.dao.BaseDao;
import com.wisesoft.system.domain.SysUser;
import com.wisesoft.system.domain.query.SysGroupUserQuery;
import com.wisesoft.system.domain.vo.SysGroupUserVo;
import com.wisesoft.system.domain.vo.SysResourcesVo;

/**
 * 用户数据库操作类接口
 * @author wangyong
 * @date 2014年3月3日下午1:30:20
 */
public interface SysResourcesDao  {
	
	public List<SysResourcesVo> queryResources();

}
