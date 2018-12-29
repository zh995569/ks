package com.ruoyi.kashen.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.kashen.domain.CAR_RECORD;
import com.ruoyi.kashen.domain.CHECK_RECORD;
import com.ruoyi.kashen.mapper.CAR_RECORDMapper;
import com.ruoyi.kashen.mapper.CHECK_RECORDMapper;
import com.ruoyi.kashen.service.ICar_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 车辆外出审批
 * @ClassName Car_recordServiceImpl
 * @Author Chansey
 * @Date 2018/12/6 11:01
 * Version 1.0
 */
@Service
public class Car_recordServiceImpl implements ICar_recordService{
    @Autowired
    private CAR_RECORDMapper car_recordMapper;

    @Autowired
    private CHECK_RECORDMapper check_recordMapper;

    @Override
    public CAR_RECORD selectById(String guid) {
        return car_recordMapper.selectById(guid);
    }

    @Override
    public List<CAR_RECORD> selectList(CAR_RECORD car_record) {
        return car_recordMapper.selectList(car_record);
    }

    @Override
    public int insert(CAR_RECORD car_record) {
        int countNum =  car_recordMapper.insert(car_record);
        //只有审批通过才插入数据到打卡记录表
        if(car_record.getDRIVER_SPZT() == 1) {
            CHECK_RECORD check_record = new CHECK_RECORD();

            check_record.setGUID(UUID.randomUUID().toString());
            check_record.setCAR_ID(car_record.getCAR_ID());
            check_record.setDRIVER_ID(car_record.getDRIVER_ID());
            check_record.setCAR_RECORD_ID(car_record.getGUID());

            check_recordMapper.insert(check_record);
        }
        return countNum;

    }

    @Override
    public int update(CAR_RECORD car_record) {
        int countNum =  car_recordMapper.update(car_record);

        if(car_record.getDRIVER_SPZT() == 1) {
            CHECK_RECORD check_record = new CHECK_RECORD();
            check_record.setCAR_ID(car_record.getCAR_ID());
            check_record.setDRIVER_ID(car_record.getDRIVER_ID());
            check_record.setCAR_RECORD_ID(car_record.getGUID());
            //通过CAR_RECORD_ID去打卡记录数据库里面查找，能找到说明是修改，找不到说明是新增
            CHECK_RECORD c = check_recordMapper.selectByCarRecordId(check_record.getCAR_RECORD_ID());
            if(c != null) {
                check_record.setGUID(c.getGUID());
                check_recordMapper.update(check_record);
            } else {
                check_record.setGUID(UUID.randomUUID().toString());
                check_recordMapper.insert(check_record);
            }
        }
        return countNum;
    }

    @Override
    public int deleteByIds(String ids) {
        //参数是数组，将ids用逗号分隔成数组
        String[] guids = Convert.toStrArray(ids);
        int countNum =  car_recordMapper.deleteByIds(guids);
        List<CHECK_RECORD> list = new ArrayList<>();
        for(int i = 0; i < guids.length; i++ ) {
            CHECK_RECORD c =  check_recordMapper.selectByCarRecordId(guids[i]);
            list.add(c);
        }

        //从打卡记录表的CAR_RECORD_ID里查找，能找到就删除，找不到就不用管
        for(CHECK_RECORD c : list) {
            if(c != null ) {
                check_recordMapper.deleteByCarRecordId(c.getCAR_RECORD_ID());
            }
        }
        return countNum;
    }

    @Override
    public int total(CAR_RECORD car_record) {
        return car_recordMapper.total(car_record);
    }

}
