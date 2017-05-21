package com.wisesoft.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisesoft.system.dao.SysResourcesDao;
import com.wisesoft.system.domain.vo.SysResourcesVo;
import com.wisesoft.system.service.SysResourcesService;

/**
 * 用户信息服务类接口实现
 * @author wangyong
 * @date 2014年3月7日下午2:27:08
 */
@Service
public class SysResourcesServiceImpl  implements SysResourcesService {
	@Autowired
	private SysResourcesDao sysResourcesDao;

	@Override
	public List<SysResourcesVo> queryResources() {
		return sysResourcesDao.queryResources();
	}
	
	
	
	

}
