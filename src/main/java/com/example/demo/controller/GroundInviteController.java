package com.example.demo.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.GroundInviteService;

@Controller
@RequestMapping("/groundInvite")
public class GroundInviteController {
	@Resource
	private GroundInviteService groundInviteService;

	//Encapsulation datas
	@ResponseBody
	@RequestMapping(value = "/ajaxshowGroundInviteT", method = RequestMethod.GET)
	public Map<String, Object> ajax(HttpServletRequest request, Model model) {

		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		String mobile = request.getParameter("mobile");
		System.out.println(stime);
		System.out.println(etime);
		System.out.println(mobile);
		Map<String, Object> ground = this.groundInviteService.getGroundInviteByIdT(1, stime, etime, mobile);
		return ground;
	}

}
