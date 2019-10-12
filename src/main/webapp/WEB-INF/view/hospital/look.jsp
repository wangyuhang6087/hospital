<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>查看---2015</title>
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
				window.location.href="${pageContext.request.contextPath}/hospital/index";
		 });
    });
    </script>
</head>
<body>

<table class="table table-bordered table-hover definewidth m10">
   <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td>${reg.name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件类型</td>
         <td>${reg.certificateType.name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
         <td>${reg.ID_num }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
       <td>${reg.social_safe_num }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td>${reg.phone }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td>${reg.self_paying ==1?'自费':'非自费'  }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td>${reg.sex ==1?'男':'女' }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td>${reg.age }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">职业</td>
        <td>${reg.career }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初/复诊</td>
        <td>${reg.early_appointment =="初诊"?'初诊':'复诊' }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td>${reg.section.secco_name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td>${reg.doctor.name }</td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td>${reg.noted }</td>
	</tr>
	<tr>
        <td width="10%" class="tableleft">护理人</td>
        <td>${reg.hospitalInfor.caregiver }</td>
	</tr>
	<tr>
        <td width="10%" class="tableleft">床位号</td>
        <td>${reg.hospitalInfor.bed_id }</td>
	</tr>
	<tr>
        <td width="10%" class="tableleft">缴费押金</td>
        <td>${reg.hospitalInfor.pay_the_deposit }</td>
	</tr>
	<tr>
        <td width="10%" class="tableleft">病情</td>
        <td><textarea>${reg.hospitalInfor.state_illness }</textarea></td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>                                                                                          
</body>
</html>    