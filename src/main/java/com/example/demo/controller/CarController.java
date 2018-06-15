package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.Car;
import com.example.demo.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	@Resource
	private CarService carService;
	private static final Log logger = (Log) LogFactory.getLog(CarController.class);
	@ResponseBody
	@RequestMapping(value = "/ajaxshowCar", method = RequestMethod.GET)
	public Map<String, Integer> ajaxshowCar(HttpServletRequest request, Model model) {
		Map<String, Integer> car = this.carService.getCarById(1);
		return car;
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxshowCarCopy", method = RequestMethod.GET)
	public Map<String, Integer> ajaxshowCarCopy(HttpServletRequest request, Model model) {
		Map<String, Integer> car = this.carService.getCarById(1);
		return car;
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxshowCarFuel", method = RequestMethod.GET)
	public List<Map<String, Object>> ajaxshowCarFuel(HttpServletRequest request, Model model) {
		List<Map<String, Object>> car = this.carService.getCarById1(1);
		return car;
	}
	
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> insert(@RequestBody Car car)
			throws IOException, ServletException {
		int result = 0;
		if (car != null) {
			result = carService.addCar(car);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		if (result > 0) {
			logger.info("注册成功..");
			String message="添加车辆成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("注册失败");
			String message="添加车辆失败";
			map.put("message", message);
			//返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateCar(@RequestBody Car car) throws Exception {
		int result = this.carService.updateCar(car);
		Map<String,Object> map = new HashMap<String,Object>();
		if (result > 0) {
			logger.info("更新车数据成功");
			String message="更新车数据成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("更新车数据失败");
			String message="更新车数据失败";
			map.put("message", message);
			//返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/showList" , method = RequestMethod.GET)
	public Map<String, Object> showList(Model model,String page,String limit){
		logger.info("car list");
		System.out.println(page);
		System.out.println(limit);
		int offset=Integer.parseInt(limit)*(Integer.parseInt(page)-1);
		List<Car> carlist = this.carService.getCar(Integer.parseInt(limit), offset);
		int count = this.carService.getCarNum();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", carlist);
		map.put("code",0);
		map.put("msg","");
		map.put("count",count);
		return map;
	}

}
