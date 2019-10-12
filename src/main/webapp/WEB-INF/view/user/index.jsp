<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	
	#div{
		
		margin-left: 20px;
	}
	
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/index" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">

			<tr>
				<td>名字<input type="text" name="keyword" value="${map.keyword }"></td>
				
			</tr>
			<tr>
				<td colspan="6"><center>
						<button type="submit" class="btn btn-primary" type="button">查询</button>
						<button type="reset" class="btn btn-primary" type="button">清空</button>
					</center></td>
			</tr>
		</table>	
</form>
	
<form action="${pageContext.request.contextPath}/user/deleteMore" method="post" class="definewidth m20">	
<table class="table table-bordered table-hover definewidth m10">
    		<tr>
				<td><input type="checkbox" name="all" onclick="checkall()" />全选/不选</td>
				<td>用户编号</td>
				<td>用户账户</td>
				<td>真实姓名</td>
				<td>角色</td>
				<td>操作</td>
			</tr>
	  
	<c:forEach items="${lists }" var="u">
			<tr>
				<td><input value="${u.id }" name="id" type="checkbox"></td>				
				<td>${u.id }</td>
				<td>${u.user_name }</td>
				<td>${u.real_name }</td>
				<td style="vertical-align: middle;">
					${u.role.role_name }
				</td>
				<td><a href="${pageContext.request.contextPath}/user/edit?id=${u.id }">编辑</a>
					<a href="${pageContext.request.contextPath}/user/delete?id=${u.id }">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<button type="submit" class="btn btn-success" >批量删除</button>
	<button type="button" class="btn btn-success" id="newNav">添加新用户</button>
	<!-- <button type="button" class="btn btn-success" id="delPro" >导出Excel</button> -->
	</form>
	
<br>
	
	
<div style="size: 50px" id="div">	
<p>共${total }条记录,当前${page.pageNum }/${page.pages }页</p>		
<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="${pageContext.request.contextPath}/user/index?pageNo=${page.pageNum - 1}&keyword=${map.keyword}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
   <c:forEach var="i" begin="1" end="${page.pages }" step="1">
   		<li><a href="${pageContext.request.contextPath}/user/index?pageNo=${i}&keyword=${map.keyword}">${i}</a></li>
   </c:forEach>
    <li>
      <a href="${pageContext.request.contextPath}/user/index?pageNo=${page.pageNum + 1}&keyword=${map.keyword}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>

		 
<script type="text/javascript">
	function checkall() {
	var allNode = document.getElementsByName("all")[0];
	var itemNodes = document.getElementsByName("id");
	for (i = 0; i < itemNodes.length; i++) {
		if (allNode.checked) {
			itemNodes[i].checked = allNode.checked;
		} else {
			itemNodes[i].checked = allNode.checked;
		}
	}
}
	 $(function () {
			$('#newNav').click(function(){
					window.location.href="${pageContext.request.contextPath}/user/add";
			 });
	    });
	
	 </script>	                                                                                  
</body>
</html>   