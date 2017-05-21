<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html >
<head id="Head1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>导航主页</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/sys/main/default.css"  />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/plugins/jquery-easyui-1.4.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/plugins/jquery-easyui-1.4.4/themes/icon.css" />
<script type="text/javascript" src="<%=basePath %>/resources/plugins/jquery/1.11.0/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=basePath %>/resources/plugins/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src='<%=basePath %>/resources/js/system/main/index.js'> </script>

<script type="text/javascript">
var _menus = {
	system:[{
		"menuid" : "10",
		"icon" : "icon-sys",
		"menuname" : "基础数据",
		"menus" : [ {
			"menuid" : "111",
			"menuname" : "基础数据1",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "113",
			"menuname" : "基础数据12",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "115",
			"menuname" : "基础数据13",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "117",
			"menuname" : "基础数据14",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "119",
			"menuname" : "基础数据15",
			"icon" : "icon-nav",
			"url" : "em/enterpriseChannelObtend.action"
		} ]
	}, {
		"menuid" : "20",
		"icon" : "icon-sys",
		"menuname" : "测试一",
		"menus" : [ {
			"menuid" : "211",
			"menuname" : "测试一11",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "213",
			"menuname" : "测试一22",
			"icon" : "icon-nav",
			"url" : "#"
		} ]
	} ],
contract:[{
		"menuid" : "20",
		"icon" : "icon-sys",
		"menuname" : "积分管理",
		"menus" : [ {
			"menuid" : "211",
			"menuname" : "积分用途",
			"icon" : "icon-nav",
			"url" : "#"
		}, {
			"menuid" : "213",
			"menuname" : "积分调整",
			"icon" : "icon-nav",
			"url" : "#"
		} ]

	 }]
 };
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }

        

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
                    if (r) {
                        location.href = '/ajax/loginout.ashx';
                    }
                });
            })
        });
		
		

</script>
<style>
#css3menu li{ float:left; list-style-type:none;}
#css3menu li a{	color:#fff; padding-right:20px;}
#css3menu li a.active{color:yellow;}
</style>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(<%=basePath %>/resources/images/sys/main/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">欢迎 :秀才 
        <a href="#" id="editpass">修改密码</a> 
        <a href="#" id="loginOut">安全退出</a>
        </span>
        <span style="padding-left:10px; font-size: 16px; float:left;">
        <img src="<%=basePath %>/resources/images/sys/main/blocks.gif" width="20" height="20" align="absmiddle" /> 我的帐本</span>
		<ul id="css3menu" style="padding:0px; margin:0px;list-type:none; float:left; margin-left:40px;">
			<!-- <li ><a class="active" name="basic" href="javascript:;" title="基础数据">基础数据</a></li>
			<li><a name="point" href="javascript:;" title="积分管理">积分管理</a></li> -->

		</ul>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">www.segema.cn</div>
    </div>
    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
		<div id='wnav' class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->
		<ul id="leftmenu" class="easyui-tree" data-options="url:'getMenus',method:'get',animate:true,lines:true"
			style="padding:0px; margin:0px;list-type:none; float:left; margin-left:40px;">
			<!-- <li ><a class="active" name="basic" href="javascript:;" title="基础数据">基础数据</a></li>
			<li><a name="point" href="javascript:;" title="积分管理">积分管理</a></li> -->
		</ul>
		</div>
    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;overflow:hidden;" id="home">
				<h1>Welcome to using The jQuery EasyUI!</h1>
			</div>
		</div>
    </div>
    
    
    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="Password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="Password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >确定</a> 
                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
</body>
</html>