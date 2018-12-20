package com.ruoyi.kashen.mapper;

import com.ruoyi.kashen.domain.ALARM_RECORD;

import java.util.List;

/**
 * 报警记录mapper
 */
public interface ALARM_RECORDMapper {

    public ALARM_RECORD selectById(String guid);


    public List<ALARM_RECORD> selectList(ALARM_RECORD alarm_record);


    public int insert(ALARM_RECORD alarm_record);


    public int update(ALARM_RECORD alarm_record);


    public int deleteById(String guid);


    public int deleteByIds(String[] guids);
}
