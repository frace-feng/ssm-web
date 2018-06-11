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

	public List<Login> getLoginList(@Param("limit") int limit,@Param("offset") int offset);
	//查询用户总数量
	public int userNum();
}
