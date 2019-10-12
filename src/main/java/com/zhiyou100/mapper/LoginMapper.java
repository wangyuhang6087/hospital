package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Permission;
import com.zhiyou100.model.User;

public interface LoginMapper {
	User findUserByLogin(Map<String, String> map);
	List<Permission> selectPermission(Map<String, String> map);
}
