package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;
	private static final Log logger = (Log) LogFactory.getLog(NoticeController.class);

	@RequestMapping("/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response,@Valid Notice notice,BindingResult bindingResult)
			throws IOException, ServletException {
		int result = 0;
		if (notice != null) {
			result = noticeService.addNotice(notice);
		}
		if (result > 0) {
			logger.info("添加消息成功..");
			response.sendRedirect("/pages/managerNotice.html");
		} else {
			logger.error("注册消息失败");
			request.getRequestDispatcher("/pages/500.jhtml").forward(request, response);
		}
	}

	/**
	 * @Title: updateNotice
	 * @Description: 更新消息信息
	 * @param request
	 * @param response
	 * @param user
	 * @throws Exception
	 *             参数
	 */
	@RequestMapping("/update")
	public void updateUser(HttpServletRequest request, HttpServletResponse response, Notice notice) throws Exception {
		int result = noticeService.updateNotice(notice);
		if (result > 0) {
			logger.info("更新消息数据成功");
			response.sendRedirect("/pages/noticeUpdate.html");

		} else {
			logger.error("更新消息数据失败");
			request.getRequestDispatcher("/pages/500.html").forward(request, response);

		}
	}

	/**
	 * @Title: deleteNoticeById
	 * @Description: 删除一条消息记录
	 * @param request
	 * @param response
	 * @param id
	 * @throws Exception
	 *             参数
	 */
	@RequestMapping("/delete")
	public void deleteUserById(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		int result = noticeService.deleteNotice(Integer.parseInt(id));
		if (result > 0) {
			logger.info("删除消息数据成功..");
			response.sendRedirect("/pages/noticeDelete.html");

		} else {
			logger.error("删除消息数据失败..");
			request.getRequestDispatcher("/pages/500.html").forward(request, response);

		}
	}

	@ResponseBody
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public List<Map<String, Object>> ajax(HttpServletRequest request, Model model,String id) {
		String id1 = request.getParameter("id");
		System.out.println(id1);
		List<Map<String, Object>> user = this.noticeService.getNotice(Integer.parseInt(id));
		return user;
	}
}
