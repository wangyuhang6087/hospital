<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>药品信息</title>
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
</head>
<body>

<form action="${pageContext.request.contextPath}/medicine/index" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">药品名称：</td>
        <td><input type="text" name="drug_name" /></td>
		
        <td width="10%" class="tableleft">药品类型：</td>
        <td><select name="drug_type">
        <option value="">请选择</option> 
        <option value="1">中药</option>
        <option value="2">西药</option>
        <option value="3">处方</option>
        <option value="4">非处方</option>
        </select></td>
    </tr>
    <tr>
		
		
		  <td colspan="4">
			<center>
				<button type="submit" class="btn btn-primary" type="button">查询</button> 
				<button type="submit" class="btn btn-primary" type="button">清空</button> 
			</center>
        </td>
    </tr>
</table>
</form>


 <form action="${pageContext.request.contextPath}/medicine/deleteMore" method="post">  
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="all" onclick="checkall()" />全选/不选</th>
        <th>药品编号</th>
        <th>药品名称</th>
        <th>药品类型</th>
        <th>简单描述</th>
        <th>状态</th>
        <th>剩余量</th>
        <th>操作</th>
    </tr>
    </thead>
    
	<c:forEach items="${lists }" var="drug">
			<tr>
				<td><input value="${drug.drug_num }" name="id" type="checkbox"></td>
				<td>${drug.drug_num }</td>
				<td>${drug.drug_name }</td>
				<td>${drug.drug_type }</td>
				<td>${drug.simple_detail }</td>
				<td>
					${drug.status ==1?'销售中':'已售完' }
				</td>
				<td >${drug.surplus }</td>
				<td><a href="${pageContext.request.contextPath}/medicine/edit?id=${drug.drug_num }">更改</a>丨
					<a href="${pageContext.request.contextPath}/medicine/look?id=${drug.drug_num }">详情>></a>
				</td>
			</tr>
		</c:forEach>    
  </table>
  	<button type="button" class="btn btn-success" id="newNav">添加新药</button>
  	<button type="submit" class="btn btn-success" >批量删除</button>
  	<button type="button" class="btn btn-success"  >导出Excel</button> 
  	<button type="button" class="btn btn-success"  >导出txt</button>   
</form> 	
<br>
<br>
	<p>共${total }条记录,当前${page.pageNum }/${page.pages }页</p>	
	
<div style="size: 50px">		
<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="${pageContext.request.contextPath}/medicine/index?pageNo=${page.pageNum - 1}&drug_name=${drug_name}&drug_type=${drug_type}"   aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
   <c:forEach var="i" begin="1" end="${page.pages }" step="1">
   		<li><a href="${pageContext.request.contextPath}/medicine/index?pageNo=${i}&drug_name=${drug_name}&drug_type=${drug_type}" >${i}</a></li>
   </c:forEach>
    <li>
      <a href="${pageContext.request.contextPath}/medicine/index?pageNo=${page.pageNum + 1}&drug_name=${drug_name}&drug_type=${drug_type}"  aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>
	 
<script type="text/javascript">
//批量删除			
function checkall() {
//	var allNode = document.getElementsByName("all")[0];
	var allNode = document.getElementById("all");
	var idNodes = document.getElementsByName("id");
	for (i = 0; i < idNodes.length; i++) {
		idNodes[i].checked = allNode.checked;
	}
}
			
function delAll(){
	var alls=document.getElementsByName("id");
	var ids=new Array();
	for(var i=0;i<alls.length;i++){
		if(alls[i].checked){
			ids.push(alls[i].value);
		}		
	}
	if(ids.length>0){
		event.returnValue = confirm("你确认要删除吗?");
	}else{
		alert("请选中要删除的项");
	}
}
	 
	 $(function () {
			$('#newNav').click(function(){
				window.location.href="${pageContext.request.contextPath}/medicine/add";
			 });
	    }); 
</script>		                                                                                          
</body>
</html>