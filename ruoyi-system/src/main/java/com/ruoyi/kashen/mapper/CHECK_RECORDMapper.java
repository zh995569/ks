package com.ruoyi.kashen.mapper;

import com.ruoyi.kashen.domain.CHECK_RECORD;

import java.util.List;

public interface CHECK_RECORDMapper {

    public CHECK_RECORD selectById(String guid);


    public List<CHECK_RECORD> selectList(CHECK_RECORD check_record);


    public int insert(CHECK_RECORD check_record);


    public int update(CHECK_RECORD check_record);


    public int deleteById(String guid);


    public int deleteByIds(String[] guids);
}
