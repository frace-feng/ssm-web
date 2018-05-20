package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.AuditService;

@Controller
@RequestMapping(value = "/audit")
public class AuditController {
	@Resource
	private AuditService auditService;

	@ResponseBody
	@RequestMapping(value = "/ajaxShowAudit")
	public List<Map<String, Object>> ajaxShowAudit(HttpServletRequest request, Model model) {

		List<Map<String, Object>> audit = this.auditService.getAuditById(1);
		return audit;
	}

}
