$(function(){

		$.ajax({
		url:"/order/ajaxshowDayOrder",
		type:"get",
		success:function(data){
			console.log(data)
			var number1 = [];
			var times = [];
			//获取时间和数量
			for(var i = 0 ; i < data.length  ; i++){			
			    number1.push(data[i].dayOrder);	
			    times.push(data[i].time);		
			}
				
			 var myChart = echarts.init(document.getElementById('order2'));
		     // 指定图表的配置项和数据
		     var option = {
		         title: {
		             text: '日订单'
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
		        	 data: ['']
		         },
		         xAxis: {
		        	 name:"月日期份",
		        	 type : 'category',
		             data: times,		             
		         },
		         yAxis: {
		        	name:"",
		        	type:'value'
		        	 },
		          series: [
		        	 {
		             name: '日订单',
		             type: 'line',
		             smooth:true,
		             data: number1,
		             color:"blue",
		             smooth: true,
	            	 itemStyle : {
			        	 normal: {
			        		 label : {
			        			 show: true,
			        			 position: 'top' 
			        			 }}},
		               },
		        	 ],

		     };

		     myChart.setOption(option);
		}
	})
})