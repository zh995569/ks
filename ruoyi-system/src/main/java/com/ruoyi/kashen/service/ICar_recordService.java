package com.ruoyi.kashen.service;

import com.ruoyi.kashen.domain.CAR_RECORD;

import java.util.List;
import java.util.Map;

/**
 * 车辆外出审批登记
 */
public interface ICar_recordService {

    public CAR_RECORD selectById(String guid);


    public List<CAR_RECORD> selectList(CAR_RECORD car_record);


    public int insert(CAR_RECORD car_record);


    public int update(CAR_RECORD car_record);


    public int deleteByIds(String ids);

    public int total();

    public int todayTotal(Map<String,Object> map);


    public int examine(CAR_RECORD car_record);
}
