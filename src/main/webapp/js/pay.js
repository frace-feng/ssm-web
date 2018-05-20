$(function(){
	//ajax动态获取参数
	/*var data={"day":7};
	$("#tijiao").click(function(){
		data.day=$("#day").val();
		init();
	})*/
	
/*	$("#tijiao1").click(function(){
	data.stime=$("#stime").val();
	data.etime=$("#etime").val();
	init();
})*/
	$("#tijiao1").on('click',init);
	
	function init(){
	$.ajax({
		url:"/pay/ajaxshowPayT",
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
			//var number2 = [];
			for(var i = 0 ; i < data.length; i++){
				
				time.push(data[i].time);
				number1.push(data[i].money);
				number2.push(data[i].number);
				//number2.push(data[i].number);
			}
			
			
			 var myChart = echarts.init(document.getElementById('pay'));
		     // 指定图表的配置项和数据
		     var option = {
		         title: {
		             text: '充值'
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
		             data:['充值金额']
		         },
		         xAxis: {
		        	 name:"日期",
		        	 type : 'category',
		             data: time
		             
		         },
		         yAxis: [
		        	 {
		        		 type:'value',
		        		 name:"充值金额",
		        		 axisLabel: {
		                     formatter: '{value} RMB'
		                 }
		        	 },
		        	 {
		        		 type:'value',
		        		 name:"充值人数",
		        		 min:0,
		        		 max:20,
		        		 interval:10,
		        		 axisLabel: {
		                     formatter: '{value} 人'
		                 }
		        	 }
		         ],
		         series: [		        	
		             {
		            	 name: '充值金额',
		            	 type: 'pictorialBar',	           
		            	 barWidth:20,
		            	 fontWeight:1000,
		            	 data: number1,
		            	 color:'#FFA500',
		            	 smooth: true,
		            	 itemStyle : {
				        	 normal: {
				        		 label : {
				        			 show: true,
				        			 fontsize:'2rem',
				        			 position: 'top' 
				        			 }}},
		             },
		             {
		            	 name: '充值人数',
		            	 type: 'line',
		            	 barWidth:20,
		            	 yAxisIndex: 1,
		            	 data: number2,
		            	 color:'#2f4554',
		            	 smooth: true,
		            	 itemStyle : {
				        	 normal: {
				        		 label : {
				        			 show: true,
				        			 position: 'top' 
				        			 }}},
		             },
		        	 ]
		     };

		     // 使用刚指定的配置项和数据显示图表。
		     
		     myChart.setOption(option);
		}
	})
	}
	init();
})