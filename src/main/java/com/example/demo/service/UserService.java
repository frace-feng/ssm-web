package com.example.demo.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;

public interface UserService {

	// 通过id查詢出來的数据是数组列表形式，传参day
	// public List<Map<String, Object >> getUserById(int id,Integer day);
	// 查询时间范围内的注册人数
	public List<Map<String, Object>> getUserByIdT(int id, @Param("stime") String stime, @Param("etime") String etime);

	// 查询用户数据--注册的人
	public List<Map<String, Object>> getUserById1(int id);

	// 查询用户数据--注册的人+身份通过
	public List<Map<String, Object>> getUserById2(int id);

	// 查询用户数据--注册的人+身份通过+交押金
	public List<Map<String, Object>> getUserById3(int id);

	// 查询性别
	public Map<String, Integer> getUserById4(int id);

	// 查询年龄
	public Map<String, Integer> getUserById5(int id);
	
	//添加用户
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(int id);

	public List<User> getUserList(int limit,int offset);
	public int getUserNum();
	//查询单个用户
	public List<Map<String, Object>> getUser(String clientName);
	
}
