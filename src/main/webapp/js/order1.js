$(function(){
	var myChart = echarts.init(document.getElementById('order1'));


var	option = {
	    title : {
	        text: '2017的订单量和取消量',
	        subtext: '情景模拟数据'
	    },
	    tooltip : {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['订单量','取消量']
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            dataView : {show: true, readOnly: false},
	            magicType : {show: true, type: ['line', 'bar']},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    calculable : true,
	    xAxis : [
	        {
	            type : 'category',
	            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'订单量',
	            type:'bar',
	            data:[29, 49, 70, 82, 156, 197, 206, 262, 326, 350, 364, 393],
	            markPoint : {
	                data : [
	                    {type : 'max', name: '最大值'},
	                    {type : 'min', name: '最小值'}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name: '平均值'}
	                ]
	            }
	        },
	        {
	            name:'取消量',
	            type:'bar',
	            data:[6, 5, 9, 26, 24, 20, 15, 12, 28, 18, 6, 13],
	            markPoint : {
	                data : [
	                    {name : '年最高', value : 393, xAxis: 12, yAxis: 393},
	                    {name : '年最低', value : 5, xAxis: 1, yAxis: 5}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name : '平均值'}
	                ]
	            }
	        }
	    ]
};
	myChart.setOption(option);
})