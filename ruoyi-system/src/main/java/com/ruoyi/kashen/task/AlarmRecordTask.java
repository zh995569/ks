package com.ruoyi.kashen.task;



import com.ruoyi.kashen.mapper.CHECK_RECORDMapper;
import com.ruoyi.kashen.service.ICheck_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class AlarmRecordTask {

    @Autowired
    private ICheck_recordService check_recordService;

    @Autowired
    private CHECK_RECORDMapper checkRecordMapper;

    @Scheduled(cron = "0/30 * *  * * ?")
    public void work() throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long longTime = new Date().getTime();

        //System.out.println("long为：" + longTime);
        System.out.println("日期为："+ sdf.format(new Date(longTime)));
        System.out.println("定时检查过期打卡执行");
    }

}