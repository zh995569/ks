package com.ruoyi.kashen.service;

import com.ruoyi.kashen.domain.ALARM_RECORD;

import java.util.List;

public interface IAlarm_recordService {

    public ALARM_RECORD selectById(String guid);


    public List<ALARM_RECORD> selectList(ALARM_RECORD alarm_record);


    public int insert(ALARM_RECORD alarm_record);


    public int update(ALARM_RECORD alarm_record);


    public int deleteByIds(String ids);

    public int total();
}
