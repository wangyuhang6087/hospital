<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>修改医生---2015</title>
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
				window.location.href="${pageContext.request.contextPath}/user/index";
		 });
    });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/edit" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">登陆名</td>
        <td><input type="text" value="${user.user_name }" name="user_name"/>
        	<input type="hidden" value="${user.id }" name="id">
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">密码</td>
        <td><input type="text" name="password" value="${user.password }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">真实姓名</td>
        <td><input type="text" name="real_name" value="${user.real_name }"/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">邮箱</td>
        <td><input type="text" name="email" value="${user.email }"/></td>
    </tr>
    
     <tr>
        <td width="10%" class="tableleft">更改状态</td>
        <td><input type="radio" name="status" value="1"/>启用&nbsp;&nbsp;&nbsp;
        <input type="radio" name="status" value="0"/>禁用</td>
    </tr> 
    <tr>
    	<td width="10%" class="tableleft">当前状态</td>
    	<td>
    		<c:choose>
    			<c:when test="${user.status == 1}">
    				已启用
    			</c:when>
    			<c:when test="${user.status == 0}">
    				未启用
    			</c:when>
    		</c:choose>
    	</td>
    </tr>
    
    <tr>
        <td width="10%" class="tableleft">角色</td>
        <td><select name="role_num">
        <option>---请选择---</option>
        <option value="1">管理系统员</option>
        <option value="2">院长</option>
        <option value="3">医生护士人员</option>
        </select></td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
				
				<button type="submit" class="btn btn-primary" type="button">保存</button>
				 &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
                                                                                            
</body>
</html>  