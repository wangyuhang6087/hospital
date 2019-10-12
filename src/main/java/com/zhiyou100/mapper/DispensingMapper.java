package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Dispensing;
import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;


/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:38:03
*/
public interface DispensingMapper {
    List<Dispensing> findAllDispensing(Map map);
    int count(Map map);
    RegistrationInfor findNameById(String str);
	int checkDrug(String drug_num);
	void alterDrug(Map map);
}
