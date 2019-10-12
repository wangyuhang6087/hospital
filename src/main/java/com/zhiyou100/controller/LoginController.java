package com.zhiyou100.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.model.Permission;
import com.zhiyou100.model.User;
import com.zhiyou100.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login.do")
	public String login(String username,String password,Model model){
	
		// 调用业务层方法,查询
		User user = loginService.findUserByLogin(username,password);
		System.out.println(user);		
		// 判断
		if(user != null) {
			Map<String,String> map = new HashMap<>();
			map.put("username", username);
			map.put("password", password);
			List<Permission> list = loginService.selectPermission(map);
			model.addAttribute("list", list);
			model.addAttribute("user", user);
			return "login";
		}
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/login.out")
	public String login() {
		return "redirect:index.jsp";
	}
}
