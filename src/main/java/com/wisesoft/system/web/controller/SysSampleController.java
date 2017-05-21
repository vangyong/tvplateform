package com.wisesoft.system.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wisesoft.frame.core.service.BaseService;
import com.wisesoft.frame.core.web.controller.BaseControllerImpl;
import com.wisesoft.system.domain.SysSample;
import com.wisesoft.system.domain.query.SysSampleQuery;
import com.wisesoft.system.service.SysSampleService;

/**
 * 字典信息的基本操作
 * @author wangyong
 * @date 2014年3月5日上午10:30:16
 */
@Controller
@RequestMapping("/system/sample")
public class SysSampleController extends BaseControllerImpl<SysSample, SysSampleQuery> {
	@Autowired
	private SysSampleService sysSampleService;

	@Override
	protected BaseService<SysSample> getBaseService() {
		return sysSampleService;
	}
	
	@RequestMapping(value ="testSelectList",method = RequestMethod.POST)
	public ModelAndView testSelectList() {
		String id ="123";
		List<SysSample> list = sysSampleService.testSelectList(id);
		ModelAndView mav = new ModelAndView(path.getListViewPath(), "list", list);
		return mav;
	}
	
	@RequestMapping(value ="testSelectList2",method = RequestMethod.POST)
	public String testSelectList2() {
		String id ="123";
		List<SysSample> list = sysSampleService.testSelectList(id);
		return "user/user";
	}
	
	 @RequestMapping(value="/getUserName",method=RequestMethod.POST)
	  public String getUserName(@RequestParam(value="name") String name){
		 System.out.println("测试");
	        return "user/user";
	    }

}
