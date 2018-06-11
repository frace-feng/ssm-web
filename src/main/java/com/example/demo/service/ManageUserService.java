package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Login;

public interface ManageUserService {

	// 插入用户
	public int addUser(Login login);

	// 删除用户
	public int deleteUser(Integer id);

	// 更新用户
	public int updateUser(Login login);

	// 获得单条用户
	public Map<String, Object> getLogin();

	public List<Map<String, Object>> getUser1(@Param("id") Integer id);
	
	// 获得一个列表
	public List<Map<String, Object>> getLoginList(int id);
}
