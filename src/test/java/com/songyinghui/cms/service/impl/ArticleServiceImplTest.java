package com.songyinghui.cms.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.Article;
import com.songyinghui.cms.service.ArticleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class ArticleServiceImplTest {
  @Autowired
  ArticleService service;
	@Test
	public void testInsert() {
		Article article = new Article();
		article.setTitle("蜜汁");
		article.setContent("aaaaaaaaaa");
		article.setChannelId(1);
		article.setCategoryId(1);
		article.setUserId(1);
		article.setHits(1);
		service.insert(article);
	}

	@Test
	public void testSelects() {
		 PageInfo<Article> selects = service.selects(null, 1, 5);
		 System.out.println(selects.getList());
	}

}
