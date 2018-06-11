$(function(){
	
		$.ajax({
		url:"/order/ajaxshowOrder",
		type:"get",
		success:function(data){
			console.log(data)
			var o1 =new Array();
			o1.push(data.o1);
			o1.push(data.o2);
			o1.push(data.o3);
			o1.push(data.o4);
			o1.push(data.o5);
			o1.push(data.o6);
			//获取时间和数量
			var myChart = echarts.init(document.getElementById('orderTimeF'));
			var option = {
					 title: {
			             text: '时间段总订单数'
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
			    xAxis: {
			        type: 'category',
			        name:'时间段',
			        data: ['00:00-04:00','04:00-08:00','08:00-12:00','12:00-16:00','16:00-20:00','20:00-24:00']
			    },
			    yAxis: {
			        type: 'value',
			        name:'订单数'
			    },
			    series: [{
			        data: o1,
			        barWidth:30,
			        type: 'bar',
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