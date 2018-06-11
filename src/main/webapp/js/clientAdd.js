$(function(){
	//ajax动态获取参数
	/*var data={"day":7};
	$("#tijiao").click(function(){
		data.day=$("#day").val();
		init();
	})*/
	//查询时间范围
	$("#tijiao1").on('click',init);
	
	function init(){
		$.ajax({
		url:"/user/ajaxshowUserT",
		data:{
			stime:$("#stime").val(),
			etime:$("#etime").val(),
		},
		type:"get",
		success:function(data){
			console.log(data)
			var numbers = [];
			var times = [];
			var yMax = 800;
			var dataShadow = [];
			//阴影设置为高为500的块
			for (var i = 0; i < data.length ; i++) {
			    dataShadow.push(yMax);
			}
			//获取时间和数量
			for(var i = 0 ; i < data.length   ; i++){
				
				numbers.push(data[i].number);
				times.push(data[i].time);
			}
			
			
			 var myChart = echarts.init(document.getElementById('clientId'));
		     // 指定图表的配置项和数据
		     var option = {
		         title: {
		             text: '日注册量'
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
		        	 data: ['注册数']
		         },
		         xAxis: {
		        	 name:"日期",
		        	 type : 'category',
		             data: times,
		             
		         },
		         yAxis: {
		        	name:"注册人数",
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
		                 type: 'bar',
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
		             name: '注册人数',
		             type: 'pictorialBar',
		             barWidth:20,
		             smooth:true,
		             data: numbers,
		             itemStyle : {
			        	 normal: {
			        		 label : {
			        			 show: true,
			        			 position: 'top' 
			        			     },
			             color: new echarts.graphic.LinearGradient(
			        	                        0, 0, 0, 1,
			        	                        [
			        	                            {offset: 0, color: '#55ff7f'},
			        	                            {offset: 0.5, color: '#50f075'},
			        	                            {offset: 1, color: '#2d8842'}
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
		             }
		        	 
		                       
		 
		         }],


		     };

		     // 使用刚指定的配置项和数据显示图表。
		     
		    
		  // Enable data zoom when user click bar.
		     var zoomSize = 6;
		     myChart.on('click', function (params) {
		         console.log(times[Math.max(params.dataIndex - zoomSize / 2, 0)]);
		         myChart.dispatchAction({
		             type: 'dataZoom',
		             startValue: times[Math.max(params.dataIndex - zoomSize / 2, 0)],
		             endValue: times[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
		         });
		     });
		     myChart.setOption(option);
		}
	})
	}
	init();
})