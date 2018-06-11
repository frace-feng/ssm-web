package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Order;

public interface OrderService {
	// 查询时间段订单数
	public Map<String, Integer> getOrderById(int id);


	// 查询时间范围内的订单数
	public List<Map<String, Object>> getOrderByIdT(int id, @Param("stime") String stime, @Param("etime") String etime);

	// 查询月现金收入
	public List<Map<String, Object>> getOrderById1(int id);

	// 查询月总收入
	public List<Map<String, Object>> getOrderById2(int id);


	// 删除订单
	public int deleteOrder(Integer orderCode);

	//添加订单
	public int addOrder(Order order);
	//查询所有
	public List<Order> getOrder(int limit, int offset);
}


// 查询周均订单数
//public Map<String, Integer> getOrderById2(int id);

// 查询平均订单消费
//public Map<String, Integer> getOrderById3(int id);


// 查询月订单
//public List<Map<String, Object>> getOrderById6(int id);