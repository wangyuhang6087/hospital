<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
 <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/style.css" />
<link href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/jquery.sorted.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/common.js"></script>
 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/role/index";
		 });
    });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/role/add" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
            <td width="10%" class="tableleft">角色名称</td>
            <td><input type="text" name="role_name"/></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
                <input type="radio" name="statuss" value="1" checked/>启用  
                <input type="radio" name="statuss" value="0"/> 禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft">权限</td>
            <td>
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='1' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;挂号信息管理</ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='2' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门诊医生管理</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='3' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;药品管理</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='4' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住院办理</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='5' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收费项目登记</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='6' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在院发药</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='7' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住院结算</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='8' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月营业额统计</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='9' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年营业额统计</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='10' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户管理</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='11' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;角色管理</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='12' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资源管理</label></ul> 
                <ul><label class='checkbox inline'><input type='checkbox' name='group' value='13' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码管理</label></ul> 
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
</table>
</form>
                                                                                            
</body>
</html> 