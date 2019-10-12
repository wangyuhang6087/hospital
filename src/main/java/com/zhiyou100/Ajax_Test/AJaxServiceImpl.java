package com.zhiyou100.Ajax_Test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhiyou100.model.Doctor;
import com.zhiyou100.model.User;

/**
* @author Rain
* @des:
* 创建时间：2019年9月18日 上午11:30:56
*/
@Service
public class AJaxServiceImpl implements AJaxService{

	@Override
	public String checkUser(String usernameJsonkey) {
		/*
		 * 只有用户名不是admin时可以注册
		 */
		String  code = null;
		if(usernameJsonkey == null || usernameJsonkey == "" || usernameJsonkey == "admin") {
			// 已注册 ,返回404
			code = "{\"code\":\"404\"}";
		}else {
			// 未注册,可以注册,返回200
			code = "{\"code\":\"200\"}";
		}
		System.out.println("业务层输出返回的结果是: " + code);
		
		return code;
	}
	
	@Override
	public ResponseObject checkUser2(String usernameJsonkey) {
		/*
		 * 只有用户名不是admin时可以注册
		 */
		ResponseObject obj = new ResponseObject();
		String  code = null;
		if(usernameJsonkey == null || usernameJsonkey == "" || usernameJsonkey == "admin") {
			obj.setCode("404");
			obj.setMessage("不允许注册");
		}else {
			obj.setCode("200");
			obj.setMessage("可以注册");
		}
		System.out.println("业务层输出返回的结果是: " + code);
		
		return obj;
	}

	@Override
	public ResponseObject findUserById(String id) {
		User user = new User();
		user.setUser_name("zhangsan");
		user.setPassword("12121");
		user.setEmail("41545@qq.com");
		ResponseObject obj = new ResponseObject("200","成功",user);
		return obj;
	}

	@Override
	public ResponseObject findDoctorBySectionId(String sectionId) {
		List<Doctor> doctors = new ArrayList<Doctor>();
		if(sectionId.equals("1")) {
			doctors.add(new Doctor("k1张三"));
			doctors.add(new Doctor("k1李四"));
			doctors.add(new Doctor("k1王五"));
		}else if(sectionId.equals("2")) {
			doctors.add(new Doctor("k2张三"));
			doctors.add(new Doctor("k2李四"));
			doctors.add(new Doctor("k2王五"));
		}else if(sectionId.equals("3")) {
			doctors.add(new Doctor("k3张三"));
			doctors.add(new Doctor("k3李四"));
			doctors.add(new Doctor("k3王五"));
		}else {
			System.out.println("id错误");
		}
		
		return new ResponseObject("200","成功",doctors);
	}
	
	
	
}
