package com.songyinghui.cms.dao;

import java.util.List;

import com.songyinghui.cms.bean.Article;

public interface ArticleDao {
	/**
	 * 增加文章
	 */
	int insert(Article article);

	/**
	 * 查询
	 */
	List<Article> selects(Article article);

	Article articleDetail(Integer id);

	int update(Article article);

	Article getOne(Integer id);

	void updateCommentNum(Integer articleId);

	List<Article> selectsByCommentNum();

	boolean updateHit(Integer id);
}
