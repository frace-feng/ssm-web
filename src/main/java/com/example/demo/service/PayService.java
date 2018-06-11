package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Pay;

public interface PayService {

	public List<Map<String, Object>> getPayById(int id, Integer day);

	// 查询时间范围
	public List<Map<String, Object>> getPayByIdT(int id, @Param("stime") String stime, @Param("etime") String etime);

	// 充值
	public int addPay(Pay pay);
	
	public List<Pay> getPay(int limit,int offset);
}
