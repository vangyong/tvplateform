package com.wisesoft.system.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wisesoft.frame.core.web.domain.Result;
import com.wisesoft.frame.core.web.domain.Result.Status;
import com.wisesoft.system.domain.SysUser;
import com.wisesoft.system.domain.query.SysUserQuery;
import com.wisesoft.system.domain.vo.SysUserVo;
import com.wisesoft.system.service.SysUserService;
import com.wisesoft.system.web.parameter.LoginParameter;
import com.wisesoft.system.web.parameter.RegisterParameter;

@Controller
@RequestMapping("/system/login")
public class SysLoginController {
	private Logger log = LoggerFactory.getLogger(SysLoginController.class);

	private final static String LOGIN_URL = "portal/login";

	// 门户首页
	private final static String PORTAL_URL = "portal/index";

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestBody LoginParameter parameter) {
		SysUserQuery sysUserQuery = new SysUserQuery();
		sysUserQuery.setUserName(parameter.getUsername());
		sysUserQuery.setPassword(parameter.getPassword());
		SysUserVo sysUserVo = sysUserService.queryOne(sysUserQuery);
		if (sysUserVo == null) {
			return new ModelAndView(PORTAL_URL);
		} else {
			return new ModelAndView(LOGIN_URL);
		}
	}

}
