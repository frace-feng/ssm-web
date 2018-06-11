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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Login;
import com.example.demo.entity.MD5;
import com.example.demo.service.ManageUserService;

@Controller
@RequestMapping(value = "/manage")
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
	@RequestMapping("/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response, Login login)
			throws IOException, ServletException {
		int result = 0;
		if (login != null) {
			login.setpassWord(MD5.getResult(login.getpassWord()));
			result = manageUserService.addUser(login);
		}
		if (result > 0) {
			logger.info("注册成功..");
			response.sendRedirect("/pages/managerIndex.html");
		} else {
			logger.error("注册失败");
			request.getRequestDispatcher("/pages/fail.html").forward(request, response);
		}
	}

	/**
	 * @Title: updateUser
	 * @Description: 更新用户信息
	 * @param request
	 * @param response
	 * @param user
	 * @throws Exception
	 *             参数
	 */
	@RequestMapping("/update")
	public void updateUser(HttpServletRequest request, HttpServletResponse response, Login login) throws Exception {
		int result = manageUserService.updateUser(login);
		if (result > 0) {
			logger.info("更新用户数据成功");
			response.sendRedirect("/pages/userUpdate.html");

		} else {
			logger.error("更新用户数据失败");
			request.getRequestDispatcher("/pages/500.html").forward(request, response);

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
	@RequestMapping("/delete")
	public void deleteUserById(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		int result = manageUserService.deleteUser(Integer.parseInt(id));
		if (result > 0) {
			logger.info("删除用户数据成功..");
			response.sendRedirect("/pages/userDelete.html");

		} else {
			logger.error("删除用户数据失败..");
			request.getRequestDispatcher("/pages/500.html").forward(request, response);

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
	@RequestMapping(value ="/showlist", method = RequestMethod.GET)
	public List<Map<String, Object>> listUser( HttpServletRequest request, Model model)
			throws IOException {
		List<Map<String, Object>> list = manageUserService.getLoginList(1);
		//mm.put("list", list);
		logger.info("展示数据");
		return list;
		// response.sendRedirect("/pages/test.html");
	}
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/insert1", method = RequestMethod.POST) public void
	 * insert(HttpServletRequest request, Model model){ String id =
	 * request.getParameter("id"); String userName =
	 * request.getParameter("userName"); String passWord =
	 * request.getParameter("passWord"); String email =
	 * request.getParameter("email"); String status =
	 * request.getParameter("status"); System.out.println(id);
	 * System.out.println(userName); System.out.println(passWord);
	 * System.out.println(email); System.out.println(status);
	 * 
	 * 
	 * // return String.valueOf(manageUserService.addUserById(id, userName,
	 * passWord, email, status)); }
	 */

}
