package com.songyinghui.cms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songyinghui.cms.bean.User;
import com.songyinghui.cms.service.UserService;
import com.songyinghui.cms.util.CMSException;
import com.songyinghui.cms.util.Result;

@Controller
@RequestMapping("passport")
public class PassportController {
	@Autowired
	UserService service;

	@RequestMapping("reg")
	public String reg() {
		return "passport/reg";
	}

	@PostMapping("reg")
	@ResponseBody
	public Result<User> reg(User user,Model model) {
		Result<User> result = new Result<User>();
		try {
			 if(service.insert(user)>0) {//说明无误
				 result.setCode(200);
				 result.setMsg("注册成功");
			 }
		} catch (CMSException e) {
			 result.setCode(300);
			 result.setMsg(e.getMessage());
		}catch (Exception e) {
			 result.setCode(500);
			 result.setMsg("未知错误");
		}
		return result;
	}
	@RequestMapping("login")
	public String log() {
		return "passport/login";
	}
	@PostMapping("login")
	@ResponseBody
	public Result<User> login(HttpSession session,User formUser){
		Result<User> result = new Result<User>();
		try {
			 User user=service.login(formUser);
			 if(user!=null) {
				 result.setCode(200);
				 result.setMsg("登录成功");
				 if(user.getRole()==0) {
					 session.setAttribute("user",user);
				 }else {
					 session.setAttribute("admin",user);
				 }
			 }
		} catch (CMSException e) {
			 result.setCode(300);
			 result.setMsg("登录失败"+e.getMessage());
		}catch (Exception e) {
			 result.setCode(500);
			 e.printStackTrace();
		}
		return result; 
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	@ResponseBody
	@PostMapping("checkName")
public boolean checkName(String username) {
		 
		return service.selectByUsername(username) == null;
		
	}
	@RequestMapping("admin")
	public String adminLogin() {
		return "/passport/adminLogin";
	}
}
