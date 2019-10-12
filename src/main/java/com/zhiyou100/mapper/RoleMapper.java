package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Doctor;
import com.zhiyou100.model.Role;
import com.zhiyou100.model.User;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:38:03
*/
public interface RoleMapper {
    List<Role> findAllRole(Map map);
    int count(Map map);
    void deleteRole(int id);
    int deleteMoreRole(List list);
    int insertLastId();
	void insertRolePermission(Map map);
	void insertRole(Role role);
	Role selectOneById(int id);
}
