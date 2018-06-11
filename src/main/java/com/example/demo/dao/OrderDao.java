package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Order;

@Mapper
public interface OrderDao {

	// listmap格式 ，查询天数
	List<Map<String, Object>> selectByPrimaryKey(Integer day);

	// 查询时间范围
	List<Map<String, Object>> selectByPrimaryKeyT(@Param("stime") String stime, @Param("etime") String etime);

	// 查询有订单数
	Map<String, Object> selectByPrimaryKeyT7(@Param("stime") String stime, @Param("etime") String etime,
			@Param("mobile") String mobile);

	Integer selectByPrimaryKeyT12();

	Integer selectByPrimaryKeyT13();

	Integer selectByPrimaryKeyT14();

	Integer selectByPrimaryKeyT15();

	Integer selectByPrimaryKeyT16();

	Integer selectByPrimaryKeyT17();

	List<Map<String, Object>> selectByPrimaryKeyT18();

	List<Map<String, Object>> selectByPrimaryKeyT19();
	
	// 删除
	public int deleteOrder(Integer orderCode);
	//插入
	public int insertOrder(Order order);
	//查询所有
	List<Order> selectAll(@Param("limit") int limit, @Param("offset") int offset);
	
	//List<Map<String, Object>> selectByPrimaryKeyT20();

	//List<Map<String, Object>> selectByPrimaryKeyT28();

	//List<Map<String, Object>> selectByPrimaryKeyT29();

	//List<Map<String, Object>> selectByPrimaryKeyT30();

}
