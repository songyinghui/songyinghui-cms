package com.songyinghui.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.Article;
import com.songyinghui.cms.dao.ArticleDao;
import com.songyinghui.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao dao;

	public int insert(Article article) {
		// TODO Auto-generated method stub
		return dao.insert(article);
	}
	@Override
	public PageInfo<Article> selects(Article article,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
	    PageHelper.startPage(pageNum, pageSize);
	    List<Article> list=dao.selects(article);
		return new PageInfo(list);
	}
	@Override
	public Article articleDetail(Integer id) {
		// TODO Auto-generated method stub
		return dao.articleDetail(id);
	}
	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return dao.update(article);
	}
	@Override
	public Article getOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}
	@Override
	public void updateCommentNum(Integer articleId) {
		// TODO Auto-generated method stub
		dao.updateCommentNum(articleId);
	}
	@Override
	public PageInfo<Article> selects(int i, int j) {
		// TODO Auto-generated method stub
		PageHelper.startPage(i, j);
		List<Article> list=dao.selectsByCommentNum();
		return new PageInfo<Article>(list);
	}
	@Override
	public boolean updateHit(Integer id) {
		// TODO Auto-generated method stub
		return dao.updateHit(id);
	}

	

}
