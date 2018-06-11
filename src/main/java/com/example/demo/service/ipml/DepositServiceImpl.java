package com.example.demo.service.ipml;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DepositDao;
import com.example.demo.entity.Deposit;
import com.example.demo.service.DepositService;

@Service
public class DepositServiceImpl implements DepositService {
	@Resource
	private DepositDao depositDao;

	public List<Map<String, Object>> getDepositById(int id, Integer day) {
		return depositDao.selectByPrimaryKey3(day);
	}

	// 显示时间范围
	@Override
	public List<Map<String, Object>> getDepositByIdT(int id, @Param("stime") String stime,
			@Param("etime") String etime) {
		// TODO Auto-generated method stub
		return depositDao.selectByPrimaryKeyT3(stime, etime);
	}

	@Override
	public int updateDeposit(Deposit deposit) {
		// TODO Auto-generated method stub
		return depositDao.updateDeposit(deposit);
	}

	@Override
	public List<Deposit> getDeposit(int limit, int offset) {
		// TODO Auto-generated method stub
		return depositDao.selectAll(limit, offset);
	}

}
