package com.wisesoft.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wisesoft.demo.dao.DemoOrderDao;
import com.wisesoft.demo.domain.DemoOrder;
import com.wisesoft.demo.domain.query.DemoOrderQuery;
import com.wisesoft.demo.domain.vo.DemoOrderVo;
import com.wisesoft.demo.service.DemoOrderService;
import com.wisesoft.frame.core.dao.BaseDao;
import com.wisesoft.frame.core.service.impl.BaseServiceImpl;

/**
 * 用户信息服务类接口实现
 * @author wangyong
 * @date 2014年3月7日下午2:27:08
 */
@Service
public class DemoOrderServiceImpl extends BaseServiceImpl<DemoOrder> implements DemoOrderService {
	@Autowired
	private DemoOrderDao demoOrderDao;
	

	@Override
	protected BaseDao<DemoOrder> getBaseDao() {
		return demoOrderDao;
	}

	@Override
	public Page<DemoOrderVo> queryOrdersByPage(DemoOrderQuery query,Pageable pageable) {
		return demoOrderDao.queryOrdersByPage(query, pageable);
	}

	@Override
	public List<DemoOrderVo> queryOrderByUserId(String userId) {
		return demoOrderDao.queryOrderByUserId(userId);
	}
	
	

}
