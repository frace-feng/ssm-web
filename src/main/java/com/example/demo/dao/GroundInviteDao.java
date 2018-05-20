package com.example.demo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GroundInviteDao {

	Map<String, Object> selectByPrimaryKeyT4(@Param("stime") String stime, @Param("etime") String etime,
			@Param("mobile") String mobile);

}
