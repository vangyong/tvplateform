package com.wisesoft.system.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wisesoft.frame.core.util.MenuUtil;
import com.wisesoft.frame.core.util.TreeObject;
import com.wisesoft.frame.core.web.domain.Result;
import com.wisesoft.frame.core.web.domain.Result.Status;
import com.wisesoft.system.domain.vo.MenuVo;
import com.wisesoft.system.domain.vo.SysResourceVo;
import com.wisesoft.system.domain.vo.SysSystemVo;
import com.wisesoft.system.service.SysResourceService;
import com.wisesoft.system.service.SysSystemService;
import com.wisesoft.system.service.SysUserService;
import com.wisesoft.system.web.parameter.ResourcesParameter;
import com.wisesoft.system.web.parameter.SystemParameter;

@Controller
@RequestMapping("/system/main")
public class SysMainController {
	private Logger log = LoggerFactory.getLogger(SysMainController.class);
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private SysResourceService sysResourcesService;
	
	@Autowired
	private SysSystemService sysSystemService;
	
	/**
	 * main主页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "index")
	public ModelAndView index() throws Exception {
		return new ModelAndView("system/main/index");
	}
	
	@ResponseBody
	@RequestMapping(value = "/getMenus",
					method = RequestMethod.POST, 
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					headers="Content-Type=application/json")
	public List<MenuVo> getMenus(@RequestBody ResourcesParameter parameter) {
		List<SysResourceVo> resourcesList =  sysResourcesService.queryResources();
		List<MenuVo> menuVos = new ArrayList<MenuVo>();
		 if(null!=resourcesList&&resourcesList.size()>0){
			List<TreeObject> treeObjects = new ArrayList<TreeObject>();
			for(SysResourceVo resourcesVo:resourcesList){
				MenuVo menuVo = new MenuVo();
				menuVo.setId(resourcesVo.getResourceId());
				menuVo.setParentId(resourcesVo.getParentId());
				menuVo.setText(resourcesVo.getResourceName());
				menuVo.setIcon(resourcesVo.getIcon());
				menuVos.add(menuVo);
				
				TreeObject treeObject = new TreeObject();
				BeanUtils.copyProperties(resourcesVo, treeObject, null, null);
				treeObjects.add(treeObject);
			}
			MenuUtil menuUtil = new MenuUtil();
			menuVos = menuUtil.getChildMenuVos(menuVos, "0");
			
		/*	TreeUtil treeUtil = new TreeUtil();
			treeObjects = treeUtil.getChildTreeObjects(treeObjects, "0");*/
		 }
		return menuVos;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getSystems",
					method = RequestMethod.POST, 
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					headers="Content-Type=application/json")
	public Result getSystems(@RequestBody SystemParameter parameter) {
		
		List<SysSystemVo> systems = sysSystemService.querySystems();
		Result result = new Result(Status.OK,"成功");
		 if(null!=systems&&systems.size()>0){
			List<MenuVo> menuVos = new ArrayList<MenuVo>();
			for(SysSystemVo systemVo:systems){
				MenuVo menuVo = new MenuVo();
				menuVo.setId(systemVo.getSystemCode());
				menuVo.setText(systemVo.getSystemName());
				menuVo.setIcon(systemVo.getSystemCode());
				menuVos.add(menuVo);
			}
			
			result.setData(menuVos);
		 }
		
		return result;
	}
	
	
}
