package com.ruoyi.kashen.mapper;

import com.ruoyi.kashen.domain.CAR_RECORD;

import java.util.List;
import java.util.Map;

/**
 * 车辆外出审批登记mapper
 */
public interface CAR_RECORDMapper {

    public CAR_RECORD selectById(String guid);


    public List<CAR_RECORD> selectList(CAR_RECORD car_record);


    public int insert(CAR_RECORD car_record);


    public int update(CAR_RECORD car_record);


    public int deleteById(String guid);


    public int deleteByIds(String[] guids);

    public int total();

    public int todayTotal(Map<String,Object> map);

    public int approval(String guid);
}
