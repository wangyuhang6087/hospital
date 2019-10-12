<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>添加挂号信息</title>
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
				window.location.href="${pageContext.request.contextPath}/reginf/index";
		 });
    });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/reginf/add" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">门诊编号</td>
        <td><input type="text" name="medical_record"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td><input type="text" name="name"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件类型</td>
        <td><select name="certificate_type">
        <option value="1">身份证</option>
        <option value="2">护照</option>
        <option value="3">军人证</option>
        </select></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td><input type="text" name="ID_num" /></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td><input type="text" name="social_safe_num" /></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">挂号费</td>
        <td><input type="text" name="registration_fee"  /></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td><input type="text" name="phone"  /></td>
    </tr>
    
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td><input type="radio" name="self_paying" value="1" checked/>是&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="self_paying" value="0"/>否</td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">性别</td>
        <td><input type="radio" name="sex" value="1" checked/>男&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="sex" value="0"/>女</td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td><input type="text" name="age" /></td>
    </tr>
   
    <tr>
        <td width="10%" class="tableleft">职业</td>
        <td><input type="text" name="career"/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">初/复诊</td>
        <td><input type="radio" name="early_appointment" value="初诊" checked/>初诊&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="early_appointment" value="复诊"/>复诊</td>
    </tr>
    
    <tr>
        <td width="10%" class="tableleft">所属科室</td>
        <td><select name="section_id">
        <option value="3">外科</option>
        <option value="4">急诊科</option>
        <option value="2">骨科</option>
        <option value="1">血液科</option>
        <option value="5">妇科</option>
        </select></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td><select name="doctor_id">
        <option value="1">华佗</option>
        <option value="2">扁鹊</option>
        <option value="3">老中医1号</option>
        <option value="4">老中医2号</option>
        </select></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">状态</td>
        <td><select name="status">
        <option value="已出院">已出院</option>
        <option value="已挂号">已挂号</option>
        <option value="已结算">已结算</option>
        </select></td>
    </tr>
	<tr>
        <td width="10%" class="tableleft" >备注</td>
        <td><textarea name="noted"></textarea></td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
                                                                                            
</body>
</html> 