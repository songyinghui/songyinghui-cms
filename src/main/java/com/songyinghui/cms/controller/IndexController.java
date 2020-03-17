package com.songyinghui.cms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.songyinghui.cms.bean.Article;
import com.songyinghui.cms.bean.Category;
import com.songyinghui.cms.bean.Channel;
import com.songyinghui.cms.bean.Collect;
import com.songyinghui.cms.bean.Comment;
import com.songyinghui.cms.bean.Slide;
import com.songyinghui.cms.bean.User;
import com.songyinghui.cms.service.ArticleService;
import com.songyinghui.cms.service.ChannelService;
import com.songyinghui.cms.service.CollectService;
import com.songyinghui.cms.service.CommentService;
import com.songyinghui.cms.service.SlideService;
import com.songyinghui.cms.util.CMSException;

@Controller
public class IndexController {
	@Autowired
	private ChannelService service;
	@Autowired
	private ArticleService articleService;
    @Autowired
    private SlideService slideService;
    @Resource
	private CommentService commentService;
    @Autowired
    private CollectService collectService;
	@RequestMapping(value = { "", "/", "index" })
	public String index(Model model, Article article, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "5") Integer pageSize) {
		article.setStatus(1);
		article.setDeleted(0);
		List<Channel> channels = service.selects();
		model.addAttribute("article", article);

		model.addAttribute("channels", channels);
		if (article.getChannelId() != null) {
			List<Category> categorys = service.selectsByChannelId(article.getChannelId());
			model.addAttribute("categorys", categorys);
		}
		if(article.getChannelId()==null) {
			article.setHot(1);
			List<Slide> slides = slideService.selects();
			model.addAttribute("slides",slides);
		}
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		Article article2 = new Article();
		article2.setStatus(1);
		article2.setDeleted(0);
       PageInfo<Article> lastArticles = articleService.selects(article2, 1, 10);
       model.addAttribute("lastArticles", lastArticles);
		return "index/index";
	}

	@RequestMapping("articleDetail")
	public String getOne(HttpSession session,Integer id, Model model,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		 Article article = articleService.articleDetail(id);
		 model.addAttribute("article",article);
		 User user = (User) session.getAttribute("user");
		 PageInfo<Comment> info =commentService.selects(article,page,pageSize);
		 PageInfo<Article> info2=articleService.selects(1,10);
		 //查看当前文章是否被当前登录的用户收藏
		 Collect collect=null;
		 //判断用户非空
		 if(user!=null) {
			collect= collectService.select(article.getTitle(),user.getId());
		 }
		 model.addAttribute("info", info);
		 model.addAttribute("info2", info2);
		 model.addAttribute("collect",collect);
		return "index/inform";

	}
	@PostMapping("addComment")
	@ResponseBody
	public boolean addComment(Comment comment,Integer articleId,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(null ==user)
		return false;//没有登录的用户不能评论
		comment.setUserId(user.getId());
		comment.setArticleId(articleId);
		comment.setCreated(new Date());
		//添加评论后使article中的评论记录+1
		 articleService.updateCommentNum(articleId);
		return commentService.insert(comment)>0;
	}
	//添加收藏
	@RequestMapping("collect")
	@ResponseBody
	public boolean collect(Collect collect,HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		if(user==null) {
			return false;
		}
		collect.setUser_id(user.getId());
		return collectService.insert(collect)>0;
	}
	//删除收藏
	@RequestMapping("deleteCollect")
	@ResponseBody
	public boolean deleteCollect(Integer id) {
		return collectService.deleteCollect(id)>0;
	}
	@RequestMapping("updateHit")
	@ResponseBody
	public boolean updateHit(Integer id) {
		
		return articleService.updateHit(id);
		
	}
	
}
