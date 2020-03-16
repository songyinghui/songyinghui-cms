package com.songyinghui.cms.service;

import com.songyinghui.cms.bean.Collect;

public interface CollectService {

	Collect select(String title, Integer id);

	int insert(Collect collect);

	int deleteCollect(Integer id);

}
