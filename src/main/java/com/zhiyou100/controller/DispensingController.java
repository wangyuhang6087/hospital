package com.zhiyou100.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.DispensingService;

@Controller
@RequestMapping("/dispensing")
public class DispensingController {
	Dispensing dispensing = new Dispensing();
	@Autowired
	private DispensingService service;

	@RequestMapping("/index")
	public String findAllHospitalClear(Model model, @RequestParam(defaultValue = "1") int pageNo, @RequestParam Map keywordmap) {
	
		// 查找全部的数据条数 
		int total = service.count(keywordmap);
		// 在查询之前使用pagehelper 
		PageHelper.startPage(pageNo, 3);
		//  登录成功,展现全部用户 
		List<Dispensing> lists = service.findAllDispensing(keywordmap);
		PageInfo<Dispensing> pageInfo = new PageInfo<>(lists);
		
		model.addAttribute("lists", pageInfo.getList());		
		System.out.println("分页信息:  " + pageInfo);		
		for (Dispensing dispensing : pageInfo.getList()) {
		// 查询出来的结果信息
			System.err.println(dispensing);
		}
		
		model.addAttribute("map", keywordmap);
		model.addAttribute("page", pageInfo);
		model.addAttribute("total", total);
		return "/dispensing/index";
	}
	
	
	// 批量删除
		@RequestMapping(value = "/sendMore", method = RequestMethod.POST)// id == medical_record
		public String sendMoreDispensing(@RequestParam(defaultValue = "")String[] id,Model model) {
			// 记得判断
			if(id.length != 0 && id != null) {
				List<Object> listName = new ArrayList<>();
				for (String string2 : id) {
					RegistrationInfor  id2 = service.findNameById(string2);
					listName.add(id2.getName());
				}
				System.err.println(Arrays.toString(id));
				System.err.println(listName);
				model.addAttribute("id", Arrays.toString(id));
				model.addAttribute("name", listName);
				return "/dispensing/dispensing-gives";
			}		
			return "forward:/dispensing/index";
		}
	
		
		@RequestMapping(value = "/sendDrugs", method = RequestMethod.GET)
		public String lookHospitalClear(Dispensing dispensing,Model model,String id) {
			String drug_num = dispensing.getDrug_num(); // 发药编号
			Integer dispens_num = dispensing.getDispens_num();// 发药数量
			Map<Object,Object> map = new HashMap<>();
			
			int num = service.checkDrug(drug_num);
			System.out.println("未发药的余量为: " + num);
			// id === 病历号
			System.err.println("id为 : " + id);
			String[] split = id.split(",");
			int x = split.length;
			map.put("surplus", (num-dispens_num*x));
			map.put("drug_num", drug_num);
			if(dispens_num*x>num) {
				model.addAttribute("msg", "药品余量不足,操作失败");
				return "/dispensing/dispensing-gives";
			}
			service.alterDrug(map);
			// 更改dispensing表的发药数量
			//  id..
			System.err.println(id.length());
			 id = id.substring(1, id.length()-1);
			System.err.println(id);
		return "/dispensing/index";
	}	
	
}

	
		

