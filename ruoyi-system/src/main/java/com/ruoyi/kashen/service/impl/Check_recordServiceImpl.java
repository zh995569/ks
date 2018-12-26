package com.ruoyi.kashen.service.impl;


import com.ruoyi.common.support.Convert;
import com.ruoyi.kashen.domain.CAR_REGISTER;
import com.ruoyi.kashen.domain.DRIVER_REGISTER;
import com.ruoyi.kashen.domain.CHECK_RECORD;

import com.ruoyi.kashen.mapper.CAR_RECORDMapper;
import com.ruoyi.kashen.mapper.CAR_REGISTERMapper;
import com.ruoyi.kashen.mapper.CHECK_RECORDMapper;
import com.ruoyi.kashen.mapper.DRIVER_REGISTERMapper;
import com.ruoyi.kashen.service.ICheck_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Check_recordServiceImpl
 * @Author Chansey
 * @Date 2018/12/5 16:22
 * Version 1.0
 */
@Service
public class Check_recordServiceImpl implements ICheck_recordService {

    @Autowired
    private CHECK_RECORDMapper check_recordMapper;

    @Autowired
    private DRIVER_REGISTERMapper driver_registerMapper;

    @Autowired
    private CAR_REGISTERMapper car_registerMapper;

    @Override
    public CHECK_RECORD selectById(String guid) {
        return check_recordMapper.selectById(guid);
    }

    @Override
    public List<CHECK_RECORD> selectList(CHECK_RECORD check_record) {
        return check_recordMapper.selectList(check_record);
    }

    @Override
    public int insert(CHECK_RECORD check_record) {

        return check_recordMapper.insert(check_record);
    }

    @Override
    public int update(CHECK_RECORD check_record) {
        return check_recordMapper.update(check_record);
    }

    @Override
    public int deleteByIds(String ids) {
        return check_recordMapper.deleteByIds(Convert.toStrArray(ids));
    }

}
