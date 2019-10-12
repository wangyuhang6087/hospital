package com.zhiyou100.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.PermissionMapper;
import com.zhiyou100.mapper.RegistrationInforMapper;
import com.zhiyou100.model.Permission;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private  PermissionMapper mapper;
	
	public List<Permission> findAllPermission(Map map) {
	
		return 	mapper.findAllPermission(map);
	}
	
	public int count(Map map) {
		
		return mapper.count(map);
	}

	@Override
	public void insertPermission(Permission permission) {
		mapper.insertPermission(permission);
		
	}

	@Override
	public int deleteMorePermission(List<Object> list) {
		
		return mapper.deleteMorePermission(list);
	}

	@Override
	public void deletePermission(int id) {
		mapper.deletePermission(id);
		
	}

	@Override
	public Permission selectOne(int id) {
		
		return mapper.selectOne(id);
	}

	@Override
	public void updatePermission(Permission permission) {
		mapper.updatePermission(permission);
		
	}	
}
