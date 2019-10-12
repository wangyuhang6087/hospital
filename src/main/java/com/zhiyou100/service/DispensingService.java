package com.zhiyou100.service;
import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Dispensing;
import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;


public interface DispensingService {
	
	
	// void deleteDispensing(String id);
	// 分页插件 pageHelper
	 List<Dispensing> findAllDispensing(Map map);
	 int count(Map map);
	 RegistrationInfor findNameById(String str);
	/*// 批量删除
	
		
	
	
	// List<Section> selectSection();
		
	List<RegistrationInfor> selectOne(String id);
	
	void updateRegistrationInfor(RegistrationInfor r);
    void updateHospitalInfor(HospitalInfor hi);
    
    void insertHospitalInfor(HospitalInfor h);

	int find(String medical_record);*/
	int checkDrug(String drug_num);
	void alterDrug(Map map);
}
