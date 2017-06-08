package com.wisesoft.system.web.controller;

import com.wisesoft.frame.core.util.MenuUtil;
import com.wisesoft.frame.core.util.TreeObject;
import com.wisesoft.frame.core.web.domain.Result;
import com.wisesoft.system.domain.query.SysUserQuery;
import com.wisesoft.system.domain.vo.MenuVo;
import com.wisesoft.system.domain.vo.SysResourceVo;
import com.wisesoft.system.domain.vo.SysUserVo;
import com.wisesoft.system.service.SysResourceService;
import com.wisesoft.system.service.SysSystemService;
import com.wisesoft.system.service.SysUserService;
import com.wisesoft.system.web.parameter.ResourcesParameter;
import com.wisesoft.system.web.parameter.SystemParameter;
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

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BackgroundController {

    private Logger log = LoggerFactory.getLogger(BackgroundController.class);
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private SysSystemService sysSystemService;

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String login(String username, String password) {
        return "redirect:index";
    }

    @RequestMapping(value = "index")
    public ModelAndView index() throws Exception {
        return new ModelAndView("/system/main/index");
    }

    @RequestMapping(value = "login", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String login(HttpServletRequest request) {
        request.removeAttribute("error");
        return "/login";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request) {
        SysUserQuery sysUserQuery = new SysUserQuery();
        sysUserQuery.setUserName(username);
        sysUserQuery.setPassword(password);
        SysUserVo sysUserVo = sysUserService.queryOne(sysUserQuery);
        return "/index";
    }

    @ResponseBody
    @RequestMapping(value = "/getMenus",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers="Content-Type=application/json")
    public List<MenuVo> getMenus(@RequestBody ResourcesParameter parameter) {
        List<SysResourceVo> resourcesList =  sysResourceService.queryResources();
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

        List<SysResourceVo> resources =  sysResourceService.queryResources();


       // List<SysSystemVo> systems = sysSystemService.querySystems();
        Result result = new Result(Result.Status.OK,"成功");
        if(null!=resources&&resources.size()>0){
            List<MenuVo> menuVos = new ArrayList<MenuVo>();
            for(SysResourceVo resourcesVo:resources){
                MenuVo menuVo = new MenuVo();
                menuVo.setId(resourcesVo.getResourceCode());
                menuVo.setText(resourcesVo.getResourceName());
                menuVo.setIcon(resourcesVo.getIcon());
                menuVos.add(menuVo);
            }

            result.setData(menuVos);
        }

        return result;
    }


    @RequestMapping("install")
    public String install() throws Exception {

        try {
           /* Properties props = Resources.getResourceAsProperties("jdbc.properties");
            String url = props.getProperty("jdbc.url");
            String driver = props.getProperty("jdbc.driverClass");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            Class.forName(driver).newInstance();
            Connection conn = (Connection) DriverManager.getConnection(url, username, password);
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);
            runner.runScript((new InputStreamReader(getClass().getResourceAsStream("/intall.sql"),"UTF-8")));*/

        } catch (Exception e) {
            e.printStackTrace();
            return "初始化失败！请联系管理员" + e;
        }

        return "/install";
    }

}
