package com.wisesoft.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wisesoft.frame.core.dao.BaseDao;
import com.wisesoft.frame.core.service.impl.BaseServiceImpl;
import com.wisesoft.system.dao.SysGroupDao;
import com.wisesoft.system.dao.SysResourcesDao;
import com.wisesoft.system.dao.SysSystemDao;
import com.wisesoft.system.dao.SysUserDao;
import com.wisesoft.system.domain.SysUser;
import com.wisesoft.system.domain.query.SysGroupUserQuery;
import com.wisesoft.system.domain.vo.SysGroupUserVo;
import com.wisesoft.system.domain.vo.SysResourcesVo;
import com.wisesoft.system.domain.vo.SysSystemVo;
import com.wisesoft.system.service.SysResourcesService;
import com.wisesoft.system.service.SysSystemService;
import com.wisesoft.system.service.SysUserService;

/**
 * 用户信息服务类接口实现
 * @author wangyong
 * @date 2014年3月7日下午2:27:08
 */
@Service
public class SysSystemServiceImpl  implements SysSystemService {
	@Autowired
	private SysSystemDao sysSystemDao;

	@Override
	public List<SysSystemVo> querySystems() {
		return sysSystemDao.querySystems();
	}
	
	
	
	

}
