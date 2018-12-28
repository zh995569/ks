package com.ruoyi.kashen.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 车辆外出审批登记
 * @ClassName CAR_RECORD
 * @Author Chansey
 * @Date 2018/11/29 9:45
 * Version 1.0
 */
public class CAR_RECORD extends BaseEntity {
    /**  */
    private String GUID;

    /** 车辆编号 */
    @Excel(name = "车牌号码", width = 40)
    private String CAR_ID;

    /** 驾驶员编号 */
    @Excel(name = "驾驶员姓名", width = 40)
    private String DRIVER_ID;

    /** 外出事由 */
    @Excel(name = "外出事由")
    private String DRIVER_WCSY;

    /** 外出地点 */
    @Excel(name = "外出地点")
    private String DRIVER_WCDD;

    /** 开始时间 */
    @Excel(name = "开始时间", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date DRIVER_KSSJ;

    /** 结束时间 */
    @Excel(name = "结束时间", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date DRIVER_JSSJ;

    /** 审批状态 */
    @Excel(name = "审批状态", readConverterExp="0=未审批,1=已审批")
    private Integer DRIVER_SPZT;

    @Excel(name = "车牌号码", targetAttr="CAR_CPHM")
    private CAR_REGISTER car_register;

    @Excel(name = "驾驶员姓名", targetAttr = "DRIVER_XM")
    private DRIVER_REGISTER driver_register;

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getCAR_ID() {
        return CAR_ID;
    }

    public void setCAR_ID(String CAR_ID) {
        this.CAR_ID = CAR_ID;
    }

    public String getDRIVER_ID() {
        return DRIVER_ID;
    }

    public void setDRIVER_ID(String DRIVER_ID) {
        this.DRIVER_ID = DRIVER_ID;
    }

    public String getDRIVER_WCSY() {
        return DRIVER_WCSY;
    }

    public void setDRIVER_WCSY(String DRIVER_WCSY) {
        this.DRIVER_WCSY = DRIVER_WCSY;
    }

    public String getDRIVER_WCDD() {
        return DRIVER_WCDD;
    }

    public void setDRIVER_WCDD(String DRIVER_WCDD) {
        this.DRIVER_WCDD = DRIVER_WCDD;
    }

    public Date getDRIVER_KSSJ() {
        return DRIVER_KSSJ;
    }

    public void setDRIVER_KSSJ(Date DRIVER_KSSJ) {
        this.DRIVER_KSSJ = DRIVER_KSSJ;
    }

    public Date getDRIVER_JSSJ() {
        return DRIVER_JSSJ;
    }

    public void setDRIVER_JSSJ(Date DRIVER_JSSJ) {
        this.DRIVER_JSSJ = DRIVER_JSSJ;
    }

    public Integer getDRIVER_SPZT() {
        return DRIVER_SPZT;
    }

    public void setDRIVER_SPZT(Integer DRIVER_SPZT) {
        this.DRIVER_SPZT = DRIVER_SPZT;
    }

    public CAR_REGISTER getCar_register() {
        return car_register;
    }

    public void setCar_register(CAR_REGISTER car_register) {
        this.car_register = car_register;
    }

    public DRIVER_REGISTER getDriver_register() {
        return driver_register;
    }

    public void setDriver_register(DRIVER_REGISTER driver_register) {
        this.driver_register = driver_register;
    }

    @Override
    public String toString() {
        return "CAR_RECORD{" + "GUID='" + GUID + '\'' + ", CAR_ID='" + CAR_ID + '\'' + ", DRIVER_ID='" + DRIVER_ID + '\'' + ", DRIVER_WCSY='" + DRIVER_WCSY + '\'' + ", DRIVER_WCDD='" + DRIVER_WCDD + '\'' + ", DRIVER_KSSJ=" + DRIVER_KSSJ + ", DRIVER_JSSJ=" + DRIVER_JSSJ + ", DRIVER_SPZT=" + DRIVER_SPZT + ", car_register=" + car_register + ", driver_register=" + driver_register + '}';
    }
}
