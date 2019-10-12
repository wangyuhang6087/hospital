package com.zhiyou100.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Array;
import com.zhiyou100.model.Dispensing;
import com.zhiyou100.model.Doctor;
import com.zhiyou100.model.Permission;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.DispensingService;
import com.zhiyou100.service.PermissionService;

@Controller
@RequestMapping("/resource")
public class PermissionController {
	Permission permission = new Permission();
	@Autowired
	private PermissionService service;

	@RequestMapping("/index")
	public String findAllPermission(Model model, @RequestParam(defaultValue = "1") int pageNo, @RequestParam Map keywordmap) {
	
		// 查找全部的数据条数 
		int total = service.count(keywordmap);
		// 在查询之前使用pagehelper 
		PageHelper.startPage(pageNo, 3);
		//  登录成功,展现全部用户 
		List<Permission> lists = service.findAllPermission(keywordmap);
		PageInfo<Permission> pageInfo = new PageInfo<>(lists);
		
		model.addAttribute("lists", pageInfo.getList());		
		System.out.println("分页信息:  " + pageInfo);		
		for (Permission permission : pageInfo.getList()) {
		// 查询出来的结果信息
			System.err.println(permission);
		}
		
		model.addAttribute("map", keywordmap);
		model.addAttribute("page", pageInfo);
		model.addAttribute("total", total);
		return "/resource/index";
	}
	// 只适用于跳转页面 
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String toAddUI() {
			return "/resource/add";
		}

		@RequestMapping(value = "/add", method = RequestMethod.POST)
		public String insertRole(Permission permission) {

			service.insertPermission(permission);	
			return "forward:/resource/index";
			
		}
		// 批量删除
		@RequestMapping(value = "/deleteMore", method = RequestMethod.POST)
		public String deleteMorePermission(@RequestParam(defaultValue = "")String[] id) {
			// 记得判断
			if(id.length != 0 && id != null) {
				List<Object> list = new ArrayList<>();
				for (String string : id) {
					list.add(string);
				}
				System.err.println("被选中的编号为: " + list);
			    int deleteMorePermission = service.deleteMorePermission(list);
			    System.err.println("批量删除的条数为: " + deleteMorePermission);
			    return "forward:/resource/index";		
			}
			
			return "forward:/resource/index";
		}
		
			@RequestMapping(value = "/delete", method = RequestMethod.GET)
			public String deletePermission(int id) {
				service.deletePermission(id);
				return "forward:/resource/index";
		}	
		
		
			@RequestMapping(value = "/edit", method = RequestMethod.GET)
			public String detailPermission(int id, Model model) {
				Permission permission = service.selectOne(id);
				model.addAttribute("permission", permission);
				return "/resource/edit";
			}

			@RequestMapping(value = "/edit", method = RequestMethod.POST)
			public String updatePermission(Permission permission) {
				service.updatePermission(permission);
				return "forward:/resource/index";
			}
			
			
}

	
		

