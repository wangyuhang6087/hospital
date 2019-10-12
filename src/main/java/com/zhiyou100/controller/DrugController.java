package com.zhiyou100.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Drug;
import com.zhiyou100.service.DrugService;

@Controller
@RequestMapping("/medicine")
public class DrugController {
	Drug drug = new Drug();
	@Autowired
	private DrugService service;
	
	@RequestMapping("/index")			// drug_name  drug_type
	public String findAllDrug(Model model, @RequestParam(defaultValue = "1") int pageNo, @RequestParam Map keywordmap) {
	
		// 查找全部的数据条数 
		int total = service.count(keywordmap);
		// 在查询之前使用pagehelper 
		PageHelper.startPage(pageNo, 3);
		//  登录成功,展现全部用户 
		List<Drug> lists = service.findAllDrug(keywordmap);
		PageInfo<Drug> pageInfo = new PageInfo<>(lists);
		
		model.addAttribute("lists", pageInfo.getList());		
		System.out.println("分页信息:  " + pageInfo);		
		for (Drug drug : pageInfo.getList()) {
		// 查询出来的结果信息
			System.err.println(drug);
		}
		// 将关键字发送给index.jsp页面
		model.addAttribute("map", keywordmap);
		// 发送分页信息
		model.addAttribute("page", pageInfo);
		// 发送总条数  由 count方法得到的总条数
		model.addAttribute("total", total);
		
		return "/medicine/index";
	}
	
	//  只适用于跳转页面 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAddUI(Model model) {
		
		return "/medicine/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertDrug(Drug drug,String prodeced_date,int quality_date,
			@RequestParam("img")MultipartFile img,
			HttpServletRequest request
			) throws IOException {					
		long time = Date.valueOf(prodeced_date).getTime();// 生产日期,
		long m = Math.multiplyExact(3600*24, quality_date);// 保质期(天数)
		String expiration_date = new SimpleDateFormat("yyyy-MM-dd").format((time/1000 + m)*1000);
		System.err.println(expiration_date);
		// 添加过期时间
		drug.setExpiration_date(expiration_date);	
		
		String realPath = request.getServletContext().getRealPath("/drug");
		File file = new File(realPath);
		System.out.println(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
			 // 获得文件名
			 /* 文件名重复时不能够重复上传文件*/	
			 String fileName = img.getOriginalFilename();
			 // 拆分字符串  由 . 
			 String[] split = fileName.split("\\.");
			 // 获得后缀
			 String  suffix = split[1];
			 // 以当前毫秒值为文件名
			 long prefix = System.currentTimeMillis();
			 String prefix1 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒SS").format(prefix);
			 // 组装文件名
			 String newFileName = prefix1 +"."+ suffix;
			 System.out.println("新的文件名字 :　" +  newFileName);
			 System.out.println("文件名 : " + fileName);
			 // 确定上传路径			/upload /a.jsp
			 File newfile = new File(file,newFileName);
			 // 上传
			 FileUtils.writeByteArrayToFile(newfile, img.getBytes());
			 drug.setDrug_url("/drug/" + newFileName);
			 service.insertDrug(drug);
		return "forward:/medicine/index";	

}
	
	
	@RequestMapping(value = "/look", method = RequestMethod.GET)
	public String lookDrug(String id,Model model) {//id --> drug_num 
						
		Drug drug = service.findDrugById(id);
		model.addAttribute("drug", drug);
		System.out.println("查看的药的图片路径为: " + drug.getDrug_url());
		return "/medicine/look";
	}
	
	// 更改
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String detailRegistrationInfor(String id, Model model) {
		
		Drug drug = service.findDrugById(id);
		model.addAttribute("drug", drug);
		
		return "/medicine/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateDrug(Drug drug,String prodeced_date,int quality_date,MultipartFile img,HttpServletRequest request) throws IOException {
		
			System.err.println(drug);
			
			long time = Date.valueOf(prodeced_date).getTime();// 生产日期,
			long m = Math.multiplyExact(3600*24, quality_date);// 保质期(天数)
			String expiration_date = new SimpleDateFormat("yyyy-MM-dd").format((time/1000 + m)*1000);
			System.err.println(expiration_date);
			// 添加过期时间
			drug.setExpiration_date(expiration_date);	
			// 添加图片  // 2.gif
		
			String realPath = request.getServletContext().getRealPath("/drug");
			File file = new File(realPath);
			System.out.println(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
		 // 获得文件名
		 /* 文件名重复时不能够重复上传文件*/	
		 String fileName = img.getOriginalFilename();
		 // 拆分字符串  由 . 
		 String[] split = fileName.split("\\.");
		 // 获得后缀
		 String  suffix = split[1];
		 // 以当前毫秒值为文件名
		 long prefix = System.currentTimeMillis();
		 String prefix1 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒SS").format(prefix);
		 // 组装文件名
		 String newFileName = prefix1 +"."+ suffix;
		 System.out.println("新的文件名字 :　" +  newFileName);
		 System.out.println("文件名 : " + fileName);
		 // 确定上传路径			/upload /a.jsp
		 File newfile = new File(file,newFileName);
		 // 上传
		 FileUtils.writeByteArrayToFile(newfile, img.getBytes());
		 drug.setDrug_url("/drug/" + newFileName);

			service.updateDrug(drug);
		
		 return "forward:/medicine/index";
		
	}
	
	// 批量删除
		@RequestMapping(value = "/deleteMore", method = RequestMethod.POST)
		public String deleteMoreDrug(@RequestParam(defaultValue = "")String[] id) {
			// 记得判断
			if(id.length != 0 && id != null) {
				List<Object> list = new ArrayList<>();
				for (String string : id) {
					list.add(string);
				}	
				System.err.println("被选中的编号为: " + list);
				service.deleteMoreDrug(list);
				return "forward:/medicine/index";
			}
			return "forward:/medicine/index";
		}
}		
		


