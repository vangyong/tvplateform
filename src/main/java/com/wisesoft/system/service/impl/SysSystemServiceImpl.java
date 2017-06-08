package com.wisesoft.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisesoft.system.dao.SysSystemDao;
import com.wisesoft.system.domain.vo.SysSystemVo;
import com.wisesoft.system.service.SysSystemService;

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
