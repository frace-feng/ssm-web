$(function(){
	var myChart = echarts.init(document.getElementById('client6'));

	var data = [
	    [[28604,77,17096869,'河南省',2017],[31163,77.4,27662440,'辽宁省',2017],[1516,68,1154605773,'北京',2017],[13670,74.7,10582082,'上海',2017],[28599,75,4986705,'吉林省',2017],[29476,77.1,56943299,'黑龙江',2017],[31476,75.4,78958237,'广州',2017],[28666,78.1,254830,'重庆',2017],[1777,57.7,870601776,'湖北省',2017],[29550,79.1,122249285,'福建省',2017],[2076,67.9,20194354,'天津',2017],[12087,72,42972254,'河北省',2017],[24021,75.4,3397534,'山东省',2017],[43296,76.8,4240375,'山西省',2017],[10088,70.8,38195258,'陕西省',2017],[19349,69.6,147568552,'西北省',2017],[10670,67.3,53994605,'湖北省',2017],[26424,75.7,57110117,'宁夏省',2017],[37062,75.4,252847810,'云南省',2017]],
	    [[44056,81.8,23968973,'河南省',2019],[43294,81.7,35939927,'辽宁省',2019],[13334,76.9,1376048943,'北京',2019],[21291,78.5,11389562,'上海',2019],[38923,80.8,5503457,'吉林省',2019],[37599,81.9,64395345,'黑龙江',2019],[44053,81.1,80688545,'广州',2019],[42182,82.8,329425,'重庆',2019],[5903,66.8,1311050527,'湖北省',2019],[36162,83.5,126573481,'福建省',2019],[1390,71.4,25155317,'天津',2019],[34644,80.7,50293439,'河北省',2019],[34186,80.6,4528526,'山东省',2019],[64304,81.6,5210967,'山西省',2019],[24787,77.3,38611794,'陕西省',2019],[23038,73.13,143456918,'西北省',2019],[19360,76.5,78665830,'湖北省',2019],[38225,81.4,64715810,'宁夏省',2019],[53354,79.1,321773631,'云南省',2019]]
	];

var	option = {
	    backgroundColor: new echarts.graphic.RadialGradient(0.3, 0.3, 0.8, [{
	        offset: 0,
	        color: '#f7f8fa'
	    }, {
	        offset: 1,
	        color: '#cdd0d5'
	    }]),
	    title: {
	        text: '车辆地址信息'
	    },
	    legend: {
	        right: 10,
	        data: ['2017', '2019']
	    },
	    xAxis: {
	        splitLine: {
	            lineStyle: {
	                type: 'dashed'
	            }
	        },
	        show:false,
	    },
	    yAxis: {
	        splitLine: {
	            lineStyle: {
	                type: 'dashed'
	            }
	        },
	        axisLine:{
	            show:false,        

	        }, 
	        show:false,
	        scale: true
	    },
	    series: [{
	        name: '2017',
	        data: data[0],
	        type: 'scatter',
	        symbolSize: function (data) {
	            return Math.sqrt(data[2]) / 5e2;
	        },
	        label: {
	            emphasis: {
	                show: true,
	                formatter: function (param) {
	                    return param.data[3];
	                },
	                position: 'top'
	            }
	        },
	        itemStyle: {
	            normal: {
	                shadowBlur: 10,
	                shadowColor: 'rgba(120, 36, 50, 0.5)',
	                shadowOffsetY: 5,
	                color: new echarts.graphic.RadialGradient(0.4, 0.3, 1, [{
	                    offset: 0,
	                    color: 'rgb(251, 118, 123)'
	                }, {
	                    offset: 1,
	                    color: 'rgb(204, 46, 72)'
	                }])
	            }
	        }
	    }, {
	        name: '2019',
	        data: data[1],
	        type: 'scatter',
	        symbolSize: function (data) {
	            return Math.sqrt(data[2]) / 5e2;
	        },
	        label: {
	            emphasis: {
	                show: true,
	                formatter: function (param) {
	                    return param.data[3];
	                },
	                position: 'top'
	            }
	        },
	        itemStyle: {
	            normal: {
	                shadowBlur: 10,
	                shadowColor: 'rgba(25, 100, 150, 0.5)',
	                shadowOffsetY: 5,
	                color: new echarts.graphic.RadialGradient(0.4, 0.3, 1, [{
	                    offset: 0,
	                    color: 'rgb(129, 227, 238)'
	                }, {
	                    offset: 1,
	                    color: 'rgb(25, 183, 207)'
	                }])
	            }
	        }
	    }]
	};
	myChart.setOption(option);
})