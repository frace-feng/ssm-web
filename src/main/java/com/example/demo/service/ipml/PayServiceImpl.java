package com.example.demo.service.ipml;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PayDao;
import com.example.demo.entity.Pay;
import com.example.demo.service.PayService;

@Service
public class PayServiceImpl implements PayService {

	@Resource
	private PayDao payDao;

	// 查询天数
	public List<Map<String, Object>> getPayById(int id, Integer day) {
		return payDao.selectByPrimaryKey2(day);
	}

	// 查询时间范围
	@Override
	public List<Map<String, Object>> getPayByIdT(int id, @Param("stime") String stime, @Param("etime") String etime) {
		// TODO Auto-generated method stub
		return payDao.selectByPrimaryKeyT2(stime, etime);
	}

	@Override
	public int addPay(Pay pay) {
		// TODO Auto-generated method stub
		return payDao.insertPay(pay);
	}

}
