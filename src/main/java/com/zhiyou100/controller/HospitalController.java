package com.zhiyou100.controller;

import java.util.ArrayList;
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
import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.HospitalClearService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
	HospitalClear hospitalClear = new HospitalClear();
	@Autowired
	private HospitalClearService service;

	@RequestMapping("/index")
	public String findAllHospitalClear(Model model, @RequestParam(defaultValue = "1") int pageNo, @RequestParam Map keywordmap) {
	
		// 查找全部的数据条数 
		int total = service.count(keywordmap);
		// 在查询之前使用pagehelper 
		PageHelper.startPage(pageNo, 3);
		//  登录成功,展现全部用户 
		List<HospitalClear> lists = service.findAllHospitalClear(keywordmap);
		PageInfo<HospitalClear> pageInfo = new PageInfo<>(lists);
		
		model.addAttribute("lists", pageInfo.getList());		
		System.out.println("分页信息:  " + pageInfo);		
		for (HospitalClear hospitalClear : pageInfo.getList()) {
		// 查询出来的结果信息
			System.err.println(hospitalClear);
		}
		
		model.addAttribute("map", keywordmap);
		model.addAttribute("page", pageInfo);
		model.addAttribute("total", total);
		return "/hospital/index";
	}
	
	
	@RequestMapping(value = "/look", method = RequestMethod.GET)
	public String lookHospitalClear(String id,Model model) {
		// id ==> medical_record
		RegistrationInfor r1 = new RegistrationInfor();
			List<RegistrationInfor> list = service.selectOne(id);
			for (RegistrationInfor registrationInfor2 : list) {
				r1 = registrationInfor2;
			}
			model.addAttribute("reg", r1);
		
		return "/hospital/look";
	}

		// 更改
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String detailHospitalClear(String id, Model model) {
		RegistrationInfor r1 = new RegistrationInfor();
		List<RegistrationInfor> list = service.selectOne(id);
		for (RegistrationInfor registrationInfor2 : list) {
			r1 = registrationInfor2;
		}
		model.addAttribute("reg", r1);
			
		return "/hospital/edit";
	}
	
		
		@RequestMapping(value = "/edit", method = RequestMethod.POST)
		public String updateHospitalClear(RegistrationInfor r,HospitalInfor hi) {		
			service.updateRegistrationInfor(r);
			service.updateHospitalInfor(hi);		
			return "forward:/hospital/index";			
		}
		
		
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String toAddUI(Model model) {
			
		  /*List<Section> list = service.selectSection();
			System.err.println(list);
			model.addAttribute("list",list);*/
			return "/hospital/add";
		}
		
		@RequestMapping(value = "/add", method = RequestMethod.POST)
		public String insertHospitalClear(String medical_record,HospitalInfor hi) {
		
			int find = service.find(medical_record);
			System.err.println(find);	
		if(find !=0) {
				service.insertHospitalInfor(hi);	
				return "forward:/hospital/index";
			}
			return "forward:/hospital/index";		
		}
		
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String deleteHospitalClear(String id) {
			service.deleteHospitalClear(id);
			return "forward:/hospital/index";
		}	
		
		// 批量删除
		@RequestMapping(value = "/deleteMore", method = RequestMethod.POST)
		public String deleteMoreHospitalClear(@RequestParam(defaultValue = "")String[] id) {
			// 记得判断
			if(id.length != 0 && id != null) {
				List<Object> list = new ArrayList<>();
				for (String string : id) {
					list.add(string);
				}
				
				System.err.println("被选中的编号为: " + list);
				service.deleteMoreHospitalClear(list);
				return "forward:/hospital/index";
			}
			
			return "forward:/hospital/index";
		}

				
		
		
}

	
	/*
		*/
		
		
		

