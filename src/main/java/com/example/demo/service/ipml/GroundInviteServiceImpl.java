package com.example.demo.service.ipml;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GroundInviteDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.UserDao;
import com.example.demo.service.GroundInviteService;

@Service
public class GroundInviteServiceImpl implements GroundInviteService {
	@Resource
	private GroundInviteDao groundInviteDao;

	@Resource
	private UserDao userDao;

	@Resource
	private OrderDao orderDao;

	// 封装查询出来的四组数据
	@Override
	public Map<String, Object> getGroundInviteByIdT(int id, @Param("stime") String stime, @Param("etime") String etime,
			@Param("mobile") String mobile) {
		// TODO Auto-generated method stub
		Map<String, Object> n1 = groundInviteDao.selectByPrimaryKeyT4(stime, etime, mobile);
		Object o = n1.get("num1");//map get(key)
		Map<String, Object> n2 = userDao.selectByPrimaryKeyT5(stime, etime, mobile);
		Object o2 = n2.get("num2");
		Map<String, Object> n3 = userDao.selectByPrimaryKeyT6(stime, etime, mobile);
		Object o3 = n3.get("num3");
		Map<String, Object> n4 = orderDao.selectByPrimaryKeyT7(stime, etime, mobile);
		Object o4 = n4.get("num4");
		Map<String, Object> remap = new HashMap<>();
		remap.put("num1", o);//map put(key,value)
		remap.put("num2", o2);
		remap.put("num3", o3);
		remap.put("num4", o4);

		return remap;
	}

}
