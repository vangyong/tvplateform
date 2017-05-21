package com.wisesoft.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisesoft.frame.core.dao.BaseDao;
import com.wisesoft.frame.core.service.impl.BaseServiceImpl;
import com.wisesoft.system.dao.SysSampleDao;
import com.wisesoft.system.domain.SysSample;
import com.wisesoft.system.service.SysSampleService;

/**
 * 字典信息服务类接口实现
 * @author wangyong
 * @date 2014年3月7日下午2:27:08
 */
@Service
public class SysSampleServiceImpl extends BaseServiceImpl<SysSample> implements SysSampleService {
	@Autowired
	private SysSampleDao sysSampleDao;

	@Override
	protected BaseDao<SysSample> getBaseDao() {
		return sysSampleDao;
	}

	@Override
	public List<SysSample> testSelectList(String id) {
		List<SysSample> list  = sysSampleDao.testSelectList(id);
		System.out.println("this");
		return list;
	}
	


}
