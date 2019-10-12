package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.model.RegistrationInfor;


/**
* @author 说明:
* 创建时间：2019年9月3日 下午4:38:03
*/
public interface HospitalClearMapper {
    List<HospitalClear> findAllHospitalClear(Map map);
    int count(Map map);
    List<RegistrationInfor> selectOne(String id);
    void updateRegistrationInfor(RegistrationInfor r);
    void updateHospitalInfor(HospitalInfor h);
    void insertHospitalInfor(HospitalInfor h);
    int find(String medical_record);
    void deleteHospitalClear(String id);
	int deleteMoreHospitalClear(List<String> list);
}
