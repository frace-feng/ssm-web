package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Deposit;
import com.example.demo.service.DepositService;

@Controller
// @RestController
@RequestMapping("/deposit")
public class DepositController {
	@Resource
	private DepositService depositService;
	
	private static final Log logger = (Log) LogFactory.getLog(DepositController.class);

	/*
	 * 显示天数的查询
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/ajaxshowDeposit", method = RequestMethod.GET)
	 * public List<Map<String, Object>> ajax(HttpServletRequest request, Model
	 * model){ String parameter = request.getParameter("day");
	 * System.out.println(parameter); Integer day =
	 * Integer.valueOf(request.getParameter("day").toString()); List<Map<String,
	 * Object>> deposit = this.depositService.getDepositById(1,day); return deposit;
	 * }
	 */
	@ResponseBody
	@RequestMapping(value = "/ajaxshowDepositT", method = RequestMethod.GET)

	public List<Map<String, Object>> ajax(HttpServletRequest request, Model model) {

		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		System.out.println(stime);
		System.out.println(etime);
		List<Map<String, Object>> deposit = this.depositService.getDepositByIdT(1, stime, etime);
		return deposit;
	}
	
	@RequestMapping("/update")
	public void updateUser(HttpServletRequest request, HttpServletResponse response, Deposit deposit) throws Exception {
		int result = depositService.updateDeposit(deposit);
		if (result > 0) {
			logger.info("退押金成功");
			response.sendRedirect("/pages/moneyDelete.html");

		} else {
			logger.error("退押金失败");
			request.getRequestDispatcher("/pages/fail.html").forward(request, response);

		}
	}
	
	@ResponseBody
	@RequestMapping(value="/showList" , method = RequestMethod.GET)
	public Map<String, Object> showList(HttpServletRequest request, HttpServletResponse response, String page,String limit) throws Exception {
		logger.info("deposit list");
		System.out.println(page);
		System.out.println(limit);
		int offset=Integer.parseInt(limit)*(Integer.parseInt(page)-1);
		List<Deposit> depositlist = this.depositService.getDeposit(Integer.parseInt(limit), offset);
		int count = this.depositService.getDepositNum();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", depositlist);
		map.put("code",0);
		map.put("msg","");
		map.put("count",count);
		return map;
	}
}
