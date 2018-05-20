$(function(){
	var myChart = echarts.init(document.getElementById('money'));

var	option = {
		title: {
			text:'2017年的下半年利润'
		},
	    xAxis: {
	        type: 'category',
	        data: ['7月', '8月', '9月', '10月', '11月', '12月']
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: [120, 200, 150, 70, 110, 130],
	        type: 'line',
	        symbol: 'triangle',
	        symbolSize: 20,
	        lineStyle: {
	            normal: {
	                color: 'green',
	                width: 4,
	                type: 'dashed'
	            }
	        },
	        itemStyle: {
	            normal: {
	                borderWidth: 3,
	                borderColor: 'yellow',
	                color: 'blue'
	            }
	        }
	    }]

};
	myChart.setOption(option);
})