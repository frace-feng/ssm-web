$(function(){	
		$.ajax({
		url:"/order/ajaxshowMonMoney",
		type:"get",
		success:function(data){
			console.log(data)
			var number1 = [];
			var times = [];
			//获取时间和数量
			for(var i = 0 ; i < data.length  ; i++){			
				number1.push(data[i].monMoney);	
			    times.push(data[i].time);			
			}
			var myChart = echarts.init(document.getElementById('monMoney'));
			var option = {
					 title: {
			             text: '月现金收入'
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
			        name:'月现金收入',
			        data:times
			    },
			    yAxis: {
			        type: 'value',
			        name:'月现金收入',
			        Max:60000
			    },
			    series: [{
			        data: number1,
			        type: 'pictorialBar',
			        barWidth:30,
			        smooth:true,
			        itemStyle : {
			        	 normal: {
			        		 label : {
			        			 show: true,
			        			 position: 'top' 
			        			 }}},
			    }
			    ]
			};
			   myChart.setOption(option);

		}
	})
})