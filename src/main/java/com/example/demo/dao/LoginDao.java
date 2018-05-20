package com.example.demo.dao;

import java.util.List;
import java.util.Map;

public interface LoginDao {
	// 通过Mapper映射得出登录的用户名，密码
	List<Map<String, Object>> selectById();

}
