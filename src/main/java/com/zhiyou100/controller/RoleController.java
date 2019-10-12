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
import com.zhiyou100.model.Role;
import com.zhiyou100.service.RoleService;

/**
* @author Rain
* @des:
* 创建时间：2019年9月16日 上午9:21:37
*/
@Controller
@RequestMapping("/role")
public class RoleController {
	Role role = new Role();
	@Autowired
	private RoleService service;

	@RequestMapping("/index")
	public String findAllRole(Model model, @RequestParam(defaultValue = "1") int pageNo, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		/* 查找全部的数据条数 */
		int total = service.count(map);
		/* 在查询之前使用pagehelper */
		PageHelper.startPage(pageNo, 3);
		/* 登录成功,展现全部用户 */
		List<Role> lists = service.findAllRole(map);
		PageInfo<Role> pageInfo = new PageInfo<>(lists);
		model.addAttribute("lists", pageInfo.getList());
		System.out.println(pageInfo);
		
		for (Role role : pageInfo.getList()) {
			pageInfo.getList();
			System.out.println(role);
		}
		
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		model.addAttribute("total", total);
		return "/role/index";
	}
	

	// 只适用于跳转页面 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAddUI() {
		return "/role/addRole";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertRole(Role role,int[] group) {
		
		service.insertRole(role);
		// role_id ==> id
		int id = service.insertLastId();
		System.err.println("/****/" + id);
		
		// 权限id
		for (int i : group) {
			Map<Object,Object> map = new HashMap<>();
			map.put("id", id);
			map.put("permission", i);
			service.insertRolePermission(map);
		}

		return "forward:/role/index";		
	}
	
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteRole(int id) { 
		service.deleteRole(id);
		return "forward:/role/index";
	}
	
	// 批量删除
		@RequestMapping(value = "/deleteMore", method = RequestMethod.POST)
		public String deleteMoreRole(@RequestParam(defaultValue = "")String[] id) {
			// 记得判断
			if(id.length != 0 && id != null) {
				List<Object> list = new ArrayList<>();
				for (String string : id) {
					list.add(string);
				}
				System.err.println("被选中的编号为: " + list);
			    int deleteMoreRole = service.deleteMoreRole(list);
			    System.err.println("批量删除的条数为: " + deleteMoreRole);
			    return "forward:/role/index";		
			}
			
			return "forward:/role/index";
		}
		
		
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public String updateRole(int id,Model model) {
			
		Role role = service.selectOneById(id);

		model.addAttribute("role", role);
		
			
			return "/role/editRole";
		}

		/*@RequestMapping(value = "/edit", method = RequestMethod.POST)
		public String updateRole(Role role) {
			
			System.out.println(1/0);
			
			return "/role/index";
		}
*/
	
	
/*	

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(int id) {
		service.deleteUser(id);
		return "forward:/user/list";
	}
}*/

}

