$(function(){
		$.ajax({
		url:"/user/ajaxshowSex",
		type:"get",
		success:function(data){
			console.log(data)
			var o1 = data["o1"] ;
			var o2 = data["o2"];

			 var myChart = echarts.init(document.getElementById('sex'));
		     // 指定图表的配置项和数据
		     var option = {
		    		    backgroundColor: '#708090',

		    		    title: {
		    		        text: '性别的占比',
		    		        left: 'center',
		    		        top: 20,
		    		        textStyle: {
		    		            color: '#ccc'
		    		        }
		    		    },
		    		    
		    		    legend: {
		    		    orient: 'vertical',
		    	        x: 'left',
		    	        data:['女','男']
		    		    },
		    		    tooltip : {
		    		        trigger: 'item',
		    		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    		    },

		    		    visualMap: {
		    		        show: false,
		    		        min: 80,
		    		        max: 600,
		    		        inRange: {
		    		            colorLightness: [0, 1]
		    		        }
		    		    },
		    		    series : [
		    		    	{
		    		            name:'访问来源',
		    		            type:'pie',
		    		            radius: ['50%', '70%'],//内圈半径，外圈半径
		    		            avoidLabelOverlap: false,
		    		            label: {
		    		                normal: {
		    		                    show: false,
		    		                    position: 'center',
		    		                    textStyle: {
		    		                        color: 'rgba(255,  0.3)'
		    		                    }
		    		                },
		    		                emphasis: {
		    		                    show: true,
		    		                    textStyle: {
		    		                        fontSize: '30',
		    		                        fontWeight: 'bold'
		    		                    }
		    		                }
		    		            },
		    		            labelLine: {
		    		                normal: {
		    		                    show: false
		    		                }
		    		            },
		    		            data:[
		    		                {value:o1, name:'女'},
		    		                {value:o2, name:'男'}
		    		            ],
		    		            label: {
		    		                normal: {
		    		                    textStyle: {
		    		                        color: 'rgba(255,  0.3)'
		    		                    }
		    		                }
		    		            },
		    		            labelLine: {
		    		                normal: {
		    		                    lineStyle: {
		    		                        color: 'rgba(255, 255, 255, 0.3)'
		    		                    },
		    		                    smooth: 0.2,
		    		                    length: 10,
		    		                    length2: 20
		    		                }
		    		            },
		    		            itemStyle: {
		    		            	color: 'red',
		    	                    shadowBlur: 200,
		    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		    		            },

		    		            animationType: 'scale',
		    		            animationEasing: 'elasticOut',
		    		            animationDelay: function (idx) {
		    		                return Math.random() * 200;
		    		            }
		    		            
		    		        }
		    		    ]
		    		};

		     myChart.setOption(option);
		}
	})
})