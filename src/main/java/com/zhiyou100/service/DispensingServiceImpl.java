package com.zhiyou100.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DispensingMapper;
import com.zhiyou100.mapper.HospitalClearMapper;
import com.zhiyou100.model.Dispensing;
import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class DispensingServiceImpl implements DispensingService{
	
	@Autowired
	private DispensingMapper mapper;
	
	public List<Dispensing> findAllDispensing(Map map) {
	
		return 	mapper.findAllDispensing(map);
	}
	
	public int count(Map map) {
		
		return mapper.count(map);
	}
	
	@Override
	public RegistrationInfor findNameById(String str) {
		return mapper.findNameById(str);
	}

	@Override
	public int checkDrug(String drug_num) {
		
		return mapper.checkDrug(drug_num);
	}

	@Override
	public void alterDrug(Map map) {
	 mapper.alterDrug(map);
		
	}

		
	/*@Override
	public List<RegistrationInfor> selectOne(String id) {
		
		return mapper.selectOne(id);
	}
	
	public void updateRegistrationInfor(RegistrationInfor r) {
		mapper.updateRegistrationInfor(r); 
	}
	public void updateHospitalInfor(HospitalInfor hi) {
		mapper.updateHospitalInfor(hi); 
	}
	
	
	public void insertHospitalInfor(HospitalInfor h) {
		mapper.insertHospitalInfor(h);
		
	}

	@Override
	public int find(String medical_record) {
		
		return mapper.find(medical_record);
	}
	
	@Override
	public void deleteHospitalClear(String id) {
		mapper.deleteHospitalClear(id);
		
	}
	
	
	*/

}
