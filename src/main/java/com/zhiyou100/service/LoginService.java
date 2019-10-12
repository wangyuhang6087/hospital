package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Permission;
import com.zhiyou100.model.User;

public interface LoginService {

	User findUserByLogin(String username, String password);

	List<Permission> selectPermission(Map<String, String> map);

}
