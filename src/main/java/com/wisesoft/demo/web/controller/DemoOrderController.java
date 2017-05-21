package com.wisesoft.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wisesoft.demo.domain.DemoOrder;
import com.wisesoft.demo.domain.query.DemoOrderQuery;
import com.wisesoft.demo.domain.vo.DemoOrderVo;
import com.wisesoft.demo.service.DemoOrderService;
import com.wisesoft.demo.web.parameter.DemoOrderParameter;
import com.wisesoft.frame.core.service.BaseService;
import com.wisesoft.frame.core.web.controller.BaseControllerImpl;
import com.wisesoft.frame.core.web.domain.Result;
import com.wisesoft.frame.core.web.domain.Result.Status;

/**
 * 订单的基本操作
 * @author wangyong
 * @date 2014年3月5日上午10:30:16
 */
@Controller
@RequestMapping("/demo/order")
public class DemoOrderController extends BaseControllerImpl<DemoOrder, DemoOrderQuery> {
	
	private Logger log = LoggerFactory.getLogger(DemoOrderController.class);
	
	@Autowired
	private DemoOrderService demoOrderService;

	@Override
	protected BaseService<DemoOrder> getBaseService() {
		return demoOrderService;
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryOrdersByPage",
					method = RequestMethod.POST, 
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					headers="Content-Type=application/json")
	public Result queryOrdersByPage(@RequestBody DemoOrderQuery query,@PageableDefault Pageable pageable) {
		Page<DemoOrderVo> orders = demoOrderService.queryOrdersByPage(query, pageable);
		return new Result(Status.OK,"成功！", orders);
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryOrderByUserId",
					method = RequestMethod.POST, 
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					headers="Content-Type=application/json")
	public Result queryOrderByUserId(@RequestBody DemoOrderParameter parameter) {
		String userId = parameter.getUserId();
		List<DemoOrderVo> orders = demoOrderService.queryOrderByUserId(userId);
		if(null!=orders){
			return new Result(Status.OK,"成功！", orders);
		}else{
			return new Result(Status.ERROR,"失败！");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/add",
					method = RequestMethod.POST, 
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					headers="Content-Type=application/json")
	public Result add(@RequestBody DemoOrderParameter parameter) {
		
		DemoOrder order = new DemoOrder();
		order.setName(parameter.getName());
		order.setPrice(parameter.getPrice());
		demoOrderService.insert(order);
		return new Result(Status.OK,"成功！", order);
	}
	
	@RequestMapping(value = "/queryOrderList",method = RequestMethod.POST)
	public ModelAndView queryOrderList(@RequestBody DemoOrderParameter parameter) {
		
		List<DemoOrder> demoOrderList =  demoOrderService.queryAll();
		ModelAndView mav = new ModelAndView("demo/order/listOrder");
		return mav;
	}
	
	@RequestMapping(value = "/queryOrderById/{id}", method = RequestMethod.GET)
	public ModelAndView queryOrderById(@PathVariable("id") String id) {
		
		List<DemoOrder> demoOrderList =  demoOrderService.queryAll();
		ModelAndView mav = new ModelAndView("demo/order/test");
		return mav;
	}
	

}
