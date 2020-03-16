package com.songyinghui.cms.dao;

import java.util.List;

import com.songyinghui.cms.bean.Article;
import com.songyinghui.cms.bean.Comment;

public interface CommentDao {

	List<Comment> selects(Article article);

	int insert(Comment comment);

}
