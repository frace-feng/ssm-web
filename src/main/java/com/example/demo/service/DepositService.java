package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DepositService {
	public List<Map<String, Object>> getDepositById(int id, Integer day);

	// 查询时间范围
	public List<Map<String, Object>> getDepositByIdT(int id, @Param("stime") String stime,
			@Param("etime") String etime);

}
