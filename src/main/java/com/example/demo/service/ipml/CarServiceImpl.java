package com.example.demo.service.ipml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.dao.CarDao;
import com.example.demo.entity.Car;
import com.example.demo.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Resource
	private CarDao carDao;

	@Override
	public Map<String, Integer> getCarById(int id) {
		// TODO Auto-generated method stub
		Integer o1 = carDao.selectByPrimaryKeyT24();
		Integer o2 = carDao.selectByPrimaryKeyT25();
		Integer o3 = carDao.selectByPrimaryKeyT26();
		Map<String, Integer> result = new HashMap<>();
		result.put("o1", o1);
		result.put("o2", o2);
		result.put("o3", o3);
		return result;
	}

	@Override
	public List<Map<String, Object>> getCarById1(int id) {
		// TODO Auto-generated method stub
		return carDao.selectByPrimaryKeyT27();
	}

	@Override
	public int addCar(Car car) {
		// TODO Auto-generated method stub
		return carDao.insertCar(car);
	}

	@Override
	public int updateCar(Car car) {
		// TODO Auto-generated method stub
		return carDao.updateCar(car);
	}

}
