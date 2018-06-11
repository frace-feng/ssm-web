package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Notice;

public interface NoticeDao {

	public int insertNotice(Notice notice);

	public int updateNotice(Notice notice);

	public int deleteNotice(Integer id);

	public List<Map<String, Object>> getNotice(Integer id);

	public List<Notice> getNoticeList();

}
