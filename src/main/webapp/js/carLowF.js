$(function(){
		$.ajax({
		url:"/car/ajaxshowCarCopy",
		type:"get",
		success:function(data){
			console.log(data)
			var o1 = data["o1"] ;
			var o2 = data["o2"];
			var o3 = data["o3"];
			 var myChart = echarts.init(document.getElementById('carLowF'));
		     // 指定图表的配置项和数据
		     var option = {
		    		 title : {
		    		        text: '低油量车占比',
		    		        subtext: '纯属虚构',
		    		        x:'center'
		    		    },
		    		    tooltip : {
		    		        trigger: 'item',
		    		        formatter: "{a} <br/>{b} : {c}%"
		    		    },
		    		    legend: {
		    		        orient: 'vertical',
		    		        left: 'left',
		    		        data: ['低油量<10%','总车数']
		    		    },
		    		    series : [
		    		        {
		    		            name: '车信息',
		    		            type: 'gauge',
		    		            radius : '55%',
		    		            center: ['50%', '60%'],
		    		            data:[
		    		            	{value:o3, name:'低油量<10%'}
		    		            ],
		    		            itemStyle: {
		    		                emphasis: {
		    		                    shadowBlur: 10,
		    		                    shadowOffsetX: 0,
		    		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		    		                }
		    		            }
		    		        }
		    		    ]
		    		};

		     myChart.setOption(option);
		}
	})
})