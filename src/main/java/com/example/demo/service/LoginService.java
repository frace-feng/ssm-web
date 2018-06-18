package com.example.demo.service;



import java.util.List;
import java.util.Map;

import com.example.demo.entity.Login;

public interface LoginService {
	//public List<Map<String, Object>> getLoginById();
	Login checkLogin(String userName,String passWord);
	List<Map<String, Object>> getLoginById();
}
