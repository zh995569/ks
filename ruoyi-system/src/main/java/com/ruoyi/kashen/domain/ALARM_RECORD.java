package com.ruoyi.kashen.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

import java.util.Date;

/**
 * 报警记录
 * @ClassName ALARM_RECORD
 * @Author Chansey
 * @Date 2018/11/29 9:43
 * Version 1.0
 */
public class ALARM_RECORD extends BaseEntity{

    /** 报警记录编号 */
    @Excel(name = "报警记录编号", width = 40)
    private String GUID;

    /** 审批记录编号 */
    @Excel(name = "审批记录编号", width = 40)
    private String DRVIER_GUID;

    /** 车辆编号 */
    @Excel(name = "车辆编号", width = 40)
    private String CAR_GUID;

    /** 报警时间 */
    @Excel(name = "报警时间", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date ALARM_TIME;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private Integer ALARM_ZT;

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getDRVIER_GUID() {
        return DRVIER_GUID;
    }

    public void setDRVIER_GUID(String DRVIER_GUID) {
        this.DRVIER_GUID = DRVIER_GUID;
    }

    public String getCAR_GUID() {
        return CAR_GUID;
    }

    public void setCAR_GUID(String CAR_GUID) {
        this.CAR_GUID = CAR_GUID;
    }

    public Date getALARM_TIME() {
        return ALARM_TIME;
    }

    public void setALARM_TIME(Date ALARM_TIME) {
        this.ALARM_TIME = ALARM_TIME;
    }

    public Integer getALARM_ZT() {
        return ALARM_ZT;
    }

    public void setALARM_ZT(Integer ALARM_ZT) {
        this.ALARM_ZT = ALARM_ZT;
    }

    @Override
    public String toString() {
        return "ALARM_RECORD{" + "GUID='" + GUID + '\'' + ", DRVIER_GUID='" + DRVIER_GUID + '\'' + ", CAR_GUID='" + CAR_GUID + '\'' + ", ALARM_TIME=" + ALARM_TIME + ", ALARM_ZT=" + ALARM_ZT + '}';
    }
}
