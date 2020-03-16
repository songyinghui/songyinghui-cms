package com.songyinghui.cms.dao;


import java.util.List;

import com.songyinghui.cms.bean.Category;
import com.songyinghui.cms.bean.Channel;

public interface ChannelDao {
    List<Channel> selects();

	List<Category> selectsByChannelId(Integer channelId);
}
