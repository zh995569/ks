package com.ruoyi.kashen.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.kashen.domain.CAR_REGISTER;
import com.ruoyi.kashen.mapper.CAR_REGISTERMapper;
import com.ruoyi.kashen.service.ICar_registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车辆登记
 * @ClassName Car_registerServiceImpl
 * @Author Chansey
 * @Date 2018/12/5 16:25
 * Version 1.0
 */
@Service
public class Car_registerServiceImpl implements ICar_registerService{

    @Autowired
    private CAR_REGISTERMapper car_registerMapper;


    @Override
    public CAR_REGISTER selectById(String guid) {
        return car_registerMapper.selectById(guid);
    }

    @Override
    public List<CAR_REGISTER> selectList(CAR_REGISTER car_register) {
        return car_registerMapper.selectList(car_register);
    }

    @Override
    public int insert(CAR_REGISTER car_register) {
        return car_registerMapper.insert(car_register);
    }

    @Override
    public int update(CAR_REGISTER car_register) {
        return car_registerMapper.update(car_register);
    }

    @Override
    public int deleteByIds(String ids) {
        //参数是数组，将ids用逗号分隔成数组
        return car_registerMapper.deleteByIds(Convert.toStrArray(ids));
    }

    @Override
    public int total() {
        return car_registerMapper.total();
    }

    @Override
    public int totalCAR_CLZT(CAR_REGISTER car_register) {
        return car_registerMapper.totalCAR_CLZT(car_register);
    }


}
