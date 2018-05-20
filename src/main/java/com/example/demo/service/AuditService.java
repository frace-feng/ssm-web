package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface AuditService {
	public List<Map<String, Object>> getAuditById(int id);
}
