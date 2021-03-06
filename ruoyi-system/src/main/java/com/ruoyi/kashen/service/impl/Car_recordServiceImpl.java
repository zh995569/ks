package com.ruoyi.kashen.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.kashen.domain.CAR_RECORD;
import com.ruoyi.kashen.domain.CHECK_RECORD;
import com.ruoyi.kashen.mapper.CAR_RECORDMapper;
import com.ruoyi.kashen.mapper.CHECK_RECORDMapper;
import com.ruoyi.kashen.service.ICar_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 车辆外出审批
 * @ClassName Car_recordServiceImpl
 * @Author Chansey
 * @Date 2018/12/6 11:01
 * Version 1.0
 */
@Service
public class Car_recordServiceImpl implements ICar_recordService{
    @Autowired
    private CAR_RECORDMapper car_recordMapper;

    @Override
    public CAR_RECORD selectById(String guid) {
        return car_recordMapper.selectById(guid);
    }

    @Override
    public List<CAR_RECORD> selectList(CAR_RECORD car_record) {
        return car_recordMapper.selectList(car_record);
    }

    @Override
    public int insert(CAR_RECORD car_record) {
        return  car_recordMapper.insert(car_record);
    }

    @Override
    public int update(CAR_RECORD car_record) {
       return car_recordMapper.update(car_record);
    }

    @Override
    public int deleteByIds(String ids) {
        //参数是数组，将ids用逗号分隔成数组
        String[] guids = Convert.toStrArray(ids);
        return car_recordMapper.deleteByIds(guids);
    }

    @Override
    public int total() {
        return car_recordMapper.total();
    }

    @Override
    public int todayTotal(Map<String, Object> map) {
        return car_recordMapper.todayTotal(map);
    }


    @Override
    public int examine(CAR_RECORD car_record) {
        return car_recordMapper.examine(car_record);
    }

}
