$(function(){
	
		$.ajax({
		url:"/order/ajaxshowMonTotal",
		type:"get",
		success:function(data){
			console.log(data)
			var number1 = [];
			var times = [];
			//获取时间和数量
			for(var i = 0 ; i < data.length  ; i++){			
				number1.push(data[i].monTotal);	
			    times.push(data[i].time);			
			}
			//获取时间和数量
			var myChart = echarts.init(document.getElementById('monTotal'));
			var option = {
					 title: {
			             text: '月总收入'
			         },
			toolbox:{
				 feature: {
	                 dataView: {},
	                 saveAsImage: {
	                     pixelRatio: 2
	                 }
	             }
			},         
			tooltip: {
			        	 trigger: 'item',
			             axisPointer: {
			                 type: 'cross',
			                 crossStyle: {
			                     color: '#999'
			                 }
			             }
			         },
			    xAxis: {
			        type: 'category',
			        name:'月份',
			        data: times
			    },
			    yAxis: {
			        type: 'value',
			        name:'月总收入'
			    },
			    series: [{
			        data: number1,
			        type: 'line',
			        barWidth:30,
			        color:"green",
			        smooth:true,
			        step: 'middle',
			        itemStyle : {
			        	 normal: {
			        		 label : {
			        			 show: true,
			        			 position: 'top' 
			        			 }}},
			       //areaStyle: {}
			    }
			    ]
			};
			   myChart.setOption(option);

		}
	})
})