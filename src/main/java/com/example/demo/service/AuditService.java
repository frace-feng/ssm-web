package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AuditService {
	public List<Map<String, Object>> getAuditById(int id, @Param("stime") String stime, @Param("etime") String etime);
}
