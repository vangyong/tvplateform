package com.wisesoft.portal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wisesoft.system.domain.query.SysUserQuery;
import com.wisesoft.system.domain.vo.SysUserVo;
import com.wisesoft.system.web.parameter.LoginParameter;

@Controller
@RequestMapping("/portal/main")
public class MainController {
	// 门户首页
	private final static String PORTAL_URL = "portal/index";
	
	private final static String LOGIN_URL = "portal/login";

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView index(@RequestBody LoginParameter parameter) {
		SysUserQuery sysUserQuery = new SysUserQuery();
		sysUserQuery.setUserName(parameter.getUsername());
		sysUserQuery.setPassword(parameter.getPassword());
		SysUserVo sysUserVo = null;//sysUserService.queryOne(sysUserQuery);
		if (sysUserVo == null) {
			return new ModelAndView(PORTAL_URL);
		} else {
			return new ModelAndView(LOGIN_URL);
		}
	}

}
