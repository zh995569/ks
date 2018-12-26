package com.ruoyi.kashen.task;



import com.ruoyi.kashen.domain.ALARM_RECORD;
import com.ruoyi.kashen.domain.CHECK_RECORD;
import com.ruoyi.kashen.mapper.ALARM_RECORDMapper;
import com.ruoyi.kashen.mapper.CHECK_RECORDMapper;
import com.ruoyi.kashen.service.ICheck_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@EnableScheduling
public class AlarmRecordTask {


    @Autowired
    private CHECK_RECORDMapper checkRecordMapper;

    @Autowired
    private ALARM_RECORDMapper alarm_recordMapper;

    @Scheduled(cron = "0/50 * *  * * ?")
    public void work() throws Exception {
        //查询未打卡记录
        List<CHECK_RECORD> unpunch =  checkRecordMapper.selectUnpunch();
        if(unpunch != null && unpunch.size() > 0) {
            System.out.println("每到50秒查询一次记录----------总记录数为：" + unpunch.size() +"次");

            Thread.sleep(50000);
            for(CHECK_RECORD c : unpunch) {
                ALARM_RECORD alarm_record = new ALARM_RECORD();
                alarm_record.setGUID(UUID.randomUUID().toString());
                alarm_record.setDRVIER_GUID(c.getCAR_RECORD_ID());
                alarm_record.setCAR_GUID(c.getCAR_ID());
                alarm_record.setALARM_TIME(new Date());
                alarm_record.setALARM_ZT(0);
                ALARM_RECORD ar =  alarm_recordMapper.selectByCarRecordId(alarm_record.getDRVIER_GUID());
                if(ar != null && ar.getDRVIER_GUID().equals(alarm_record.getDRVIER_GUID()) ) {

                } else {
                    alarm_recordMapper.insertUnPunch(alarm_record);
                }

            }

        }

    }

}