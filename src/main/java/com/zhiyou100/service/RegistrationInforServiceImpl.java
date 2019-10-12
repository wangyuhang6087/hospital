package com.zhiyou100.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyou100.mapper.RegistrationInforMapper;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class RegistrationInforServiceImpl implements RegistrationInforService{
	
	@Autowired
	private RegistrationInforMapper mapper;
	
	public List<RegistrationInfor> findAllRegistrationInfor(Map map) {
	
		return 	mapper.findAllRegistrationInfor(map);
	}
	
	public int count(Map map) {
		
		return mapper.count(map);
	}

	public void insertRegistrationInfor(RegistrationInfor registrationInfor) {
		mapper.insertRegistrationInfor(registrationInfor);
		
	}
	
	
	@Override
	public List<RegistrationInfor> selectOne(String id) {
		
		return mapper.selectOne(id);
	}

	@Override
	public RegistrationInfor findOne(String id) {
		
		return mapper.findOne(id);
	}
	

	public void updateRegistrationInfor(RegistrationInfor registrationInfor) {
		mapper.updateRegistrationInfor(registrationInfor); 
	}
	
	@Override
	public int deleteMoreRegistrationInfor(List list) {
		return mapper.deleteMoreRegistrationInfor(list);
	}
	
	public void deleteRegistrationInfor(String id) {
		mapper.deleteRegistrationInfor(id);
		
	}
	

	
}
