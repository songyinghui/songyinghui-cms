package com.songyinghui.cms.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.User;
import com.songyinghui.cms.dao.UserDao;
import com.songyinghui.cms.service.UserService;
import com.songyinghui.cms.util.CMSException;
import com.songyinghui.cms.util.Md5Util;
import com.syh.common.utils.StringUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	@Override
	public PageInfo<User> userList(User user, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		return new PageInfo<User>(dao.userList(user));
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return dao.update(user);
	}

	@Override
	public int insert(User user) {
		 //通过自定义校验规则 对注册用户进行校验
		if(!com.syh.common.utils.StringUtil.hasText(user.getUsername())) {
			throw new CMSException("用户名不能为空");
		}
		if(!(user.getUsername().length()>=2&&user.getUsername().length()<=10)) {
			throw new CMSException("用户名长度6-10之间");
		}
		//校验密码
		if(!com.syh.common.utils.StringUtil.hasText(user.getPassword())) {
			throw new CMSException("用户密码不能为空");
		}
		if(!(user.getPassword().length()>=6&&user.getPassword().length()<=10)) {
			throw new CMSException("用户密码6-10位");
		}
		//确认密码的校验
		if(!com.syh.common.utils.StringUtil.hasText(user.getRepassword())) {
			throw new CMSException("确认密码不能为空");
		}
		if(!(user.getRepassword().equals(user.getPassword()))) {
			throw new CMSException("两次密码输入不一致");
		}
		//给user对象初始化
		user.setPassword(Md5Util.jiami(user.getPassword()));
		user.setCreated(new Date());
		user.setLocked("0");
		user.setNickname(user.getUsername());
		return dao.insert(user);
	}

	@Override
	public User login(User formUser) {
		 if(!StringUtil.hasText(formUser.getUsername())) {
			 throw new CMSException("用户名不能为空");
		 }
		 User u=dao.selectByUserName(formUser.getUsername());
		 if (null == u) {
				throw new CMSException("该用户名不存在");
			}
		 if(!Md5Util.jiami(formUser.getPassword()).equals(u.getPassword())) {
			 throw new CMSException("密码错误");
		 }
		 if(u.getLocked().equals("1")) {
			 throw new CMSException("当前账户被禁用");
		 }
		 
		return u;
	}

	@Override
	public Object selectByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.selectByUserName(username);
	}

}
