package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Pay;

public interface PayDao {

	List<Map<String, Object>> selectByPrimaryKey2(Integer day);

	// 查询时间范围
	List<Map<String, Object>> selectByPrimaryKeyT2(@Param("stime") String stime, @Param("etime") String etime);

	// 充值
	public int insertPay(Pay pay);
}
