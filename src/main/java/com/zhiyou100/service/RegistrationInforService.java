package com.zhiyou100.service;
import java.util.List;
import java.util.Map;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.model.Section;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:31:58
*/
public interface RegistrationInforService {
	
	
	 void deleteRegistrationInfor(String id);
	
	int count(Map map);
	 void updateRegistrationInfor(RegistrationInfor registrationInfor);
	// 分页插件 pageHelper
	 List<RegistrationInfor> findAllRegistrationInfor(Map map);
	// 批量删除
	int deleteMoreRegistrationInfor(List list);
	void insertRegistrationInfor(RegistrationInfor registrationInfor);
	// List<Section> selectSection();

	List<RegistrationInfor>  selectOne(String id);
	RegistrationInfor findOne(String id);
	

	
	
	
}
