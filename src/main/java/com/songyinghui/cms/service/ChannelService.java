package com.songyinghui.cms.service;

import java.util.List;

import com.songyinghui.cms.bean.Category;
import com.songyinghui.cms.bean.Channel;

public interface ChannelService {
	  List<Channel> selects();

	List<Category> selectsByChannelId(Integer channelId);
}
