package com.example.demo.service.ipml;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDao;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Resource
	private LoginDao loginDao;

	@Override
	public List<Map<String, Object>> getLoginById() {
		// TODO Auto-generated method stub
		return loginDao.selectById();
	}

}
