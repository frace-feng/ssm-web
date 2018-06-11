$(function(){
		$.ajax({
		url:"/user/ajaxshowAdd",
		type:"get",
		success:function(data){
			console.log(data)
			var number1 = [];//list泛型类型
			var times = [];
			//获取时间和数量
			for(var i = 0 ; i < data.length ; i++){			
				number1.push(data[i].cli1);	
			    times.push(data[i].time);			
			}			
			 var myChart = echarts.init(document.getElementById('client'));
		     // 指定图表的配置项和数据
		     var option = {
		         title: {
		             text: '注册用户数--按月'
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
		             name: '注册用户数',
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