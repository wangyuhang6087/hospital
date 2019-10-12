package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Doctor;
import com.zhiyou100.model.User;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:38:03
*/
public interface DoctorMapper {
    List<Doctor> findAllDoctor(Map map);
    int count(Map map);
	int deleteMoreDoctor(List<Integer> list);
	void insertDoctor(Doctor doctor);
	Doctor selectOne(int id);
	void updateDoctor(Doctor doctor);
	List<Doctor> findDoctorByIds(List<Object> list);	
}
