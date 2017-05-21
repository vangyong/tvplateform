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
import com.wisesoft.system.dao.SysUserDao;
import com.wisesoft.system.domain.SysUser;
import com.wisesoft.system.domain.query.SysGroupUserQuery;
import com.wisesoft.system.domain.vo.SysGroupUserVo;
import com.wisesoft.system.service.SysUserService;

/**
 * 用户信息服务类接口实现
 * @author wangyong
 * @date 2014年3月7日下午2:27:08
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysGroupDao sysGroupDao;

	@Override
	protected BaseDao<SysUser> getBaseDao() {
		return sysUserDao;
	}

	@Override
	public Page<SysGroupUserVo> queryGroupUser(SysGroupUserQuery query,Pageable pageable) {
		return sysUserDao.queryGroupUser(query, pageable);
	}

	@Override
	public List<SysGroupUserVo> queryGroupUser(String userId) {
		List<SysGroupUserVo> users = new ArrayList<SysGroupUserVo>();
		for(int i=0;i<3;i++){
			SysGroupUserVo sysGroupUserVo = new SysGroupUserVo();
			sysGroupUserVo.setUserId(UUID.randomUUID().toString());
			sysGroupUserVo.setNickName("nickName");
			users.add(sysGroupUserVo);
		}
		return users;
	}
	
	

}
