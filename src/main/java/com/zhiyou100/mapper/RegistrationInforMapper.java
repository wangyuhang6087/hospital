package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.model.Section;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:38:03
*/
public interface RegistrationInforMapper {
    List<RegistrationInfor> findAllRegistrationInfor(Map map);
    int count(Map map);
	List<Section> selectSection();
	void insertRegistrationInfor(RegistrationInfor registrationInfor);
	void deleteRegistrationInfor(String id);
	int deleteMoreRegistrationInfor(List<String> list);
	List<RegistrationInfor> selectOne(String id);
	RegistrationInfor findOne(String id);
	void updateRegistrationInfor(RegistrationInfor registrationInfor);
}
