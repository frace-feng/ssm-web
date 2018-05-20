$(function(){
	//ajax动态获取参数
	//var data={"day":7};
	//时间查询：天数
	/*$("#tijiao").click(function(){
		data.day=$("#day").val();
		init();
	})*/
	//时间范围
	/*$("#tijiao1").click(function(){
		data.stime=$("#stime").val();
		data.etime=$("#etime").val();
		init();
	})*/
	$("#submit").on('click',init);
	
	function init(){
		//初始化后，调用日期的参数
		$.ajax({
			url:"/groundInvite/ajaxshowGroundInviteT",
			data:{
				stime:$("#stime").val(),
				etime:$("#etime").val(),
				mobile:$("#mobile").val(),
			},
			type:"get",
			success:function(data){
				console.log(data)
				var mobile =new Array();
				var stime = new Array();
				var etime = new Array();
				var number1 = [];
				var number2 = [];
				var number3 = [];
				var number4 = [];
					stime.push($("#stime").val());
					etime.push($("#etime").val());
					mobile.push($("#mobile").val());
					number1.push(data.num1);
					number2.push(data.num2);
					number3.push(data.num3);
					number4.push(data.num4);
				
				
				 var myChart = echarts.init(document.getElementById('ground'));
			     // 指定图表的配置项和数据
				 var option = {
				         title: {
				             text: '注册量,身份审核通过量,交押金量,有订单量'
				         },
				         toolbox: {
				           
				         },
				         tooltip: {
				        	 trigger: 'axis'
				         },
				         legend: {
				             data:['注册量','身份审核通过量','交押金量','有订单量'],
				             align: 'left'
				         },
				         xAxis: {
				        	 name:"电话",
				        	 type : 'category',
				             data: [mobile],
				             
				         },
				         yAxis: [
				        	 {
				        		 type:'value',
				        		 name:"人数",
				        		 min:0,
				        		 axisLabel: {
				                     formatter: '{value} 人'
				                 }
				        	 }
				         ],
				         series: [		        	
				             {
				            	 name: '注册量',
				            	 type: 'bar',
				            	 barWidth: 20,
				            	 fontWeight: 900,
				            	 data: number1,
				            	 color:'#2f4554',
				            	 smooth: true,
				            	 itemStyle : {
						        	 normal: {
						        		 label : {
						        			 show: true,
						        			 position: 'top' 
						        			 }}},
						     				 
				             },
				             {
				            	 name: '身份审核通过量',
				            	 type: 'bar',
				            	 barWidth: 20,
				            	 fontWeight: 900,
				            	 data: number2,
				            	 color:'#83bff6',
				            	 smooth: true,
				            	 itemStyle : {
						        	 normal: {
						        		 label : {
						        			 show: true,
						        			 position: 'top' 
						        			 }}},
						     				 
				             },
				             {
				            	 name: '交押金量',
				            	 type: 'bar',
				            	 barWidth: 20,
				            	 fontWeight: 900,
				            	 data: number3,
				            	 color:'#188df0',
				            	 smooth: true,
				            	 itemStyle : {
						        	 normal: {
						        		 label : {
						        			 show: true,
						        			 position: 'top' 
						        			 }}},
						     				 
				             },
				             {
				            	 name: '有订单量',
				            	 type: 'bar',
				            	 barWidth: 20,
				            	 fontWeight: 900,
				            	 data: number4,
				            	 color:'#188df0',
				            	 smooth: true,
				            	 itemStyle : {
						        	 normal: {
						        		 label : {
						        			 show: true,
						        			 position: 'top' 
						        			 }}},
						     				 
				             }
				            ],
				     };


			     
			     myChart.setOption(option);
			}
		})
	}
	init();
})