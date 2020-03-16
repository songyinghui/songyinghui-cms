package com.songyinghui.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songyinghui.cms.bean.Category;
import com.songyinghui.cms.bean.Channel;
import com.songyinghui.cms.dao.ChannelDao;
import com.songyinghui.cms.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private ChannelDao dao;

	@Override
	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return dao.selects();
	}

	@Override
	public List<Category> selectsByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		return dao.selectsByChannelId(channelId);
	}
}
