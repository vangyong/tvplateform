package com.wisesoft.system.dao;

import com.wisesoft.system.domain.vo.SysResourceVo;

import java.util.List;

/**
 * 用户数据库操作类接口
 * @author wangyong
 * @date 2014年3月3日下午1:30:20
 */
public interface SysResourceDao {
	
	public List<SysResourceVo> queryResources();

}
