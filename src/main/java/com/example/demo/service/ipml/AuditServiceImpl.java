package com.example.demo.service.ipml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.AuditDao;
import com.example.demo.dao.UserDao;
import com.example.demo.service.AuditService;

@Service
public class AuditServiceImpl implements AuditService {
	@Resource
	private AuditDao auditDao;

	@Resource
	private UserDao userDao;

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getAuditById(int id) {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		List finalre = new ArrayList<>();
		List<Map<String, Object>> r1 = auditDao.selectByPrimaryKeyT11();
		for (int i = 0; i < r1.size(); i++) {
			Map<String, Object> p1 = r1.get(i);
			finalre.add(p1);
		}

		return finalre;
	}

}
