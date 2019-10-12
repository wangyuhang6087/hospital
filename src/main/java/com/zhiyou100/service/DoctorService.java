package com.zhiyou100.service;
import java.util.List;
import java.util.Map;
import com.zhiyou100.model.Doctor;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:31:58
*/
public interface DoctorService {
	
/*	
	void deleteUser(int id);
	User findUserById(int id);
	*/
	int count(Map map);
	void updateDoctor(Doctor doctor);
	// 分页插件 pageHelper
	 List<Doctor> findAllDoctor(Map map);
	// 批量删除
	int deleteMoreDoctor(List list);
	void insertDoctor(Doctor doctor);

	Doctor selectOne(int id);
	List<Doctor> findDoctorByIds(List<Object> list);
	

	
	
	
}
