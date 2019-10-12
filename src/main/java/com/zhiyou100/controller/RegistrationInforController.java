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
import com.zhiyou100.model.Doctor;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.RegistrationInforService;

@Controller
@RequestMapping("/reginf")
public class RegistrationInforController {
	RegistrationInfor reginf = new RegistrationInfor();
	@Autowired
	private RegistrationInforService service;

	@RequestMapping("/index")
	public String findAllRegistrationInfor(Model model, @RequestParam(defaultValue = "1") int pageNo, @RequestParam Map keywordmap) {
	    /*Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);*/
		
		// 查找全部的数据条数 
		int total = service.count(keywordmap);
		// 在查询之前使用pagehelper 
		PageHelper.startPage(pageNo, 3);
		//  登录成功,展现全部用户 
		List<RegistrationInfor> lists = service.findAllRegistrationInfor(keywordmap);
		PageInfo<RegistrationInfor> pageInfo = new PageInfo<>(lists);
		
		model.addAttribute("lists", pageInfo.getList());		
		System.out.println("分页信息:  " + pageInfo);		
		for (RegistrationInfor registrationInfor : pageInfo.getList()) {
		// 查询出来的结果信息
			System.err.println(registrationInfor);
		}
		
		model.addAttribute("map", keywordmap);
		model.addAttribute("page", pageInfo);
		model.addAttribute("total", total);
		return "/registration/index";
	}
	
	//  只适用于跳转页面 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAddUI(Model model) {
		
	  /*List<Section> list = service.selectSection();
		System.err.println(list);
		model.addAttribute("list",list);*/
		return "/registration/add";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertRegistrationInfor(RegistrationInfor registrationInfor) {
		
		service.insertRegistrationInfor(registrationInfor);
		System.err.println(registrationInfor);
		return "forward:/reginf/index";
		
	}
	
	
	// 批量删除
		@RequestMapping(value = "/deleteMore", method = RequestMethod.POST)
		public String deleteMoreRegistrationInfor(@RequestParam(defaultValue = "")String[] id) {
			// 记得判断
			if(id.length != 0 && id != null) {
				List<Object> list = new ArrayList<>();
				for (String string : id) {
					list.add(string);
				}
				
				System.err.println("被选中的编号为: " + list);
				service.deleteMoreRegistrationInfor(list);
				return "forward:/reginf/index";
			}
			
			return "forward:/reginf/index";
		}
	
		
		
		@RequestMapping(value = "/look", method = RequestMethod.GET)
		public String updateUser(String id,Model model) {
			RegistrationInfor r1 = new RegistrationInfor();
			List<RegistrationInfor> list = service.selectOne(id);
			for (RegistrationInfor registrationInfor2 : list) {
				r1 = registrationInfor2;
			}
			
			model.addAttribute("reg", r1);
			
			return "/registration/look";
		}
		// 更改
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public String detailRegistrationInfor(String id, Model model) {
			
			RegistrationInfor registrationInfor = service.findOne(id);
			model.addAttribute("reg", registrationInfor);
			
			return "/registration/edit";
		}
		
		
		@RequestMapping(value = "/edit", method = RequestMethod.POST)
		public String updateRegistrationInfor(RegistrationInfor registrationInfor) {
			
			service.updateRegistrationInfor(registrationInfor);
			
			 return "forward:/reginf/index";
			
		}
		
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String deleteRegistrationInfor(String id) {
			service.deleteRegistrationInfor(id);
			return "forward:/reginf/index";
		}	
		
}		
		

