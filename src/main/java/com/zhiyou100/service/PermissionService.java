package com.zhiyou100.service;
import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Dispensing;
import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.Permission;
import com.zhiyou100.model.RegistrationInfor;


public interface PermissionService {
	
	
	
	// 分页插件 pageHelper
	 List<Permission> findAllPermission(Map map);
	 int count(Map map);
	void insertPermission(Permission permission);
	int deleteMorePermission(List<Object> list);
	void deletePermission(int id);
	Permission selectOne(int id);
	void updatePermission(Permission permission);
	
}
