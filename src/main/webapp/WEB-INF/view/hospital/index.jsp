<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>住院办理---2015</title>
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

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

</head>

<form action="${pageContext.request.contextPath}/hospital/index" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
 <tr>
        <td width="10%" class="tableleft">病历号：</td>
        <td><input type="text" name="medical_record" /></td>
		
        <td width="10%" class="tableleft">主治医生：</td>
        <td><input type="text" name="doctor_name" /></td>
		
        <td width="10%" class="tableleft">科室：</td>
        <td><input type="text" name="secco_name" /></td>
    </tr>
    <tr>
		
        <td width="10%" class="tableleft">挂号时间：</td>
		  <td colspan="5">
			<input type="text" name="startTime" />&nbsp;至&nbsp;
			<input type="text" name="endTime" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-primary" type="button">查询</button> 
            <button type="reset" class="btn btn-primary" type="button">清空</button> 
			
        </td>
    </tr>
</table>
</form>
  
<form action="${pageContext.request.contextPath}/hospital/deleteMore" method="post">    
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="all" onclick="checkall()"/>全选/不选</th>
        <th>病历号</th>
        <th>姓名</th>
        <th>床位号</th>
        <th>联系电话</th>
        <th>押金</th>
        <th>主治医生</th>
        <th>入院时间</th>
        <th>科室</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    
	   	<c:forEach items="${lists }" var="h">
			<tr>
				<td><input value="${h.medical_record }" name="id" type="checkbox"></td>
				<td>${h.medical_record }</td>
				<td>${h.registrationInfor.name }</td>
				<td>${h.hospitalInfor.bed_id }</td>
				<td>${h.registrationInfor.phone }</td>
				<td>${h.cash_pledge }</td>
				<td>${h.doctor.name }</td>
				<td>${h.registrationInfor.time }</td>
				<td>${h.section.secco_name }</td>
				<td>
					${h.clear_status ==1?'已结算':'未结算' }
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/hospital/look?id=${h.medical_record }">详情>></a>
					<a href="${pageContext.request.contextPath}/hospital/edit?id=${h.medical_record }">更改</a>
					<a href="${pageContext.request.contextPath}/hospital/delete?id=${h.medical_record }" onclick="method()">出院</a>
				</td>
			</tr>
		</c:forEach> 
  </table>
		 <div><button type="button" class="btn btn-success" id="newNav">录入住院信息</button>&nbsp;&nbsp;&nbsp;
		<!--  <button type="submit" class="btn btn-success" id="delPro" onclick="delAll()">出院</button>&nbsp;&nbsp;&nbsp; -->
		 <button  type="submit" class="btn btn-success" id="delPro" onclick="delAll()">退院</button>&nbsp;&nbsp;&nbsp; 
		 <button type="button" class="btn btn-success" id="delPro">导出Excel</button>
		 <button type="button" class="btn btn-success" id="delPro">打印</button></div>
		
</form> 	
<br>
<br>
	<p>共${total }条记录,当前${page.pageNum }/${page.pages }页</p>	
<div style="size: 50px">		
<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="${pageContext.request.contextPath}/hospital/index?pageNo=${page.pageNum - 1}&medical_record=${map.medical_record}&doctor_name=${map.doctor_name}&secco_name=${map.secco_name}&startTime=${map.startTime}&endTime=${map.endTime}"   aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
   <c:forEach var="i" begin="1" end="${page.pages }" step="1">
   		<li><a href="${pageContext.request.contextPath}/hospital/index?pageNo=${i}&medical_record=${map.medical_record}&doctor_name=${map.doctor_name}&secco_name=${map.secco_name}&startTime=${map.startTime}&endTime=${map.endTime}" >${i}</a></li>
   </c:forEach>
    <li>
      <a href="${pageContext.request.contextPath}/hospital/index?pageNo=${page.pageNum + 1}&medical_record=${map.medical_record}&doctor_name=${map.doctor_name}&secco_name=${map.secco_name}&startTime=${map.startTime}&endTime=${map.endTime}"  aria-label="Next">
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
		event.returnValue = confirm("将这些编号退院吗??");
	}else{
		alert("请选中要退院的项");
	}
}


	  
	 function method(){
			event.returnValue = confirm("确认要退院吗?");
		}
	
	
	 $(function () {
			$('#newNav').click(function(){
					window.location.href="${pageContext.request.contextPath}/hospital/add";
			 });
	 });
		
</script>
</body>
</html>