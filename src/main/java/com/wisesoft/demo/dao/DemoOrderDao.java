package com.wisesoft.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wisesoft.demo.domain.DemoOrder;
import com.wisesoft.demo.domain.query.DemoOrderQuery;
import com.wisesoft.demo.domain.vo.DemoOrderVo;
import com.wisesoft.frame.core.dao.BaseDao;

/**
 * 订单操作类接口
 * @author wangyong
 */
public interface DemoOrderDao extends BaseDao<DemoOrder> {
	
	public Page<DemoOrderVo> queryOrdersByPage(DemoOrderQuery query,Pageable pageable);
	
	public List<DemoOrderVo> queryOrderByUserId(String userId);

}
