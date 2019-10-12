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
	<form action="${pageContext.request.contextPath}/role/edit" method="post" class="definewidth m20" >
	<table class="table table-bordered table-hover definewidth m10">
	    <tr>
	        <td width="10%" class="tableleft">角色名称</td>
	        <td><input type="text" name="title" value="${role.role_name }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">状态</td>
	        <td>
	      <c:choose>
        	<c:when test="${role.statuss  == 1 }">
        		启用
        	</c:when>
        	<c:when test="${role.statuss  == 0 }">
        		关闭
        	</c:when>
        </c:choose>
	        </td>
	    </tr>
	    <tr>
	    	<td>
	    		<input type="checkbox" value="1" name="statuss">启用
	    		<input type="checkbox" value="0" name="statuss">关闭
	    	</td>
	    </tr>
	   
	     
	<%--    <c:forEach items="${role }" var="r"> --%>
	    <tr>
	 	   <td class="tableleft">权限</td>
	        <td>
				<ul><label class='checkbox inline'><input type='checkbox'  name='group[]' checked="checked" value='' /> </label></ul>  
			</td>	<!-- ${r.permission.resource_name } -->
	    </tr>
	   <%--  </c:forEach> --%>
	    
	    <tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="submit" class="btn btn-primary" type="button">更新</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
	        </td>
	    </tr>
	</table>
	</form>	
</body>
</html>