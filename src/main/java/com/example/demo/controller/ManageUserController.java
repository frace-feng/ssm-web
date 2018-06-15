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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Login;
import com.example.demo.entity.MD5;
import com.example.demo.service.ManageUserService;

@Controller
@RequestMapping("/manage")
public class ManageUserController {

	@Resource
	private ManageUserService manageUserService;

	private static final Log logger = (Log) LogFactory.getLog(ManageUserController.class);

	/**
	 * @Title: addPage
	 * @Description: 用户添加页面
	 * @param mm
	 * @return 参数
	 */

	@RequestMapping(value = "/register")
	public String addPage(ModelMap mm) {
		logger.info("add page...");
		return "managerIndex";
	}

	/**
	 * @Title: Regiseter
	 * @Description: 用户添加操作
	 * @param request
	 * @param response
	 * @param login
	 * @throws IOException
	 * @throws ServletException
	 *             参数
	 */
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> insert(@RequestBody Login login)
			throws IOException, ServletException {
		int result = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		if (login != null) {
			login.setpassWord(MD5.getResult(login.getpassWord()));
			result = manageUserService.addUser(login);
		}
		if (result > 0) {
			logger.info("注册成功..");
			String message="添加用户成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("注册失败");
			String message="添加用户失败";
			map.put("message", message);
			//返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @Title: updateUser
	 * @Description: 更新用户信息
	 * @param request
	 * @param response
	 * @param login
	 * @throws Exception
	 *             参数
	 */
	@ResponseBody
	@RequestMapping(value="/updateuser",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateUser(@RequestBody Login login) throws IOException, ServletException {

		int result = manageUserService.updateUser(login);
		Map<String,Object> map = new HashMap<String,Object>();

		if (result > 0) {
			logger.info("更新用户数据成功");
//			response.sendRedirect("/pages/userUpdate.html");
			String message="更新用户数据成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("更新用户数据失败");
//			request.getRequestDispatcher("/pages/500.html").forward(request, response);这句话存在就不行
			String message="更新用户数据失败";
			map.put("message", message);

//			返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @Title: deleteUserById
	 * @Description: 删除一条用户记录
	 * @param request
	 * @param response
	 * @param id
	 * @throws Exception
	 *             参数
	 */
	@ResponseBody
	@RequestMapping(value="/delete",method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteUserById(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		int result = manageUserService.deleteUser(Integer.parseInt(id));
		Map<String,Object> map = new HashMap<String,Object>();
		if (result > 0) {
			logger.info("删除用户成功..");
			String message="删除用户成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);

		} else {
			logger.error("删除用户失败..");
			String message="删除用户失败";
			map.put("message", message);
			//返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);


		}
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public Map<String, Object> User( HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {

		Map<String, Object> list = manageUserService.getLogin();
		
		logger.info("展示数据");
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/show1", method = RequestMethod.GET)
	public List<Map<String, Object>> ajax(HttpServletRequest request, Model model,String id) {
		String id1 = request.getParameter("id");
		System.out.println(id1);
		List<Map<String, Object>> user = this.manageUserService.getUser1(Integer.parseInt(id));
		return user;
	}
	
	/**
	 * @Title: listUser
	 * @Description: 列表显示所有用户
	 * @param mm
	 * @return 参数
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value ="/showlist", method = RequestMethod.GET)
	public Map<String, Object> showList(HttpServletRequest request,HttpServletResponse response, String page,String limit)
			throws IOException {
		//传过来两个参数，page和limit，就是当前也是和每一页数量
		int offset=Integer.parseInt(limit)*(Integer.parseInt(page)-1);
		List<Login> userlist = this.manageUserService.getLoginList(Integer.parseInt(limit),offset);
		int count=this.manageUserService.getUserNum();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data",userlist);
		map.put("code",0);
		map.put("msg","");
		map.put("count",count);
		return map;
	}

}
