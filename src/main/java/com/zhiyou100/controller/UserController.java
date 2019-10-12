package com.zhiyou100.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;

/**
 * @author 说明: 创建时间：2019年9月3日 下午4:31:35
 */
@Controller
@RequestMapping("/user")
public class UserController {
	User user = new User();
	@Autowired
	private UserService service;

	@RequestMapping("/index")
	public String findAllUser(Model model, @RequestParam(defaultValue = "1") int pageNo, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		/* 查找全部的数据条数 */
		int total = service.count(map);
		/* 在查询之前使用pagehelper */
		PageHelper.startPage(pageNo, 3);
		/* 登录成功,展现全部用户 */
		List<User> lists = service.findAllUser(map);
		PageInfo<User> pageInfo = new PageInfo<>(lists);
	
		model.addAttribute("lists", pageInfo.getList());
		System.out.println(pageInfo);
		for (User user : pageInfo.getList()) {
			pageInfo.getList();
			System.out.println(user);
		}
		
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		model.addAttribute("total", total);
		
		System.out.println(total);
		return "/user/index";
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String detailUser(int id, Model model) {
		User user = service.selectOne(id);
		
		System.out.println("iddddddddddddddddd" + id);
		System.out.println(user);
		
		model.addAttribute("user", user);
		return "/user/edit";
	}	

	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateUser(User user,String role_num) {
		
		System.out.println("*************" + role_num);
		// 接受了一个 role_num  角色代码  .......
		// user_role表更新数据
		Map<Object,Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("role_num", role_num);
		// 更新user_role表的数据
		service.updateUser2(map);
		// 更新user表的数据
		service.updateUser(user);
		return "forward:/user/index";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(int id) {  // 修改状态码为0
		service.deleteUser(id);
		
		return "forward:/user/index";
	}
	
	// 只适用于跳转页面 
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String toAddUI() {
			return "/user/add";
		}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertUser(User user,String role_num) {
		System.out.println("插入的user数据为:　" + user);
		// 插入user表
		service.insertUser(user);
		// 插入后 查一下被插入用户的ID
		int id = service.findIdByUserName(user.getUser_name());
		// 插入user_role表格
		Map<Object,Object> map = new HashMap<>();
		map.put("id", id);   // null
		map.put("role_num", role_num);
		service.insertUser2(map);
		return "forward:/user/index";
	}	
	// 批量删除
	@RequestMapping(value = "/deleteMore", method = RequestMethod.POST)
	public String deleteMoreUser(@RequestParam(defaultValue = "")int [] id) {
		// 记得判断
		if(id.length != 0 && id != null) {
			List<Integer> list = new ArrayList<>();
			for (Integer integer : id) {
				list.add(integer);
			}
			System.err.println("被选中的编号为: " + list);
			// 删除user_role表
			int deleteMoreUser= service.deleteMoreUser(list);
			System.out.println("user_role表,批量删除的条数为: " + deleteMoreUser );
			// 删除user表
			int deleteMoreUser2= service.deleteMoreUser2(list);
		    System.out.println("user表,批量删除的条数为: " + deleteMoreUser2 );
		    return "forward:/user/index";		
		}		
		return "forward:/user/index";
	}

}
