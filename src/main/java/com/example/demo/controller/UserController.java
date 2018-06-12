package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	private static final Log logger = (Log) LogFactory.getLog(UserController.class);

	// 查询时间范围的注冊人数
	@ResponseBody
	@RequestMapping(value = "/ajaxshowUserT", method = RequestMethod.GET)
	public List<Map<String, Object>> ajax(HttpServletRequest request, Model model) {
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		System.out.println(stime);
		System.out.println(etime);
		List<Map<String, Object>> user = this.userService.getUserByIdT(1, stime, etime);
		return user;
	}

	// 查询注册的人
	@ResponseBody
	@RequestMapping(value = "/ajaxshowAdd", method = RequestMethod.GET)
	public List<Map<String, Object>> ajaxshowAdd(HttpServletRequest request, Model model) {
		logger.info("查询注册人数");
		List<Map<String, Object>> user = this.userService.getUserById1(1);
		return user;
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxshowAdd1", method = RequestMethod.GET)
	public List<Map<String, Object>> ajaxshowAdd1(HttpServletRequest request, Model model) {
		logger.info("查询注册+身份通过");
		List<Map<String, Object>> user = this.userService.getUserById2(1);
		return user;
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxshowAdd2", method = RequestMethod.GET)
	public List<Map<String, Object>> ajaxshowAdd2(HttpServletRequest request, Model model) {
		logger.info("查询注册+交押金");
		List<Map<String, Object>> user = this.userService.getUserById3(1);
		return user;
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxshowSex", method = RequestMethod.GET)
	public Map<String, Integer> ajaxshowSex(HttpServletRequest request, Model model) {
		logger.info("查询性别");
		Map<String, Integer> user = this.userService.getUserById4(1);
		return user;
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxshowAge", method = RequestMethod.GET)
	public Map<String, Integer> ajaxshowAge(HttpServletRequest request, Model model) {
		logger.info("查询年龄");
		Map<String, Integer> user = this.userService.getUserById5(1);
		return user;
	}
	@ResponseBody
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> insert(HttpServletRequest request, HttpServletResponse response, @RequestBody User user)
			throws IOException, ServletException {
		int result = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		if (user != null) {
			result = userService.addUser(user);
		}
		if (result > 0) {
			logger.info("添加成功..");
//			response.sendRedirect("/pages/managerClient.html");
			String message="添加成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("添加失败");
			String message="添加失败";
			map.put("message", message);

//			返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
//			request.getRequestDispatcher("/pages/500.html").forward(request, response);
		}
	}
	@ResponseBody
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateUser(HttpServletRequest request, HttpServletResponse response,@RequestBody User user) throws Exception {
		int result = userService.updateUser(user);
		Map<String,Object> map = new HashMap<String,Object>();
		if (result > 0) {
			logger.info("更新客户数据成功");
//			response.sendRedirect("/pages/clientUpdate.html");
			String message="更新客户数据成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("更新客户数据失败");
//			request.getRequestDispatcher("/pages/500.html").forward(request, response);
			String message="更新客户数据失败";
			map.put("message", message);

//			返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
	}
	@ResponseBody
	@RequestMapping(value="/delete",method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteUserById(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		int result = userService.deleteUser(Integer.parseInt(id));
		Map<String,Object> map = new HashMap<String,Object>();
		if (result > 0) {
			logger.info("删除客户数据成功..");
//			response.sendRedirect("/pages/clientDelete.html");
			String message="删除客户数据成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("删除客户数据失败..");
//			request.getRequestDispatcher("/pages/500.html").forward(request, response);
			String message="删除客户失败";
			map.put("message", message);

//			返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
//			request.getRequestDispatcher("/pages/500.html").forward(request, response);
		}
	}


	@ResponseBody
	@RequestMapping(value="/showList" , method = RequestMethod.GET)
	public Map<String, Object> showList(HttpServletRequest request,HttpServletResponse response, String page,String limit){
		logger.info("userlist");
		logger.info(page);
		logger.info(limit);
		int offset=Integer.parseInt(limit)*(Integer.parseInt(page)-1);
		List<User> userlist = this.userService.getUserList(Integer.parseInt(limit),offset);
		int count=this.userService.getUserNum();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data",userlist);
		map.put("code",0);
		map.put("msg","");
		map.put("count",count);

		return map;
		
	}

	//通过姓名查询
	@ResponseBody
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public List<Map<String, Object>> show(HttpServletRequest request, Model model,String clientName){
		logger.info("show one");
		return this.userService.getUser(clientName);
	}
}

// 查询用户列表信息
/*
 * @RequestMapping(value = "/showUser", method = RequestMethod.GET) public
 * String showUser(HttpServletRequest request, Model model){ //
 *  int userId =
 * Integer.parseInt(request.getParameter("id"));
 *  List<User> user =
 * this.userService.getUserById(1); return "index"; }
 */
/*
 * 查询日期天数
 * 
 * @ResponseBody
 * 
 * @RequestMapping(value = "/ajaxshowUser", method = RequestMethod.GET) public
 * List<Map<String, Object >> ajaxshowUser(HttpServletRequest request, Model
 * model){ String parameter = request.getParameter("day");
 * System.out.println(parameter); Integer day =
 * Integer.valueOf(request.getParameter("day").toString()); List<Map<String,
 * Object >> user = this.userService.getUserById(2,day); return user; }
 */