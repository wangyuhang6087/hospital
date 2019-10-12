package com.zhiyou100.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Doctor;
import com.zhiyou100.service.DoctorService;
import com.zhiyou100.util.ExcelUtil;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	Doctor doctor = new Doctor();
	@Autowired
	private DoctorService service;

	@RequestMapping("/index")
	public String findAllDoctor(Model model, @RequestParam(defaultValue = "1") int pageNo, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		/* 查找全部的数据条数 */
		int total = service.count(map);
		/* 在查询之前使用pagehelper */
		PageHelper.startPage(pageNo, 3);
		/* 登录成功,展现全部用户 */
		List<Doctor> lists = service.findAllDoctor(map);
		PageInfo<Doctor> pageInfo = new PageInfo<>(lists);
		model.addAttribute("lists", pageInfo.getList());
		System.out.println(pageInfo);
		
		for (Doctor doctor : pageInfo.getList()) {
			pageInfo.getList();
			System.out.println(doctor);
		}
		model.addAttribute("map", map);
		model.addAttribute("page", pageInfo);
		model.addAttribute("total", total);
		return "/doctor/index";
	}
	

	// 只适用于跳转页面 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAddUI() {
		return "/doctor/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertDoctor(Doctor doctor,String birther) {

		String format = new SimpleDateFormat("yyyy-HH-mm").format(new Date());
		 String[] split = format.split("-");
		 String year = "";
		 for (int i = 0; i < split.length; i++) {
			  year = split[0];
		 }
		 
		 String[] split2 = birther.split("-");
		 String year1 = "";
	    for (int i = 0; i < split2.length; i++) {
	    	year1 = split2[0];
		}  
		doctor.setAge(Integer.valueOf(year)-Integer.valueOf(year1));
		service.insertDoctor(doctor);	
		
		System.out.println(doctor);
		return "forward:/doctor/index";
		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String detailDoctor(int id, Model model) {
		Doctor doctor = service.selectOne(id);
		model.addAttribute("doctor", doctor);
		return "/doctor/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateDoctor(Doctor doctor,String birther) {
		
		String format = new SimpleDateFormat("yyyy-HH-mm").format(new Date());
		 String[] split = format.split("-");
		 String year = "";
		 for (int i = 0; i < split.length; i++) {
			  year = split[0];
		 }
		 
		 String[] split2 = birther.split("-");
		 String year1 = "";
	    for (int i = 0; i < split2.length; i++) {
	    	year1 = split2[0];
		}  
		doctor.setAge(Integer.valueOf(year)-Integer.valueOf(year1));
		service.updateDoctor(doctor);
		return "forward:/doctor/index";
	}
	
	@RequestMapping(value = "/look", method = RequestMethod.GET)
	public String detailUser(int id,Model model) {
		
		Doctor doctor = service.selectOne(id);
		model.addAttribute("doctor", doctor);
		
		return "/doctor/look";
	}
	
	
	@RequestMapping(value= "/exportExcel", method = RequestMethod.GET)
	public void exportExcel(@RequestParam(defaultValue = "")String id[],HttpServletRequest request,HttpServletResponse response) throws Exception {
		 List<Doctor> listDoctor  = null;
		if(id.length != 0 && id != null) {
			List<Object> list = new ArrayList<>();
			for (String string : id) {
				list.add(string);
			}
			System.err.println("*****获得的医生id为: " + list);
			listDoctor = service.findDoctorByIds(list);
		    System.err.println(listDoctor);
		}
		 //excel标题
		String[] title = {"编号","医生姓名","入院时间","所属科室"};
		//excel文件名				
        String fileName = "门诊医生信息表"+ new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis()).toString()+".xls";
        //sheet名
        String sheetName = "门诊医生信息表";
        String [][] content = new String[listDoctor.size()][];
        for (int i = 0; i < listDoctor.size(); i++) {
           
			content [i] = new String[title.length];
			Doctor doctor = listDoctor.get(i);
            content[i][0] = doctor.getId().toString();
            content[i][1] = doctor.getName().toString();
            content[i][2] = doctor.getTime().toString();
            content[i][3] = doctor.getSection().getSecco_name().toString();   
        }

        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        
      //响应到客户端
        this.setResponseHeader(response, fileName);
		OutputStream os = response.getOutputStream();
		wb.write(os);
		os.flush();
		os.close();
	}	

	//发送响应流方法
    public  void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	// 批量删除
	@RequestMapping(value = "/deleteMore", method = RequestMethod.POST)
	public String deleteMoreDoctor(@RequestParam(defaultValue = "")String[] id) {
		System.err.println("批量删除的id为: " + Arrays.toString(id));
		// 记得判断
		if(id.length != 0 && id != null) {
			List<Object> list = new ArrayList<>();
			for (String string : id) {
				list.add(string);
			}
			System.err.println("被选中的编号为: " + list);
		    int deleteMoreDoctor = service.deleteMoreDoctor(list);
		    System.err.println("批量删除的条数为: " + deleteMoreDoctor);
		    return "forward:/doctor/index";		
		}
		return "forward:/doctor/index";
	}

}
