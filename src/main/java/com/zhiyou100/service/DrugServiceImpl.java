package com.zhiyou100.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyou100.mapper.DrugMapper;
import com.zhiyou100.model.Drug;

@Service
public class DrugServiceImpl implements DrugService{
	
	@Autowired
	private DrugMapper mapper;
	public List<Drug> findAllDrug(Map map) {	
		return 	mapper.findAllDrug(map);
	}
	
	public int count(Map map) {		
		return mapper.count(map);
	}	
	
	public void insertDrug(Drug drug) {
		mapper.insertDrug(drug);		
	}
	
	public Drug findDrugById(String id) {
		 return mapper.findDrugById(id);
	}
	
	public void updateDrug(Drug drug) {
		mapper.updateDrug(drug); 
	}
	
	@Override
	public int deleteMoreDrug(List list) {
		return mapper.deleteMoreDrug(list);
	}

	
	
	/*
	public void deleteUser(int id) {
		mapper.deleteUser(id);
		
	}

	

*/
/*
	

	@Override
	public Doctor selectOne(int id) {
		
		return mapper.selectOne(id);
	}
*/
}
