package com.zhiyou100.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:32:09
 *
 * 
*/

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;
	public List<User> findAllUser(Map map) {
	
		return 	mapper.findAllUser(map);
	}
	
	public int count(Map map) {
		
		return mapper.count(map);
	}	
	public User selectOne(int id) {
		 return mapper.selectOne(id);
	}
	

	public void updateUser(User user) {
		mapper.updateUser(user); 
	}

	@Override
	public void deleteUser(int id) {
		
		 mapper.deleteUser(id);
		
	}
	
	public void insertUser(User user) {
		mapper.insertUser(user);
		
	}

	@Override
	public void updateUser2(Map map) {
		mapper.updateUser2(map);
	}
	
	@Override
	public int deleteMoreUser(List<Integer> list) {
		
		return mapper.deleteMoreUser(list);
	}

	@Override
	public int deleteMoreUser2(List<Integer> list) {
		
		return mapper.deleteMoreUser2(list);
	}

	@Override
	public void insertUser2(Map map) {
		mapper.insertUser2(map);
		
	}

	@Override
	public int findIdByUserName(String user_name) {
		
		return mapper.findIdByUserName(user_name);
	}
}
