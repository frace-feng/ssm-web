package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response, Car car)
			throws IOException, ServletException {
		int result = 0;
		if (car != null) {
			result = carService.addCar(car);
		}
		if (result > 0) {
			logger.info("添加成功..");
			response.sendRedirect("/pages/managerCar.html");
		} else {
			logger.error("添加失败");
			request.getRequestDispatcher("/pages/500.html").forward(request, response);
		}
	}
	
	@RequestMapping("/update")
	public void updateUser(HttpServletRequest request, HttpServletResponse response, Car car) throws Exception {
		int result = carService.updateCar(car);
		if (result > 0) {
			logger.info("更新车数据成功");
			response.sendRedirect("/pages/carUpdate.html");

		} else {
			logger.error("更新车数据失败");
			request.getRequestDispatcher("/pages/500.html").forward(request, response);

		}
	}

}
