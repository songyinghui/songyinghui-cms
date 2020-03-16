package com.songyinghui.cms.service;

import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.Article;
import com.songyinghui.cms.bean.Comment;

public interface CommentService {

	PageInfo<Comment> selects(Article article, Integer page, Integer pageSize);

	int insert(Comment comment);

}
