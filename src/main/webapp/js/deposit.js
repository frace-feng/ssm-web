$(function(){
	//ajax动态获取参数
	/*$("#tijiao").click(function(){
		data.day=$("#day").val();
		init();
	})*/
	/*var data={"stime":2018-04-01};
	var data={"etime":2018-04-03};
	$("#tijiao1").click(function(){
		data.stime=$("#stime").val();
		data.etime=$("#etime").val();
		init();
	})*/
	$("#tijiao1").on('click',init);
	
	function init(){
	$.ajax({
		url:"/deposit/ajaxshowDepositT",
		data:{
			//stime:$("#stime").val(),
			//etime:$("#etime").val(),
			//ajax通过获取input中的name的值
			stime:$("input[name='stime']").val(),
			etime:$("input[name='etime']").val(),
		},
		type:"get",
		success:function(data){
			console.log(data)
			var time = [];
			var number1 = [];
			var yMax = 50;
			var dataShadow = [];
			//阴影设置为高为500的块
			for (var i = 0; i < data.length; i++) {
			    dataShadow.push(yMax);
			}
			
			for(var i = 0 ; i < data.length; i++){
				
				time.push(data[i].time);
				number1.push(data[i].number);
			}
			
			
			 var myChart = echarts.init(document.getElementById('deposit'));
		     // 指定图表的配置项和数据
		     var option = {
		         title: {
		             text: '申请押金'
		         },
		         toolbox: {
		             // y: 'bottom',
		             feature: {
		                 magicType: {
		                	 		           
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
		         },
		         legend: {
		             data:['申请押金人数']
		         },
		         xAxis: {
		        	 name:"日期",
		        	 type : 'category',
		             data: time
		             
		         },
		         yAxis: {
		        	 type:'value',
		        	name:"申请押金人数",
		        	 axisLine: {
		                 show: false
		             },
		             axisTick: {
		                 show: false
		             },
		             axisLabel: {
		                 textStyle: {
		                     color: '#999'
		                 }
		             }
		         },
		         dataZoom: [
		             {
		                 type: 'inside'
		             }
		         ],
		         series: [		        	
		        	 { // For shadow
		                 type: 'pictorialBar',
		                 barWidth:20,
		                 itemStyle: {
		                     normal: {color: 'rgba(0,0,0,0.05)'}
		                 },
		                 barGap:'-100%',
		                 barCategoryGap:'40%',
		                 data: dataShadow,
		                 animation: false
		             },
		             {
		            	 name: '申请押金人数',
		            	 type: 'line',
		            	 barWidth:20,
		            	 stack: '总量',
		            	 data: number1,
		            	 color:'green',
		            	 smooth: true,
		            	 itemStyle : {
				        	 normal: {
				        		 label : {
				        			 show: true,
				        			 position: 'top' 
				        			 },
				        		 color: new echarts.graphic.LinearGradient(
			        	                        0, 0, 0, 1,
			        	                        [
			        	                            {offset: 0, color: '#83bff6'},
			        	                            {offset: 0.5, color: '#188df0'},
			        	                            {offset: 1, color: '#188df0'}
			        	                        ]
			        	                    )			
				        	 },
				        	  emphasis: {
		                             color: new echarts.graphic.LinearGradient(
		                                 0, 0, 0, 1,
		                                 [
		                                     {offset: 0, color: '#2378f7'},
		                                     {offset: 0.7, color: '#2378f7'},
		                                     {offset: 1, color: '#83bff6'}
		                                 ]
		                             )
		                         }
		             
		            	 },
		             },
		        	 ]
		     };
		     var zoomSize = 6;
		     myChart.on('click', function (params) {
		         console.log(times[Math.max(params.dataIndex - zoomSize / 2, 0)]);
		         myChart.dispatchAction({
		             type: 'dataZoom',
		             startValue: times[Math.max(params.dataIndex - zoomSize / 2, 0)],
		             endValue: times[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
		         });
		     });
		     // 使用刚指定的配置项和数据显示图表。
		     
		     myChart.setOption(option);
		}
	})
	}
	init();
})