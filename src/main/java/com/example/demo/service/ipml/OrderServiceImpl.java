package com.example.demo.service.ipml;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao;

	@Override
	public Map<String, Integer> getOrderById(int id) {
		Integer o1 = orderDao.selectByPrimaryKeyT12();
		// 调试程序，数据展示过于缓慢，时间达到7秒，
		/* System.out.println("--aaaa---"+new Date()); */
		Integer o2 = orderDao.selectByPrimaryKeyT13();
		Integer o3 = orderDao.selectByPrimaryKeyT14();
		Integer o4 = orderDao.selectByPrimaryKeyT15();
		Integer o5 = orderDao.selectByPrimaryKeyT16();
		Integer o6 = orderDao.selectByPrimaryKeyT17();
		Map<String, Integer> result = new HashMap<>();
		result.put("o1", o1);
		result.put("o2", o2);
		result.put("o3", o3);
		result.put("o4", o4);
		result.put("o5", o5);
		result.put("o6", o6);
		return result;
	}

	@Override
	public List<Map<String, Object>> getOrderByIdT(int id, @Param("stime") String stime, @Param("etime") String etime) {
		// TODO Auto-generated method stub
		return orderDao.selectByPrimaryKeyT(stime, etime);
	}

	@Override
	public List<Map<String, Object>> getOrderById1(int id) {
		// TODO Auto-generated method stub
		return orderDao.selectByPrimaryKeyT18();
	}

	@Override
	public List<Map<String, Object>> getOrderById2(int id) {
		// TODO Auto-generated method stub
		return orderDao.selectByPrimaryKeyT19();
	}

	@Override
	public int deleteOrder(Integer orderCode) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrder(orderCode);
	}

	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDao.insertOrder(order);
	}

	@Override
	public List<Order> getOrder(int limit, int offset) {
		// TODO Auto-generated method stub
		return orderDao.selectAll(limit, offset);
	}

	@Override
	public int getOrderNum() {
		// TODO Auto-generated method stub
		return orderDao.orderNum();
	}

	@Override
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(order);
	}
}


/*	@Override
public Map<String, Integer> getOrderById2(int id) {
	Integer o1 = orderDao.selectByPrimaryKeyT18();
	Integer o2 = orderDao.selectByPrimaryKeyT19();
	Integer o3 = orderDao.selectByPrimaryKeyT20();
	Map<String, Integer> result = new HashMap<>();
	result.put("o1", o1);
	result.put("o2", o2);
	result.put("o3", o3);
	return result;
}

@Override
public Map<String, Integer> getOrderById3(int id) {
	Integer o1 = orderDao.selectByPrimaryKeyT21();
	Integer o2 = orderDao.selectByPrimaryKeyT22();
	Integer o3 = orderDao.selectByPrimaryKeyT23();
	Map<String, Integer> result = new HashMap<>();
	result.put("o1", o1);
	result.put("o2", o2);
	result.put("o3", o3);
	return result;
}*/

/*@Override
public List<Map<String, Object>> getOrderById6(int id) {
	// TODO Auto-generated method stub
	return orderDao.selectByPrimaryKeyT20();
}*/