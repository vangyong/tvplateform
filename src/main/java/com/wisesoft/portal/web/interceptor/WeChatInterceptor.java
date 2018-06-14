package com.wisesoft.portal.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class WeChatInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// 获取用户将要去的路径
		String queryString = arg0.getQueryString();
		System.out.println(queryString);
		// 被拦截前的请求URL
		String toUrl = arg0.getRequestURI();
		System.out.println(toUrl);

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// 获取用户将要去的路径
		String queryString = arg0.getQueryString();
		System.out.println(queryString);
		// 被拦截前的请求URL
		String toUrl = arg0.getRequestURI();
		System.out.println(toUrl);

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// 获取用户将要去的路径
		String queryString = arg0.getQueryString();
		System.out.println(queryString);
		// 被拦截前的请求URL
		String toUrl = arg0.getRequestURI();
		System.out.println(toUrl);

		return true;
	}

}
