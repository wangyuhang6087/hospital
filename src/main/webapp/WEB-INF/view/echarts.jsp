<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/echarts.min.js"></script>
</head>
<body>
	<!-- 为ECharts准备一个具备大小的DOM容器 -->
	<div id="main" style="width: 600px;height: 400px;"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
		// ajax发出请求,获得数据,利用echarts
		$.ajax({
			url:"${pageContext.request.contextPath}/showEcharts.do",
			type:"GET",
			success:function(parameter){
				var myChart = echarts.init(document.getElementById('main'));
				 var option = {
				            title: {
				                text: 'ECharts 入门示例'
				            },
				            tooltip: {},
				            legend: {
				                data:['销量']
				            },
				            xAxis: {
				                data: ["周一","周二","周三","周四","周五","周六","周日"]
				            },
				            yAxis: {},
				            series: [{
				                name: '销量',
				                type: 'line',
				                data: parameter
				            }]
				        };
			        // 使用刚指定的配置项和数据显示图表。
			     myChart.setOption(option);
			}
		});
	});
	</script>
</html>