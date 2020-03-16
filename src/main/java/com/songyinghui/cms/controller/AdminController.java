package com.songyinghui.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.Article;
import com.songyinghui.cms.bean.User;
import com.songyinghui.cms.service.ArticleService;
import com.songyinghui.cms.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private ArticleService service; 
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "", "/", "index" })
	public String index() {
		return "/admin/index";
	}

	@RequestMapping("articles")
	public String articles(Model model, Article article, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "5") Integer pageSize) {
		PageInfo<Article> info = service.selects(article, pageNum, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("article", article);
		return "admin/articles";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public boolean update(Article article) {
		return service.update(article) > 0;
	}
	@RequestMapping("articleDetail")
	@ResponseBody
	public Article getOne(Integer id) {
		return service.getOne(id);
	}
	@RequestMapping("users")
	public String users(Model model,User user,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "5")Integer pageSize) {
		user.setRole(0);
		PageInfo<User> info = userService.userList(user,page,pageSize);
		model.addAttribute("info",info);
		model.addAttribute("user",user);
		return "admin/users";
	}
	@RequestMapping("updateUser")
	@ResponseBody
	public boolean updateUser(User user) {
		return userService.update(user)>0;
	}
}
