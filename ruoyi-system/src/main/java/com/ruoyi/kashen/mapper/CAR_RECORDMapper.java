package com.ruoyi.kashen.mapper;

import com.ruoyi.kashen.domain.CAR_RECORD;

import java.util.List;

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

    public int total(CAR_RECORD car_record);

    public int approval(String guid);
}
