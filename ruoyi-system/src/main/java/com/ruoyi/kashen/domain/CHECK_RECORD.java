package com.ruoyi.kashen.domain;

import com.ruoyi.common.base.BaseEntity;

import java.util.Arrays;
import java.util.Date;

/**
 * 打卡记录
 * @ClassName CHECK_RECORD
 * @Author Chansey
 * @Date 2018/11/29 10:32
 * Version 1.0
 */
public class CHECK_RECORD extends BaseEntity{
    private String GUID;
    private String CAR_ID;
    private String DRIVER_ID;
    private Date DKSJ;
    private String ZBX;
    private String ZBY;
    private byte[] XCZ;
    private CAR_REGISTER car_register;
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

    public Date getDKSJ() {
        return DKSJ;
    }

    public void setDKSJ(Date DKSJ) {
        this.DKSJ = DKSJ;
    }

    public String getZBX() {
        return ZBX;
    }

    public void setZBX(String ZBX) {
        this.ZBX = ZBX;
    }

    public String getZBY() {
        return ZBY;
    }

    public void setZBY(String ZBY) {
        this.ZBY = ZBY;
    }

    public byte[] getXCZ() {
        return XCZ;
    }

    public void setXCZ(byte[] XCZ) {
        this.XCZ = XCZ;
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
        return "CHECK_RECORD{" + "GUID='" + GUID + '\'' + ", CAR_ID='" + CAR_ID + '\'' + ", DRIVER_ID='" + DRIVER_ID + '\'' + ", DKSJ=" + DKSJ + ", ZBX='" + ZBX + '\'' + ", ZBY='" + ZBY + '\'' + ", XCZ=" + Arrays.toString(XCZ) + ", car_register=" + car_register + ", driver_register=" + driver_register + '}';
    }
}
