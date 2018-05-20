package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.Pay;
import com.example.demo.service.PayService;

@Controller
// @RestController
@RequestMapping("/pay")
public class PayController {

	@Resource
	private PayService payService;
	private static final Log logger = (Log) LogFactory.getLog(LoginController.class);
	// 查询天数
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/ajaxshowPay", method = RequestMethod.GET) public
	 * List<Map<String, Object>> ajax(HttpServletRequest request, Model model){
	 * String parameter = request.getParameter("day");
	 * System.out.println(parameter); Integer day =
	 * Integer.valueOf(request.getParameter("day").toString()); List<Map<String,
	 * Object>> pay = this.payService.getPayById(1,day); return pay; }
	 */

	// 查询时间范围的充值情况
	@ResponseBody
	@RequestMapping(value = "/ajaxshowPayT", method = RequestMethod.GET)
	public List<Map<String, Object>> ajax(HttpServletRequest request, Model model) {

		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		System.out.println(stime);
		System.out.println(etime);
		List<Map<String, Object>> pay = this.payService.getPayByIdT(1, stime, etime);
		return pay;
	}

	// 充值
	@RequestMapping("/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response,@Valid Pay pay,BindingResult bindingResult)
			throws IOException, ServletException {
		int result = 0;
		if (pay != null) {
			result = payService.addPay(pay);
		}
		if (result > 0) {
			logger.info("充值成功..");
			response.sendRedirect("/pages/managerMoney.html");
		} else {
			logger.error("充值失败");
			request.getRequestDispatcher("/pages/500.jhtml").forward(request, response);
		}
	}
}
