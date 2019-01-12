package com.ruoyi.kashen.service;

import com.ruoyi.kashen.domain.CAR_REGISTER;

import java.util.List;

public interface ICar_registerService {

    public CAR_REGISTER selectById(String guid);


    public List<CAR_REGISTER> selectList(CAR_REGISTER car_register);


    public int insert(CAR_REGISTER car_register);


    public int update(CAR_REGISTER car_register);


    public int deleteByIds(String ids);

    public int total();

    public int totalCAR_CLZT(CAR_REGISTER car_register);
}
