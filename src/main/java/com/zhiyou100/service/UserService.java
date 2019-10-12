package com.zhiyou100.service;

import java.util.List;
import java.util.Map;
import com.zhiyou100.model.User;

/**
* @author Rain
* @des:
* 创建时间：2019年9月7日 下午6:09:15
*/
public interface UserService {
	
	int count(Map map);
	void updateUser(User user);
	// 分页插件 pageHelper
	List<User> findAllUser(Map map);
	

	User selectOne(int id);
	void deleteUser(int id);
	// 修改user_role的表内容
	void updateUser2(Map map);
	// 批量删除user_role表
	int deleteMoreUser(List<Integer> list);
	// 批量删除user表
	int deleteMoreUser2(List<Integer> list);
	// 插入user表
	void insertUser(User user);
	// 插入user_role表
	void insertUser2(Map map);
	// 根据用户名查一个用户ID
	int findIdByUserName(String user_name);

	
}
