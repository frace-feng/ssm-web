package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AuditDao {
	List<Map<String, Object>> selectByPrimaryKeyT11(@Param("stime") String stime, @Param("etime") String etime);

}
