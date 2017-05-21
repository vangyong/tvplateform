package com.wisesoft.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wisesoft.demo.domain.DemoOrder;
import com.wisesoft.demo.domain.query.DemoOrderQuery;
import com.wisesoft.demo.domain.vo.DemoOrderVo;
import com.wisesoft.frame.core.service.BaseService;

/**
 * 用户基础服务类
 * @author wangyong
 * @date 2014年3月7日下午2:25:54
 */
public interface DemoOrderService extends BaseService<DemoOrder> {
	
	public Page<DemoOrderVo> queryOrdersByPage(DemoOrderQuery query,Pageable pageable);
	
	public List<DemoOrderVo> queryOrderByUserId(String userId);

}
