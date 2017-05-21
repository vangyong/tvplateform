package com.wisesoft.system.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wisesoft.system.util.FileOperateUtil;

/**
 * 文件操作控制器
 */
@Controller
@RequestMapping(value = "/fileOperate")
public class FileOperateController {
	/**
	 * 到上传文件的位置
	 * 
	 * @return
	 */
	@RequestMapping(value = "to_upload")
	public ModelAndView toUpload() {
		return new ModelAndView("fileOperate/upload");
	}

	/**
	 * 上传文件
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "upload")
	public ModelAndView upload(HttpServletRequest request) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		// 别名
		String[] alaises = ServletRequestUtils.getStringParameters(request,"alais");

		String[] params = new String[] {"alais"};
		Map<String, Object[]> values = new HashMap<String, Object[]>();
		values.put("alais", alaises);
		List<Map<String, Object>> result = FileOperateUtil.upload(request,params,values);
		map.put("result", result);
		
		List list = new ArrayList();
		Map map1 = new HashMap();
		map1.put("key1", "value1");
		map1.put("key2", "value2");
		list.add(map1);
		
		map.put("list", list);
		
		return new ModelAndView("fileOperate/list", map);
	}

	/**
	 * 下载
	 * 
	 * @author geloin
	 * @date 2012-3-29 下午5:24:14
	 * @param attachment
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "download")
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String storeName = "2015071210300318242480342610.zip";
		String realName = "Java设计模式.zip";
		String contentType = "application/octet-stream";

		FileOperateUtil.download(request, response, storeName, contentType,
				realName);

		return null;
	}
}
