$(function(){

		$.ajax({
		url:"/user/ajaxshowAdd2",
		type:"get",
		success:function(data){
			console.log(data)
			var number1 = [];
			var number2 = [];
			var number3 = [];
			var times = [];
			var labelRight = {
				    normal: {
				        position: 'right'
				    }
				};

			//获取时间和数量
			for(var i = 0 ; i < data.length   ; i++){			
			    number1.push(data[i].cli1);			
				number2.push(data[i].cli2);			
				number3.push(data[i].cli3);					
			    if(times.indexOf(data[i].time) == -1 ){
					times.push(data[i].time);					
				}				
			}
			/*for(var i = 0 ; i < (data.length/3 ) ; i++){
				times.push(data[i].time);
			}*/
			times.sort();			
			 var myChart = echarts.init(document.getElementById('client3'));
		     // 指定图表的配置项和数据
		     var option = {
		    		 /*backgroundColor: '#2c343c',*/
		    		 title: {
		    		        text: '注册后交押金量',
		    		    },
		    		    tooltip : {
		    		        trigger: 'axis',
		    		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		    		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		    		        }
		    		    },
		    		    grid: {
		    		        top: 80,
		    		        bottom: 30
		    		    },
		    		    xAxis: {
		    		        type : 'value',
		    		        position: 'top',
		    		        splitLine: {lineStyle:{type:'dashed'}},
		    		    },
		    		    yAxis: {
		    		        type : 'category',
		    		        axisLine: {show: false},
		    		        axisLabel: {show: false},
		    		        axisTick: {show: false},
		    		        splitLine: {show: false},
		    		        data : times
		    		    },
		    		    series : [
		    		        {
		    		            name:'交押金量',
		    		            type:'bar',
		    		            stack: '总量',
		    		            label: {
		    		                normal: {
		    		                    show: true,
		    		                    formatter: '{b}'
		    		                }
		    		            },
		    		            data:number3
		    		        }
		    		    ]

		     };

		     myChart.setOption(option);
		}
	})
})