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
	$("#tijiao1").on('click',init);
	
	function init(){
		//初始化后，调用日期的参数
		$.ajax({
			url:"/order/ajaxshowOrderT",
			data:{
				stime:$("#stime").val(),
				etime:$("#etime").val(),
			},
			type:"get",
			success:function(data){
				console.log(data)
				var time = [];
				var number1 = [];
				var number2 = [];
				var number3 = [];
				for(var i = 0 ; i < data.length; i++){
					
					time.push(data[i].time);
					number1.push(data[i].totalAmount);
					number2.push(data[i].amount);
					number3.push(data[i].number);
				}
				
				
				 var myChart = echarts.init(document.getElementById('order'));
			     // 指定图表的配置项和数据
			     var option = {
			         title: {
			             text: '订单收入'
			         },
			         toolbox: {
			             // y: 'bottom',
			             feature: {
			                 magicType: {
			                	 show:true,			           
			                     type: ['bar', 'line']
			                 },
			                 restore: {show: true},
			                 dataView: {},
			                 saveAsImage: {
			                     pixelRatio: 2
			                 }
			             }
			         },
			         tooltip: {
			        	 trigger: 'axis'
			         },
			         legend: {
			             data:['总金额','现金收入','订单数'],
			             align: 'left'
			         },
			         xAxis: {
			        	 name:"日期",
			        	 type : 'category',
			             data: time,
			             
			         },
			         yAxis: [
			        	 {
			        		 type:'value',
			        		 name:"金额",
			        		 axisLabel: {
			                     formatter: '{value} RMB'
			                 }
			        	 },
			        	 {
			        		 type:'value',
			        		 name:"订单数",
			        		 min:0,
			        		 max:400,
			        		 interval:400,
			        		 axisLabel: {
			                     formatter: '{value} 人'
			                 }
			        	 }
			         ],
			         series: [		        	
			             {
			            	 name: '总金额',
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
					         animationDelay: function (idx) {
					        		            return idx * 10;
					        		        }				 
			             },
			             {
			            	 name: '现金收入',
			            	 type: 'bar',
			            	 barWidth: 15,
			            	 fontWeight: 900,
			            	 data: number2,
			            	 color:'#c23531',
			            	 smooth: true,
			            	 itemStyle : {
					        	 normal: {
					        		 label : {
					        			 show: true,
					        			 position: 'top' 
					        			 }}},
					         animationDelay: function (idx) {
					        		            return idx * 10 + 100;
					        		        }				 
			             },
			             { name: '订单数',
				             type: 'bar',
				             barWidth:10,
				             barGap:'40%',
				             fontWeight: 900,
				             data: number3,
				             yAxisIndex: 1,
				             color:'#00008B',
				             smooth: true,
				             itemStyle : {
					        	 normal: {
					        		 label : {
					        			 show: true,
					        			 position: 'top'
					        			 }}},
				             }
			        	 ],
			        	 animationEasing: 'elasticOut',
				         animationDelayUpdate: function (idx) {
				             return idx * 10;
				         }
			     };

			     // 使用刚指定的配置项和数据显示图表。
			     // Enable data zoom when user click bar.
			     var zoomSize = 6;
			     myChart.on('click', function (params) {
			         console.log(time[Math.max(params.dataIndex - zoomSize / 2, 0)]);
			         myChart.dispatchAction({
			             type: 'dataZoom',
			             startValue: time[Math.max(params.dataIndex - zoomSize / 2, 0)],
			             endValue: time[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
			         });
			     });
			     myChart.setOption(option);
			}
		})
	}
	init();
})