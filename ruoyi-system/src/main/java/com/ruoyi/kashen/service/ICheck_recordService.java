package com.ruoyi.kashen.service;

import com.ruoyi.kashen.domain.CHECK_RECORD;

import java.util.List;

public interface ICheck_recordService {
    public CHECK_RECORD selectById(String guid);


    public List<CHECK_RECORD> selectList(CHECK_RECORD check_record);


    public int insert(CHECK_RECORD check_record);


    public int update(CHECK_RECORD check_record);


    public int deleteByIds(String ids);
}
