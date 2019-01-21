package com.ruoyi.kashen.mapper;


import com.ruoyi.kashen.domain.DRIVER_REGISTER;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 驾驶员登记信息mapper
 */
public interface DRIVER_REGISTERMapper {

    public DRIVER_REGISTER selectById(String guid);


    public List<DRIVER_REGISTER> selectList(DRIVER_REGISTER driver_register);


    public int insert(DRIVER_REGISTER driver_register);


    public int update(DRIVER_REGISTER driver_register);


    public int deleteById(String guid);


    public int deleteByIds(String[] guids);

    public int total(DRIVER_REGISTER driver_register);

    public int examine(DRIVER_REGISTER driver_register);
}
