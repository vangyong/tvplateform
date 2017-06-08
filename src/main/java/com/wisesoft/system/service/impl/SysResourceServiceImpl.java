package com.wisesoft.system.service.impl;

import com.wisesoft.system.dao.SysResourceDao;
import com.wisesoft.system.domain.vo.SysResourceVo;
import com.wisesoft.system.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息服务类接口实现
 * @author wangyong
 * @date 2014年3月7日下午2:27:08
 */
@Service
public class SysResourceServiceImpl implements SysResourceService{
	@Autowired
	private SysResourceDao sysResourceDao;

	@Override
	public List<SysResourceVo> queryResources() {
		return sysResourceDao.queryResources();
	}
	
	
	
	

}
