$(function(){
	
	$("#tijiao1").on('click',init);
	
	function init(){
		$.ajax({
		url:"/audit/ajaxShowAudit",
		data:{
			stime:$("input[name='stime']").val(),
			etime:$("input[name='etime']").val(),
		},
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
		             text: '流失量',
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
		        	 data: [ '流失量']
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
	             	 name: '流失量',
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
	}
	init();
})