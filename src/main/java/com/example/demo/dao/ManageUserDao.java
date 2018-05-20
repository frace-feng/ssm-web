package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Login;

public interface ManageUserDao {

	public int insertUser(Login login);

	public int updateUser(Login login);

	public int deleteUser(Integer id);

	public Map<String, Object> getUser();
	
	public List<Map<String, Object>> getUser1(@Param("id") Integer id);

	public List<Map<String, Object>> getLoginList();

}
