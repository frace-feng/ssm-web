package com.example.demo.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping(value = "/web")


public class WebLoginController {
	@Resource
	private LoginService loginService;
	private static final Log logger = (Log) LogFactory.getLog(WebLoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("login GET方法被调用。。。");
		return "login";
	}

	//表单提交过来的路径
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public void checkLogin(Login login, Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		login = loginService.checkLogin(login.getUserName(), login.getpassWord());
		 if(login != null) {
			 model.addAttribute("login", login);
			 response.sendRedirect("/pages/main.html");
		 }
		 else {
		 response.sendRedirect("/pages/fail.html");
		 }
	}
	
	    //测试超链接跳转到另一个页面是否可以取到session值
		@RequestMapping("/anotherpage")
		public void hrefpage(HttpServletResponse response) throws IOException{
			
			 response.sendRedirect("/pages/anotherPage.html");
		}
		
		//注销方法
		@RequestMapping("/outLogin")
		public void outLogin(HttpServletResponse response) throws IOException{
			//通过session.invalidata()方法来注销当前的session
			response.sendRedirect("/pages/login.html");
		}
	

	/*// 检测数据是否存在
	@ResponseBody
	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public List<Map<String, Object>> ajaxshowAdd(HttpServletRequest request, Model model) {
		List<Map<String, Object>> login = this.loginService.getLoginById();
		return login;
	}*/

}
