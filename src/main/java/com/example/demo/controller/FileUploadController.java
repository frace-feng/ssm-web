package com.example.demo.controller;


import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/load")
public class FileUploadController {

	private static final Log logger = (Log) LogFactory.getLog(FileUploadController.class);
	
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(HttpServletRequest request, HttpServletResponse response, @RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws Exception {
		System.out.println(description);
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/file/");
			// 上传文件名
			String filename = file.getOriginalFilename();
			File filepath = new File(path, filename);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + filename));
			logger.info("上传文件成功");
			response.sendRedirect("/pages/success.html");
		} else {
			logger.error("上传失败");
			request.getRequestDispatcher("/pages/fail.html").forward(request, response);
		}

	}

	@ResponseBody
	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename,
			Model model) throws Exception {
		String path = request.getServletContext().getRealPath("/img/");
		File file = new File(path + File.pathSeparator + filename);
		HttpHeaders headers = new HttpHeaders();
		// 下载的文件名字如果是中文，解决中文乱码现象
		String downloadFilename = new String(filename.getBytes("UTF-8"), "iso-8859-1");
		// 通知浏览器以attachment方式下载图片
		headers.setContentDispositionFormData("attachment", downloadFilename);
		// application/octet-stream:二进制流数据（常见的文件下载）
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 201 HttpStatus.CREATED
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
