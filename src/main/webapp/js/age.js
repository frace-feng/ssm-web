$(function(){
		$.ajax({
		url:"/user/ajaxshowAge",
		type:"get",
		success:function(data){
			console.log(data)
			var o1 = data["o1"];//map类型
			var o2 = data["o2"];
			var o3 = data["o3"];
			var o4 = data["o4"];
			var o5 = data["o5"];
			var o6 = data["o6"];

			 var myChart = echarts.init(document.getElementById('age'));
		     // 指定图表的配置项和数据
		     var option = {
		    		 backgroundColor: '#708090',

		    		    title: {
		    		        text: 'Age Pie',
		    		        left: 'center',
		    		        top: 20,
		    		        textStyle: {
		    		            color: '#ccc'
		    		        }
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
		    		            name:'年龄段的人数',
		    		            type:'pie',
		    		            radius : '55%',
		    		            center: ['50%', '50%'],
		    		            data:[
		    		                {value:o1, name:'18-23岁'},
		    		                {value:o2, name:'24-29岁'},
		    		                {value:o3, name:'30-35岁'},
		    		                {value:o4, name:'36-41岁'},
		    		                {value:o5, name:'42-47岁'},
		    		                {value:o6, name:'大于47岁'}
		    		            ].sort(function (a, b) { return a.value - b.value; }),
		    		            roseType: 'radius',
		    		            label: {
		    		                normal: {
		    		                    textStyle: {
		    		                        color: 'rgba(255, 255, 255, 0.3)'
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
		    		                normal: {
		    		                    color: '#c23531',
		    		                    shadowBlur: 200,
		    		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		    		                }
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