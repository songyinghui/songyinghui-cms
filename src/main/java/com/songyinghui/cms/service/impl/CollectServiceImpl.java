package com.songyinghui.cms.service.impl;

import java.awt.color.CMMException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songyinghui.cms.bean.Collect;
import com.songyinghui.cms.dao.CollectDao;
import com.songyinghui.cms.service.CollectService;
import com.songyinghui.cms.util.CMSException;
import com.syh.common.utils.StringUtil;
@Service
public class CollectServiceImpl implements CollectService{
  @Autowired
  private CollectDao dao;
	@Override 
	public Collect select(String title, Integer id) {
		// TODO Auto-generated method stub
		return dao.select(title,id) ;
	}
	@Override
	public int insert(Collect collect) {
		if(!StringUtil.isHttpUrl(collect.getUrl())) {
			throw new CMSException("不合法的url地址");
		}
		collect.setCreated(new Date());
		return dao.insert(collect);
	}
	@Override
	public int deleteCollect(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteCollect(id);
	}

}
