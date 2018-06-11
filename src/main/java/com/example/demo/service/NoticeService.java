package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Notice;

public interface NoticeService {

	// 插入消息
	public int addNotice(Notice notice);

	// 删除消息
	public int deleteNotice(Integer id);

	// 更新消息
	public int updateNotice(Notice notice);

	// 获得单条消息
	public List<Map<String, Object>> getNotice(Integer id);

	// 获得一个消息列表
	public List<Notice> getNoticeList(int limit, int offset);

}
