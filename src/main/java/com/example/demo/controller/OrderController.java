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
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@Controller
// @RestController
@RequestMapping("/order")

public class OrderController {

	private static final Log logger = (Log) LogFactory.getLog(OrderController.class);

	@Resource
	private OrderService orderService;

	/*
	 * @RequestMapping(value = "/showOrder", method = RequestMethod.GET) public
	 * String toIndex(HttpServletRequest request, Model model){ // int userId =
	 * Integer.parseInt(request.getParameter("id")); List<Map<String, Object>> order
	 * = this.orderService.getOrderById(2); return "index"; }
	 */

	@ResponseBody
	@RequestMapping(value = "/ajaxshowOrder", method = RequestMethod.GET)
	public Map<String, Integer> ajax(HttpServletRequest request, Model model) {
		Map<String, Integer> order = this.orderService.getOrderById(1);
		return order;
	}


	// 时间筛选订单
	@ResponseBody
	@RequestMapping(value = "/ajaxshowOrderT", method = RequestMethod.GET)
	public List<Map<String, Object>> ajaxT(HttpServletRequest request, Model model) {

		// int userId = Integer.parseInt(request.getParameter("id"));
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		System.out.println(stime);
		System.out.println(etime);
		List<Map<String, Object>> order = this.orderService.getOrderByIdT(1, stime, etime);
		return order;
	}

	// 日订单
	@ResponseBody
	@RequestMapping(value = "/ajaxshowMonMoney", method = RequestMethod.GET)
	public List<Map<String, Object>> ajaxshowMonMoney(HttpServletRequest request, Model model) {
		List<Map<String, Object>> order = this.orderService.getOrderById1(1);
		return order;
	}

	// 周订单
	@ResponseBody
	@RequestMapping(value = "/ajaxshowMonTotal", method = RequestMethod.GET)
	public List<Map<String, Object>> ajaxshowMonTotal(HttpServletRequest request, Model model) {
		List<Map<String, Object>> order = this.orderService.getOrderById2(1);
		return order;
	}


	// 删除一条订单记录
	@RequestMapping("/delete")
	public void deleteOrderById(HttpServletRequest request, HttpServletResponse response, String orderCode)
			throws Exception {
		int result = orderService.deleteOrder(Integer.parseInt(orderCode));
		if (result > 0) {
			logger.info("删除订单数据成功..");
			response.sendRedirect("/pages/managerOrder.html");

		} else {
			logger.error("删除订单数据失败..");
			request.getRequestDispatcher("/pages/500.html").forward(request, response);

		}
	}
	
	//添加订单
	@RequestMapping("/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response, Order order)
			throws IOException, ServletException {
		int result = 0;
		if (order != null) {
			result = orderService.addOrder(order);
		}
		if (result > 0) {
			logger.info("添加成功..");
			response.sendRedirect("/pages/orderAdd.html");
		} else {
			logger.error("添加失败");
			request.getRequestDispatcher("/pages/500.html").forward(request, response);
		}
	}

}


/*// 平均订单
@ResponseBody
@RequestMapping(value = "/ajaxshowAveOrder", method = RequestMethod.GET)
public Map<String, Integer> ajaxshowAveOrder(HttpServletRequest request, Model model) {
	 System.out.println("---11--1"+new Date()); 
	Map<String, Integer> order = this.orderService.getOrderById2(1);
	 System.out.println("----33-22"+new Date()); 
	return order;
}

// 平均订单消费
@ResponseBody
@RequestMapping(value = "/ajaxshowOrderMoney", method = RequestMethod.GET)
public Map<String, Integer> ajaxshowOrderMoney(HttpServletRequest request, Model model) {
	Map<String, Integer> order = this.orderService.getOrderById3(1);
	return order;
}*/

/*
// 月订单
@ResponseBody
@RequestMapping(value = "/ajaxshowMonthOrder", method = RequestMethod.GET)
public List<Map<String, Object>> ajaxshowMonthOrder(HttpServletRequest request, Model model) {
	List<Map<String, Object>> order = this.orderService.getOrderById6(1);
	return order;
}*/