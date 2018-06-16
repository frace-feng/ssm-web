package com.example.demo.dao;



import java.util.List;
import java.util.Map;

import com.example.demo.entity.Login;

public interface LoginDao {
	// 通过Mapper映射得出登录的用户名，密码
	Login selectByUserName(String userName);
	List<Map<String, Object>> selectById();
	List<Map<String, Object>> selectByStatus();

}
