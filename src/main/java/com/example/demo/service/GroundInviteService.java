package com.example.demo.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GroundInviteService {

	public Map<String, Object> getGroundInviteByIdT(int id, @Param("stime") String stime, @Param("etime") String etime,
			@Param("mobile") String mobile);

}
