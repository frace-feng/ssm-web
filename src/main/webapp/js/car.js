$(function(){
		$.ajax({
		url:"/car/ajaxshowCar",
		type:"get",
		success:function(data){
			console.log(data)
			var o1 = data["o1"] ;
			var o2 = data["o2"];
			var o3 = data["o3"];
			 var myChart = echarts.init(document.getElementById('car'));
		     // 指定图表的配置项和数据
		     var option = {
		    		 title : {
		    		        text: '质损的车和运营中车',
		    		        subtext: '纯属虚构',
		    		        x:'center'
		    		    },
		    		    tooltip : {
		    		        trigger: 'item',
		    		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    		    },
		    		    legend: {
		    		        orient: 'vertical',
		    		        left: 'left',
		    		        data: ['质损','运营中','低油量']
		    		    },
		    		    series : [
		    		        {
		    		            name: '车信息',
		    		            type: 'pie',
		    		            radius : '55%',
		    		            center: ['50%', '60%'],
		    		            data:[
		    		            	{value:o1, name:'质损'},
		    		                {value:o2, name:'运营中'},
		    		                {value:o3, name:'低油量'},
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