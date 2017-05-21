package com.wisesoft.system.dao;

import java.util.List;

import com.wisesoft.system.domain.vo.SysSystemVo;

/**
 * 用户数据库操作类接口
 * @author wangyong
 * @date 2014年3月3日下午1:30:20
 */
public interface SysSystemDao  {
	
	public List<SysSystemVo> querySystems();

}
