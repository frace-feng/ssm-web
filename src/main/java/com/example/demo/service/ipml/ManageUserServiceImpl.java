package com.example.demo.service.ipml;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ManageUserDao;
import com.example.demo.service.ManageUserService;
import com.example.demo.entity.Login;

@Service("ManageUserService")
public class ManageUserServiceImpl implements ManageUserService {

	@Autowired
	private ManageUserDao manageUserDao;

	@Override
	public int addUser(Login login) {
		// TODO Auto-generated method stub
		int result = manageUserDao.insertUser(login);
		return result;

	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		int result = manageUserDao.deleteUser(id);
		return result;
	}

	@Override
	public int updateUser(Login login) {
		// TODO Auto-generated method stub
		int result = manageUserDao.updateUser(login);
		return result;
	}

	@Override
	public Map<String, Object> getLogin() {
		// TODO Auto-generated method stub
		Map<String, Object> user = manageUserDao.getUser();
		return user;
	}

	@Override
	public List<Map<String, Object>> getUser1( @Param("id") Integer id) {
		// TODO Auto-generated method stub
		return manageUserDao.getUser1(id);
	}
	
	@Override
	public List<Map<String, Object>> getLoginList(int id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = manageUserDao.getLoginList();
		return list;
	}

}
