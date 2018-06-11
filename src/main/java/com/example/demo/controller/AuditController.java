package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	private static final Log logger = (Log) LogFactory.getLog(AuditController.class);

	@ResponseBody
	@RequestMapping(value = "/ajaxShowAudit")
	public List<Map<String, Object>> ajaxShowAudit(HttpServletRequest request, Model model) {
		logger.info("流失人群统计");
		List<Map<String, Object>> audit = this.auditService.getAuditById(1);
		return audit;
	}

}
