package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Dispensing;
import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.Permission;
import com.zhiyou100.model.RegistrationInfor;


/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:38:03
*/
public interface PermissionMapper {
    List<Permission> findAllPermission(Map map);
    int count(Map map);
    int deleteMorePermission(List<Object> list);
	void insertPermission(Permission permission);
	void deletePermission(int id);
	Permission selectOne(int id);
	void updatePermission(Permission permission);
}
