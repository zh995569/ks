package com.ruoyi.kashen.mapper;

import com.ruoyi.kashen.domain.CAR_REGISTER;
import com.ruoyi.kashen.domain.CHECK_RECORD;

import java.util.List;

/**
 * 车辆登记mapper
 */
public interface CAR_REGISTERMapper {

    public CAR_REGISTER selectById(String guid);


    public List<CAR_REGISTER> selectList(CAR_REGISTER car_register);


    public int insert(CAR_REGISTER car_register);


    public int update(CAR_REGISTER car_register);


    public int deleteById(String guid);


    public int deleteByIds(String[] guids);
}
