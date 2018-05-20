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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping(value = "/web")
public class WebLoginController {
	@Resource
	private LoginService loginService;
	private Login login;
	private static final Log logger = (Log) LogFactory.getLog(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("login GET方法被调用。。。");
		return "login";
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(String loginname, String passwd, Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		List<Map<String, Object>> result = this.loginService.getLoginById();

		logger.info("登录名：" + loginname + "密码：" + passwd);

		for (int i = 0; i < result.size(); i++) {
			Map<String, Object> map = result.get(i);
			String email = (String) map.get("email");
			System.out.println(email);
			String passWord = (String) map.get("passWord");
			System.out.println(passWord);
			if (email.equals(loginname) && passWord.equals(passwd)) {
				model.addAttribute("login", login);
				break;
			} else {
				logger.info("重新登录");
				return;
			}
		}
		response.sendRedirect("/pages/main.html");

	}

	// 检测数据是否存在
	@ResponseBody
	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public List<Map<String, Object>> ajaxshowAdd(HttpServletRequest request, Model model) {
		List<Map<String, Object>> login = this.loginService.getLoginById();
		return login;
	}

}
