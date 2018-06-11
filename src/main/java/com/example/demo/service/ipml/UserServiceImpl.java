package com.example.demo.service.ipml;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * Created by Administrator on 2018/3/28.
 */

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	// 通过id查询user的列表
	public List<Map<String, Object>> getUserById(int userId, Integer day) {
		return userDao.selectByPrimaryKey1(day);
	}

	// 查询时间范围的注册人数
	@Override
	public List<Map<String, Object>> getUserByIdT(int id, @Param("stime") String stime, @Param("etime") String etime) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKeyT1(stime, etime);
	}

	// 查詢不同条件下的注册人数--月
	@Override
	public List<Map<String, Object>> getUserById1(int id) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKeyT8();
	}

	@Override
	public List<Map<String, Object>> getUserById2(int id) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKeyT9();
	}

	@Override
	public List<Map<String, Object>> getUserById3(int id) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKeyT10();
	}

	@Override
	public Map<String, Integer> getUserById4(int id) {
		// TODO Auto-generated method stub
		Integer o1 = userDao.selectByPrimaryKeyT31();
		Integer o2 = userDao.selectByPrimaryKeyT32();
		Map<String, Integer> result = new HashMap<>();
		result.put("o1", o1);
		result.put("o2", o2);
		return result;
	}

	@Override
	public Map<String, Integer> getUserById5(int id) {
		// TODO Auto-generated method stub
		Integer o1 = userDao.selectByPrimaryKeyT33();
		Integer o2 = userDao.selectByPrimaryKeyT34();
		Integer o3 = userDao.selectByPrimaryKeyT35();
		Integer o4 = userDao.selectByPrimaryKeyT36();
		Integer o5 = userDao.selectByPrimaryKeyT37();
		Integer o6 = userDao.selectByPrimaryKeyT38();
		Map<String, Integer> result = new HashMap<>();
		result.put("o1", o1);
		result.put("o2", o2);
		result.put("o3", o3);
		result.put("o4", o4);
		result.put("o5", o5);
		result.put("o6", o6);
		return result;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int result = userDao.insertUser(user);
		return result;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		int result= userDao.updateUser(user);
		return result;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		int result= userDao.deleteUser(id);
		return result;
	}

	@Override
	public List<User> getUserList(int page,int limit) {
		// TODO Auto-generated method stub
		return userDao.selectList(page,limit);
	}

	@Override
	public int getUserNum() {
		// TODO Auto-generated method stub
		return userDao.userNum();
	}
	@Override
	public List<Map<String, Object>> getUser(@Param("clientName") String clientName) {
		// TODO Auto-generated method stub
		return userDao.selectByName(clientName);
	}

	// 增加用户
	/*
	 * public boolean addUser(User record){
	 *  boolean result = false; 
	 *  try {
	 * userDao.insertSelective(record); 
	 * result = true; 
	 * } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return result; }
	 */
}
