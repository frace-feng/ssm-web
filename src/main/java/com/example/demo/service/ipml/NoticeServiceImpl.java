package com.example.demo.service.ipml;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NoticeDao;
import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public int addNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.insertNotice(notice);
	}

	@Override
	public int deleteNotice(Integer id) {
		// TODO Auto-generated method stub
		return noticeDao.deleteNotice(id);
	}

	@Override
	public int updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.updateNotice(notice);
	}

	@Override
	public List<Map<String, Object>> getNotice(Integer id) {
		// TODO Auto-generated method stub
		return noticeDao.getNotice(id);
	}

	@Override
	public List<Notice> getNoticeList() {
		// TODO Auto-generated method stub
		return noticeDao.getNoticeList();
	}

}
