package com.songyinghui.cms.dao;

import java.util.List;

import com.songyinghui.cms.bean.User;

public interface UserDao {
	/**
	 * 
	 * @Title: userList 
	 * @Description: 条件查询所有用户
	 * @param user
	 * @return
	 * @return: List<User>
	 */
   List<User> userList(User user);

	int update(User user);
	int insert(User user);

	User selectByUserName(String username);
}
