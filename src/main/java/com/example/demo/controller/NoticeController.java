package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
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
import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;
	private static final Log logger = (Log) LogFactory.getLog(NoticeController.class);

	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> insert(@RequestBody Notice notice)
			throws IOException, ServletException {
		int result = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		if (notice != null) {
			result = noticeService.addNotice(notice);
		}
		if (result > 0) {
			logger.info("注册成功..");
			String message="添加消息成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("注册失败");
			String message="添加消息失败";
			map.put("message", message);
			//返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
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
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateNotice(@RequestBody Notice notice) throws Exception {
		int result = noticeService.updateNotice(notice);
		Map<String,Object> map = new HashMap<String,Object>();
		if (result > 0) {
			logger.info("更新消息数据成功");
			String message="更新消息数据成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			logger.error("更新消息数据失败");
			String message="更新消息数据失败";
			map.put("message", message);
			//返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
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
	@RequestMapping(value="/delete",method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteNoticeById( String id) throws Exception {
		int result = noticeService.deleteNotice(Integer.parseInt(id));
		Map<String,Object> map = new HashMap<String,Object>();
		if (result > 0) {
			logger.info("删除消息成功..");
			String message="删除消息成功";
			map.put("message", message);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);

		} else {
			logger.error("删除消息失败..");
			String message="删除消息失败";
			map.put("message", message);
			//返回状态码400，代表请求错误
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
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
	
	@ResponseBody
	@RequestMapping(value = "/showList", method = RequestMethod.GET)
	public Map<String, Object> showList(Model model, String page, String limit) {
		logger.info("notice list");
		System.out.println(page);
		System.out.println(limit);
		int offset=Integer.parseInt(limit)*(Integer.parseInt(page)-1);
		List<Notice> noticelist = this.noticeService.getNoticeList(Integer.parseInt(limit), offset);
		int count = this.noticeService.getNoticeNum();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", noticelist);
		map.put("code",0);
		map.put("msg","");
		map.put("count",count);
		return map;
	}
}
