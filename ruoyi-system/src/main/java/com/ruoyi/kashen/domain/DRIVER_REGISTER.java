package com.ruoyi.kashen.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;
import oracle.sql.BLOB;

import java.sql.Blob;
import java.util.Arrays;

/**
 * 驾驶员登记
 * @ClassName DRIVER_REGISTER
 * @Author Chansey
 * @Date 2018/12/6 16:09
 * Version 1.0
 */
public class DRIVER_REGISTER extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 驾驶员编号 */
    @Excel(name = "驾驶员编号", width = 40)
    private String GUID;

    /** 驾驶员身份证 */
    @Excel(name = "驾驶员身份证")
    private String DRIVER_SFZH;

    /** 姓名 */
    @Excel(name = "驾驶员姓名")
    private String DRIVER_XM;

    /** 性别 */
    @Excel(name = "性别")
    private String DRIVER_XB;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String DRIVER_JG;

    /** 住址 */
    @Excel(name = "住址")
    private String DRIVER_ZZ;

    /** 民族 */
    @Excel(name = "民族")
    private String DRIVER_MZ;

    /** 驾驶证编号 */
    @Excel(name = "驾驶证编号")
    private String DRIVER_JSZBH;

    /** app登录密码 */
    @Excel(name = "app登录密码")
    private String APP_PWD;

    /** 现场照 */
    private byte[] DRIVER_XCZ;

    /** 人脸模板 */
    private byte[] DRIVER_RLMB;

    /** 审查状态 */
    @Excel(name = "审查状态", readConverterExp = "0=否,1=是")
    private Integer DRIVER_SCZT;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getDRIVER_SFZH() {
        return DRIVER_SFZH;
    }

    public void setDRIVER_SFZH(String DRIVER_SFZH) {
        this.DRIVER_SFZH = DRIVER_SFZH;
    }

    public String getDRIVER_XM() {
        return DRIVER_XM;
    }

    public void setDRIVER_XM(String DRIVER_XM) {
        this.DRIVER_XM = DRIVER_XM;
    }

    public String getDRIVER_XB() {
        return DRIVER_XB;
    }

    public void setDRIVER_XB(String DRIVER_XB) {
        this.DRIVER_XB = DRIVER_XB;
    }

    public String getDRIVER_JG() {
        return DRIVER_JG;
    }

    public void setDRIVER_JG(String DRIVER_JG) {
        this.DRIVER_JG = DRIVER_JG;
    }

    public String getDRIVER_ZZ() {
        return DRIVER_ZZ;
    }

    public void setDRIVER_ZZ(String DRIVER_ZZ) {
        this.DRIVER_ZZ = DRIVER_ZZ;
    }

    public String getDRIVER_MZ() {
        return DRIVER_MZ;
    }

    public void setDRIVER_MZ(String DRIVER_MZ) {
        this.DRIVER_MZ = DRIVER_MZ;
    }

    public String getDRIVER_JSZBH() {
        return DRIVER_JSZBH;
    }

    public void setDRIVER_JSZBH(String DRIVER_JSZBH) {
        this.DRIVER_JSZBH = DRIVER_JSZBH;
    }

    public String getAPP_PWD() {
        return APP_PWD;
    }

    public void setAPP_PWD(String APP_PWD) {
        this.APP_PWD = APP_PWD;
    }

    public byte[] getDRIVER_XCZ() {
        return DRIVER_XCZ;
    }

    public void setDRIVER_XCZ(byte[] DRIVER_XCZ) {
        this.DRIVER_XCZ = DRIVER_XCZ;
    }

    public byte[] getDRIVER_RLMB() {
        return DRIVER_RLMB;
    }

    public void setDRIVER_RLMB(byte[] DRIVER_RLMB) {
        this.DRIVER_RLMB = DRIVER_RLMB;
    }

    public Integer getDRIVER_SCZT() {
        return DRIVER_SCZT;
    }

    public void setDRIVER_SCZT(Integer DRIVER_SCZT) {
        this.DRIVER_SCZT = DRIVER_SCZT;
    }

    @Override
    public String toString() {
        return "DRIVER_REGISTER{" + "GUID='" + GUID + '\'' + ", DRIVER_SFZH='" + DRIVER_SFZH + '\'' + ", DRIVER_XM='" + DRIVER_XM + '\'' + ", DRIVER_XB='" + DRIVER_XB + '\'' + ", DRIVER_JG='" + DRIVER_JG + '\'' + ", DRIVER_ZZ='" + DRIVER_ZZ + '\'' + ", DRIVER_MZ='" + DRIVER_MZ + '\'' + ", DRIVER_JSZBH='" + DRIVER_JSZBH + '\'' + ", APP_PWD='" + APP_PWD + '\'' + ", DRIVER_XCZ=" + Arrays.toString(DRIVER_XCZ) + ", DRIVER_RLMB=" + Arrays.toString(DRIVER_RLMB) + ", DRIVER_SCZT=" + DRIVER_SCZT + '}';
    }
}
