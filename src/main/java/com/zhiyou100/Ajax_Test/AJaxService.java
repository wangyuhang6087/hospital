package com.zhiyou100.Ajax_Test;
/**
* @author Rain
* @des:
* 创建时间：2019年9月18日 上午11:30:36
*/
public interface AJaxService {
	String checkUser(String usernameJsonkey);	
	ResponseObject checkUser2(String usernameJsonkey);	
	ResponseObject findUserById(String id);	
	ResponseObject findDoctorBySectionId(String id);	
}
