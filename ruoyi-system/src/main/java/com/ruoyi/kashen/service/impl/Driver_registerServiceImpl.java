package com.ruoyi.kashen.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.kashen.domain.DRIVER_REGISTER;
import com.ruoyi.kashen.mapper.DRIVER_REGISTERMapper;
import com.ruoyi.kashen.service.IDriver_registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName Driver_registerServiceImpl
 * @Author Chansey
 * @Date 2018/12/6 16:37
 * Version 1.0
 */
@Service
public class Driver_registerServiceImpl implements IDriver_registerService{
   @Autowired
    private DRIVER_REGISTERMapper driver_registerMapper;

    @Override
    public DRIVER_REGISTER selectById(String guid) {
        return driver_registerMapper.selectById(guid);
    }

    @Override
    public List<DRIVER_REGISTER> selectList(DRIVER_REGISTER driver_register) {
        return driver_registerMapper.selectList(driver_register);
    }

    @Override
    public int insert(DRIVER_REGISTER driver_register) {
        return driver_registerMapper.insert(driver_register);
    }

    @Override
    public int update(DRIVER_REGISTER driver_register) {
        return driver_registerMapper.update(driver_register);
    }

    @Override
    public int deleteByIds(String ids) {
        //参数是数组，将ids用逗号分隔成数组
        return driver_registerMapper.deleteByIds(Convert.toStrArray(ids));
    }

    @Override
    public int total(DRIVER_REGISTER driver_register){
        return driver_registerMapper.total(driver_register);
    }

    @Override
    public int examine(DRIVER_REGISTER driver_register) {
        return driver_registerMapper.examine(driver_register);
    }
}
