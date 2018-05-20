package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Client;

@Controller
@RequestMapping(value = "/newuser")
public class LoginController {
	private static List<Client> clientList;

	public LoginController() {
		super();
		clientList = new ArrayList<Client>();
	}

	private static final Log logger = (Log) LogFactory.getLog(LoginController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("register GET方法被调用。。。");
		return "registerForm";
	}

	@RequestMapping(value = "/register")
	public void register(String loginname, String passwd, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("register POST 方法被调用。。。");
		Client client = new Client();
		client.setLoginname(loginname);
		client.setPasswd(passwd);
		// client.setUsername(username);
		clientList.add(client);
		response.sendRedirect("/pages/login.html");
		// return "registerForm";
	}

	@RequestMapping(value = "/login")
	public void login(String loginname, String passwd, Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("登录名：" + loginname + "密码：" + passwd);
		for (Client client : clientList) {
			if (client.getLoginname().equals(loginname) && client.getPasswd().equals(passwd)) {
				model.addAttribute("client", client);
			}
		}
		response.sendRedirect("/pages/main.html");
	}
}
