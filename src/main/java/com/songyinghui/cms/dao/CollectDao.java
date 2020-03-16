package com.songyinghui.cms.dao;

import org.apache.ibatis.annotations.Param;

import com.songyinghui.cms.bean.Collect;

public interface CollectDao {

	Collect select(@Param("title")String title,@Param("id") Integer id);

	int insert(Collect collect);

	int deleteCollect(Integer id);

}
