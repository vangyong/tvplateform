package com.wisesoft.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wisesoft.frame.core.service.BaseService;
import com.wisesoft.system.domain.SysUser;
import com.wisesoft.system.domain.query.SysGroupUserQuery;
import com.wisesoft.system.domain.vo.SysGroupUserVo;
import com.wisesoft.system.domain.vo.SysResourcesVo;
import com.wisesoft.system.domain.vo.SysSystemVo;

/**
 * 用户基础服务类
 * @author wangyong
 * @date 2014年3月7日下午2:25:54
 */
public interface SysSystemService  {
	
	
	public List<SysSystemVo> querySystems();

}
