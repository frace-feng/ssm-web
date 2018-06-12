package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
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
	private static final Log logger = (Log) LogFactory.getLog(PayController.class);
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
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> insert(@RequestBody Pay pay)
			throws IOException, ServletException {
		int result = 0;
		if (pay != null) {
			result = payService.addPay(pay);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		if (result > 0) {
			logger.info("注册成功..");
			String message="添加充值成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("注册失败");
			String message="添加充值失败";
			map.put("message", message);
			//返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/showList" , method = RequestMethod.GET)
	public Map<String, Object> showList( Model model,String page,String limit){
		logger.info("pay list");
		System.out.println(page);
		System.out.println(limit);
		int offset=Integer.parseInt(limit)*(Integer.parseInt(page)-1);
		int count = this.payService.getPayNum();
		List<Pay> paylist = this.payService.getPay(Integer.parseInt(limit), offset);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", paylist);
		map.put("code",0);
		map.put("msg","");
		map.put("count",count);
		return map;
		
	}
}
