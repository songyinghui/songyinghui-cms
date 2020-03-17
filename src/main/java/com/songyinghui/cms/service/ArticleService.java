package com.songyinghui.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.Article;

public interface ArticleService {
	/**
	 * 增加文章
	 */
	int insert(Article article);

	/**
	 * 查询
	 */
	PageInfo<Article> selects(Article article,Integer pageNum,Integer pageSize);

	Article articleDetail(Integer id);


	int update(Article article);

	Article getOne(Integer id);

	void updateCommentNum(Integer articleId);

	PageInfo<Article> selects(int i, int j);

	boolean updateHit(Integer id);
}
