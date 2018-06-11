$(function(){

		$.ajax({
		url:"/user/ajaxshowAdd1",
		type:"get",
		success:function(data){
			console.log(data)
			var number1 = [];
			var number2 = [];
			var number3 = [];
			var times = [];

			//获取时间和数量
			for(var i = 0 ; i < data.length   ; i++){			
			    number1.push(data[i].cli1);			
				number2.push(data[i].cli2);			
				number3.push(data[i].cli3);					
			    if(times.indexOf(data[i].time) == -1 ){
					times.push(data[i].time);					
				}				
			}
			/*for(var i = 0 ; i < (data.length/3 ) ; i++){
				times.push(data[i].time);
			}*/
			times.sort();			
			 var myChart = echarts.init(document.getElementById('client2'));
		     // 指定图表的配置项和数据
		     var option = {
		         title: {
		             text: '注册+身份通过'
		         },
		         toolbox: {
		             // y: 'bottom',
		             feature: {
		                 dataView: {},
		                 saveAsImage: {
		                     pixelRatio: 2
		                 }
		             }
		         },
		         tooltip: {
		        	 trigger: 'axis',
		             axisPointer: {
		                 type: 'cross',
		                 crossStyle: {
		                     color: '#999'
		                 }
		             }
		         },
		         legend: {
		        	 data: ['注册+身份通过']
		         },
		         xAxis: {
		        	 name:"月份",
		        	 type : 'category',
		             data: times,		             
		         },
		         yAxis: {
		        	name:"",
		        	type:'value'
		        	 },
		          series: [
		        
		             {
	            	 name: '注册+身份通过',
	            	 type: 'line',
	            	 barWidth: 20,
	            	 fontWeight: 900,
	            	 data: number2,
	            	 color:'blue',
	            	 smooth: true,
	            	 itemStyle : {
			        	 normal: {
			        		 label : {
			        			 show: true,
			        			 position: 'top' 
			        			 }}},
			        areaStyle: {}
			     				 
	                 }
		        	 ],

		     };

		     myChart.setOption(option);
		}
	})
})