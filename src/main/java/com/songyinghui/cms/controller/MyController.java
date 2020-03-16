package com.songyinghui.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.Article;
import com.songyinghui.cms.bean.User;
import com.songyinghui.cms.service.ArticleService;

@RequestMapping("my")
@Controller
public class MyController {
	@Autowired
	private ArticleService service;

	@RequestMapping(value = { "", "/", "index" })
	public String index() {
		return "my/index";
	}

	@RequestMapping("articles")
	public String articles(Article article,Model model,HttpSession session,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		
		
		PageInfo<Article> info = service.selects(article, page, pageSize);
		
		model.addAttribute("info", info);
		return "my/articles";
	}

	@RequestMapping("publish")
	public String publish() {
		return "my/publish";
	}

	@ResponseBody
	@PostMapping("publish")
	public boolean publish(MultipartFile file, Article article,HttpSession session) throws IllegalStateException, IOException {
		if (null != file && !file.isEmpty()) {
			String path = "d:/pic/";
			// 文件原始名
			String originalFilename = file.getOriginalFilename();
			// 文件的新名字
			String newName = UUID.randomUUID().toString()
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			File f = new File(path, newName);
			file.transferTo(f);
			article.setPicture(newName);
		}
		// 文章初始数据
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		article.setCreated(new Date());
		article.setHits(0);// 点击量默认 0
		article.setDeleted(0);// 默认未删除
		article.setHot(0);// 默认非热门
		article.setStatus(0);// 默认待审核
		System.out.println(article);
		
		return service.insert(article) > 0;
	}
	@RequestMapping("articleDetail")
	@ResponseBody
	public Article articleDetail(Integer id) {
		return service.articleDetail(id);
		
	}
}
