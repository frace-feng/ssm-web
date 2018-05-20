$(function(){

		$.ajax({
		url:"/audit/ajaxShowAudit",
		type:"get",
		success:function(data){
			console.log(data)
			var number4 = [];
			var times = [];

			//获取时间和数量
			for(var i = 0 ; i < data.length   ; i++){				
				number4.push(data[i].cli4);
				times.push(data[i].time);				
			}
			 var myChart = echarts.init(document.getElementById('audit'));
		     // 指定图表的配置项和数据
		     var option = {
		    		 /*backgroundColor: '#2c343c',*/
		         title: {
		             text: '财务退押金',
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
		        	 data: [ '财务退押金']
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
	             	 name: '财务退押金',
	            	 type: 'bar',
	            	 barWidth: 20,
	            	 fontWeight: 900,
	            	 data: number4,
	            	 color:'orange',
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

})