package com.ruoyi.kashen.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.kashen.domain.ALARM_RECORD;
import com.ruoyi.kashen.mapper.ALARM_RECORDMapper;
import com.ruoyi.kashen.service.IAlarm_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName Alarm_recordServiceImpl
 * @Author Chansey
 * @Date 2018/12/5 16:22
 * Version 1.0
 */
@Service
public class Alarm_recordServiceImpl implements IAlarm_recordService{
    @Autowired
    private ALARM_RECORDMapper alarm_recordMapper;

    @Override
    public ALARM_RECORD selectById(String guid) {
        return alarm_recordMapper.selectById(guid);
    }

    @Override
    public List<ALARM_RECORD> selectList(ALARM_RECORD alarm_record) {
        return alarm_recordMapper.selectList(alarm_record);
    }

    @Override
    public int insert(ALARM_RECORD alarm_record) {
        return alarm_recordMapper.insert(alarm_record);
    }

    @Override
    public int update(ALARM_RECORD alarm_record) {
        return alarm_recordMapper.update(alarm_record);
    }

    @Override
    public int deleteByIds(String ids) {
        //参数是数组，将ids用逗号分隔成数组
        return alarm_recordMapper.deleteByIds(Convert.toStrArray(ids));
    }

    @Override
    public int total() {
        return alarm_recordMapper.total();
    }
}
