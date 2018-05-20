package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.DepositService;

@Controller
// @RestController
@RequestMapping("/deposit")
public class DepositController {
	@Resource
	private DepositService depositService;

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

}
