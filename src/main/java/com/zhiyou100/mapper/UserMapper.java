package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;
import com.zhiyou100.model.User;

/**
* @author Rain
* @des:
* 创建时间：2019年9月7日 下午6:08:14
*/
public interface UserMapper {
	List<User> findAllUser(Map map);
    int count(Map map);
    void updateUser(User user);
    User selectOne(int id);
	int deleteUser(int id);
	void updateUser2(Map map);
	int deleteMoreUser(List<Integer> list);
	int deleteMoreUser2(List<Integer> list);
	void insertUser(User user);
	void insertUser2(Map map);
	int findIdByUserName(String user_name);
}
