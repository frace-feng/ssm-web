package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DepositDao {

	List<Map<String, Object>> selectByPrimaryKey3(Integer day);

	// 查询时间范围
	List<Map<String, Object>> selectByPrimaryKeyT3(@Param("stime") String stime, @Param("etime") String etime);

}
