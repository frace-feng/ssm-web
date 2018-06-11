package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.User;

public interface UserDao {

	// 通过主键查询map
	List<Map<String, Object>> selectByPrimaryKey1(Integer day);

	// 查询时间范围
	List<Map<String, Object>> selectByPrimaryKeyT1(@Param("stime") String stime, @Param("etime") String etime);

	// 查询身份通过的
	Map<String, Object> selectByPrimaryKeyT5(@Param("stime") String stime, @Param("etime") String etime,
			@Param("mobile") String mobile);

	// 查询交押金
	Map<String, Object> selectByPrimaryKeyT6(@Param("stime") String stime, @Param("etime") String etime,
			@Param("mobile") String mobile);

	// 查询按月的注册数
	List<Map<String, Object>> selectByPrimaryKeyT8();

	// 查询按月的注册数+上传身份证+上传驾照
	List<Map<String, Object>> selectByPrimaryKeyT9();

	// 查询按月的注册数+上传身份证+上传驾照+交押金的
	List<Map<String, Object>> selectByPrimaryKeyT10();

	// 查询性别
	Integer selectByPrimaryKeyT31();

	Integer selectByPrimaryKeyT32();
	
	//查询年龄
	Integer selectByPrimaryKeyT33();

	Integer selectByPrimaryKeyT34();

	Integer selectByPrimaryKeyT35();

	Integer selectByPrimaryKeyT36();

	Integer selectByPrimaryKeyT37();

	Integer selectByPrimaryKeyT38();	
	//插入
	public int insertUser(User user); 	
	//更新
	public int updateUser(User user);
	//删除
	public int deleteUser(int id);
	//查询多条数据
	public List<User> selectList(@Param("limit") int limit,@Param("offset") int offset);
	//查询用户总数量
	public int userNum();
	//查询单个用户
	public List<Map<String, Object>> selectByName(String clientName);
	
}