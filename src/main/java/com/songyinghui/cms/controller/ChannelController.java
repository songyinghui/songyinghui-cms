package com.songyinghui.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songyinghui.cms.bean.Category;
import com.songyinghui.cms.bean.Channel;
import com.songyinghui.cms.service.ChannelService;

@RequestMapping("channel")
@Controller
public class ChannelController {
	@Autowired
	private ChannelService service;

	@RequestMapping("channels")
	@ResponseBody
	public List<Channel> selects() {
		return service.selects();
	}
	@RequestMapping("selectsByChannelId")
	@ResponseBody
	public List<Category> selectsByChannelId(Integer channelId){
		return service.selectsByChannelId(channelId);
	}

}
