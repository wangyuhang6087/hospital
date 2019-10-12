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
			url:"${pageContext.request.contextPath}/showEcharts2.do",
			type:"GET",
			success:function(data){
				var myChart = echarts.init(document.getElementById('main'));
				 var option = {
						    title: {
						        text: '折线图堆叠'
						    },
						    tooltip: {
						        trigger: 'axis'
						    },
						    legend: {
						    	data: ["科室1","科室2","科室3","科室4"]
						    },
						    grid: {
						        left: '3%',
						        right: '4%',
						        bottom: '3%',
						        containLabel: true
						    },
						    toolbox: {
						        feature: {
						            saveAsImage: {}
						        }
						    },
						    xAxis: {
						        type: 'category',
						        boundaryGap: false,
						        data: ['周一','周二','周三','周四','周五','周六','周日']
						    },
						    yAxis: {
						        type: 'value'
						    },
						    series: [
						        {
						            name:'科室1',
						            type:'line',
						           // stack: '总量',
						            data:data[0]
						        },
						        {
						            name:'科室2',
						            type:'line',
						          //  stack: '总量',
						            data:data[1]
						        },
						        {
						            name:'科室3',
						            type:'line',
						        //    stack: '总量',
						            data:data[2]
						        },
						        {
						            name:'科室4',
						            type:'line',
						         //   stack: '总量',
						            data:data[3]
						        }
						    ]
						};			 			 
			     myChart.setOption(option);
			}
		});
	});
	</script>
</html>