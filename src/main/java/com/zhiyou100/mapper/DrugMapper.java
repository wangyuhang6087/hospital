package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Drug;

/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:38:03
*/
public interface DrugMapper {
    List<Drug> findAllDrug(Map map);
    int count(Map map);
    void insertDrug(Drug drug);
    Drug findDrugById(String id);
    int deleteMoreDrug(List<String> list);
	void updateDrug(Drug drug);

}
