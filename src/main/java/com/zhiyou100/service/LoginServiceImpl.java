package com.zhiyou100.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyou100.mapper.LoginMapper;
import com.zhiyou100.model.Permission;
import com.zhiyou100.model.User;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginMapper mapper;

	public User findUserByLogin(String username, String password) {
		Map<String,String> map = new  HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		User user = mapper.findUserByLogin(map);
		return user;
	}

	@Override
	public List<Permission> selectPermission(Map<String, String> map) {
		
		return mapper.selectPermission(map);
	}
	

}
