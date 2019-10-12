package com.zhiyou100.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyou100.mapper.DoctorMapper;
import com.zhiyou100.mapper.RoleMapper;
import com.zhiyou100.model.Doctor;
import com.zhiyou100.model.Role;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:32:09
 *
 * 
*/

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleMapper mapper;
	public List<Role> findAllRole(Map map) {
	
		return 	mapper.findAllRole(map);
	}
	
	public int count(Map map) {
		
		return mapper.count(map);
	}	
	public void deleteRole(int id) {
		mapper.deleteRole(id);
		
	}
	@Override
	public int deleteMoreRole(List list) {
		return mapper.deleteMoreRole(list);
	}
	
	
	public int insertLastId() {
		 return mapper.insertLastId();
	}

	@Override
	public void insertRolePermission(Map map) {
		mapper.insertRolePermission(map);
		
	}

	@Override
	public void insertRole(Role role) {
		mapper.insertRole(role);
	}

	@Override
	public Role selectOneById(int id) {
		
		return mapper.selectOneById(id);
	}

	
	
	/*public void insertRole(Role role) {
		mapper.insertRole(role);
		
	}*/
	/*
	

	
*/

	/*public void updateDoctor(Doctor doctor) {
		mapper.updateDoctor(doctor); 
	}
	

	
*/
}
