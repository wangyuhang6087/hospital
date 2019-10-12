package com.zhiyou100.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyou100.mapper.DoctorMapper;
import com.zhiyou100.model.Doctor;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:32:09
 *
 * 
*/

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorMapper mapper;
	public List<Doctor> findAllDoctor(Map map) {
	
		return 	mapper.findAllDoctor(map);
	}
	
	public int count(Map map) {
		
		return mapper.count(map);
	}	
	
	public void insertDoctor(Doctor doctor) {
		mapper.insertDoctor(doctor);
		
	}

	public void updateDoctor(Doctor doctor) {
		mapper.updateDoctor(doctor); 
	}
	@Override
	public int deleteMoreDoctor(List list) {
		return mapper.deleteMoreDoctor(list);
	}

	@Override
	public Doctor selectOne(int id) {
		
		return mapper.selectOne(id);
	}

	@Override
	public List<Doctor> findDoctorByIds(List<Object> list) {
		
		return mapper.findDoctorByIds(list);
	}

}
