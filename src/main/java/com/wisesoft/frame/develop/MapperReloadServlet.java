package com.wisesoft.frame.develop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

public class MapperReloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MapperReloadServlet() {
		super();
	}

	public void init() throws ServletException {
		Logger logger = Logger.getLogger(this.getClass());
		logger.info("The mapper reload timer starting... ");

		try {
			new SqlSessionCache().refreshMapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}