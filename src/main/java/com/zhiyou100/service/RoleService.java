package com.zhiyou100.service;
import java.util.List;
import java.util.Map;
import com.zhiyou100.model.Doctor;
import com.zhiyou100.model.Role;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:31:58
*/
public interface RoleService {
	
/*	void deleteUser(int id);
	*/
	int count(Map map);
	//void updateDoctor(Doctor doctor);
	// 分页插件 pageHelper
	List<Role> findAllRole(Map map);
	// 批量删除
	int deleteMoreRole (List list);
	//void insertDoctor(Doctor doctor);
	void deleteRole(int id);
	int insertLastId();
	void insertRolePermission(Map map);
	void insertRole(Role role);
	Role selectOneById(int id);
	
	
	
	
}
