package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Car;

public interface CarDao {
	// 查询质损，运营中的车
	Integer selectByPrimaryKeyT24();

	Integer selectByPrimaryKeyT25();

	Integer selectByPrimaryKeyT26();

	// 查询按月的加油量
	List<Map<String, Object>> selectByPrimaryKeyT27();
	
	//添加车
	public int insertCar(Car car);
	//更新车
	public int updateCar(Car car);
	//查询所有车
	public List<Car> selectAll(@Param("limit") int limit, @Param("offset") int offset);
}
