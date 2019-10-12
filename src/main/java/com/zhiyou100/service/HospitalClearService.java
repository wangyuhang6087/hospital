package com.zhiyou100.service;
import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;


public interface HospitalClearService {
	
	
	 void deleteHospitalClear(String id);
	
	 int count(Map map);
	// 批量删除
	int deleteMoreHospitalClear(List list);
		
	// 分页插件 pageHelper
	 List<HospitalClear> findAllHospitalClear(Map map);
/*	
	// List<Section> selectSection();
	*/	
	List<RegistrationInfor> selectOne(String id);
	
	void updateRegistrationInfor(RegistrationInfor r);
    void updateHospitalInfor(HospitalInfor hi);
    
    void insertHospitalInfor(HospitalInfor h);

	int find(String medical_record);
}
