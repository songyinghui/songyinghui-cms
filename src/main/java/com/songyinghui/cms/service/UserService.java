package com.songyinghui.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.User;

public interface UserService {
	PageInfo<User> userList(User user,Integer page,Integer pageSize);

	int update(User user);
	int insert(User user);

	User login(User formUser);

	Object selectByUsername(String username);
}
