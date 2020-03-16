package com.songyinghui.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songyinghui.cms.bean.Slide;
import com.songyinghui.cms.dao.SlideDao;
import com.songyinghui.cms.service.SlideService;
@Service
public class SlideServiceImpl implements SlideService {
  @Autowired
  private SlideDao dao;
	@Override
	public List<Slide> selects() {
		// TODO Auto-generated method stub
		return dao.selects();
	}

}
