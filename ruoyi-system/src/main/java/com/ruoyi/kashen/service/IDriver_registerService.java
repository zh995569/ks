package com.ruoyi.kashen.service;

import com.ruoyi.kashen.domain.DRIVER_REGISTER;

import java.util.List;

/**
 * 驾驶员登记信息
 */
public interface IDriver_registerService {

    public DRIVER_REGISTER selectById(String guid);


    public List<DRIVER_REGISTER> selectList(DRIVER_REGISTER driver_register);


    public int insert(DRIVER_REGISTER driver_register);


    public int update(DRIVER_REGISTER driver_register);


    public int deleteByIds(String ids);

    public int total(DRIVER_REGISTER driver_register);

    public int examine(DRIVER_REGISTER driver_register);
}
