package com.songyinghui.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.Article;
import com.songyinghui.cms.bean.Comment;
import com.songyinghui.cms.dao.CommentDao;
import com.songyinghui.cms.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
  @Autowired
  private CommentDao dao;
	@Override
	public PageInfo<Comment> selects(Article article, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		return new PageInfo<Comment>(dao.selects(article));
	}
	@Override
	public int insert(Comment comment) {
		// TODO Auto-generated method stub
		return dao.insert(comment);
	}

}
