package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Car;

public interface CarService {
	// 查询低油量，质损，运营中
	public Map<String, Integer> getCarById(int id);

	// 查询按月的加油量
	public List<Map<String, Object>> getCarById1(int id);
	
	//添加
	public int addCar(Car car);
	//更新
	public int updateCar(Car car);
	//查询所有车
	public List<Car> getCar(int limit, int offset);
	public int getCarNum();
	
}
