package com.zhiyou100.service;
import java.util.List;
import java.util.Map;
import com.zhiyou100.model.Drug;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:31:58
*/
public interface DrugService {
	
/*	void deleteUser(int id);*/
	Drug findDrugById(String id);
	void insertDrug(Drug drug);
	int count(Map map);
	void updateDrug(Drug drug);
	// 分页插件 pageHelper
	 List<Drug> findAllDrug(Map map);
	 int deleteMoreDrug(List list);
/*	// 批量删除
	
	Doctor selectOne(int id);
	*/

	
	
	
}
