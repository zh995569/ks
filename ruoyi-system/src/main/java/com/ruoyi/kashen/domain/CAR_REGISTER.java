package com.ruoyi.kashen.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

import java.util.Date;


/**
 * 车辆登记信息
 * @ClassName CAR_REGISTER
 * @Author Chansey
 * @Date 2018/11/29 10:26
 * Version 1.0
 */
public class CAR_REGISTER extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @Excel(name = "车辆编号", width = 40)
    private String GUID;
    @Excel(name = "大架子号")
    private String CAR_DJZH;
    @Excel(name = "车牌号码")
    private String CAR_CPHM;
    @Excel(name = "机动车编号")
    private String CAR_JDCBH;
    @Excel(name = "车辆型号")
    private String CAR_CLXH;
    @Excel(name = "车辆品牌")
    private String CAR_CLPP;
    @Excel(name = "车辆颜色")
    private String CAR_CLYS;
    @Excel(name = "车主姓名")
    private String CAR_CZXM;
    @Excel(name = "车辆状态", readConverterExp = "0=闲置,1=外出")
    private String CAR_CLZT;
    @Excel(name = "车主性别")
    private String CAR_CZXB;
    @Excel(name = "车主民族")
    private String CAR_CZMZ;
    @Excel(name = "车主身份证号码")
    private String CAR_CZSFZH;
    @Excel(name = "车主住址")
    private String CAR_CZDZ;
    @Excel(name = "车主籍贯")
    private String CAR_CZJG;
    @Excel(name = "车主联系电话")
    private String CAR_CZLXDH;
    @Excel(name = "登记时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date CAR_DJSJ;
    @Excel(name = "所属警务站", width = 30)
    private String CAR_SSJWZ;
    @Excel(name = "所属派出所", width = 30)
    private String CAR_SSPCS;
    @Excel(name = "所属区域")
    private String CAR_SSQY;
    @Excel(name = "是否审查", readConverterExp = "0=否,1=是")
    private Integer CAR_SFSC;
    @Excel(name = "审查理由", width = 50)
    private String REASON;

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getCAR_DJZH() {
        return CAR_DJZH;
    }

    public void setCAR_DJZH(String CAR_DJZH) {
        this.CAR_DJZH = CAR_DJZH;
    }

    public String getCAR_CPHM() {
        return CAR_CPHM;
    }

    public void setCAR_CPHM(String CAR_CPHM) {
        this.CAR_CPHM = CAR_CPHM;
    }

    public String getCAR_JDCBH() {
        return CAR_JDCBH;
    }

    public void setCAR_JDCBH(String CAR_JDCBH) {
        this.CAR_JDCBH = CAR_JDCBH;
    }

    public String getCAR_CLXH() {
        return CAR_CLXH;
    }

    public void setCAR_CLXH(String CAR_CLXH) {
        this.CAR_CLXH = CAR_CLXH;
    }

    public String getCAR_CLPP() {
        return CAR_CLPP;
    }

    public void setCAR_CLPP(String CAR_CLPP) {
        this.CAR_CLPP = CAR_CLPP;
    }

    public String getCAR_CLYS() {
        return CAR_CLYS;
    }

    public void setCAR_CLYS(String CAR_CLYS) {
        this.CAR_CLYS = CAR_CLYS;
    }

    public String getCAR_CZXM() {
        return CAR_CZXM;
    }

    public void setCAR_CZXM(String CAR_CZXM) {
        this.CAR_CZXM = CAR_CZXM;
    }

    public String getCAR_CLZT() {
        return CAR_CLZT;
    }

    public void setCAR_CLZT(String CAR_CLZT) {
        this.CAR_CLZT = CAR_CLZT;
    }

    public String getCAR_CZXB() {
        return CAR_CZXB;
    }

    public void setCAR_CZXB(String CAR_CZXB) {
        this.CAR_CZXB = CAR_CZXB;
    }

    public String getCAR_CZMZ() {
        return CAR_CZMZ;
    }

    public void setCAR_CZMZ(String CAR_CZMZ) {
        this.CAR_CZMZ = CAR_CZMZ;
    }

    public String getCAR_CZSFZH() {
        return CAR_CZSFZH;
    }

    public void setCAR_CZSFZH(String CAR_CZSFZH) {
        this.CAR_CZSFZH = CAR_CZSFZH;
    }

    public String getCAR_CZDZ() {
        return CAR_CZDZ;
    }

    public void setCAR_CZDZ(String CAR_CZDZ) {
        this.CAR_CZDZ = CAR_CZDZ;
    }

    public String getCAR_CZJG() {
        return CAR_CZJG;
    }

    public void setCAR_CZJG(String CAR_CZJG) {
        this.CAR_CZJG = CAR_CZJG;
    }

    public String getCAR_CZLXDH() {
        return CAR_CZLXDH;
    }

    public void setCAR_CZLXDH(String CAR_CZLXDH) {
        this.CAR_CZLXDH = CAR_CZLXDH;
    }

    public Date getCAR_DJSJ() {
        return CAR_DJSJ;
    }

    public void setCAR_DJSJ(Date CAR_DJSJ) {
        this.CAR_DJSJ = CAR_DJSJ;
    }

    public String getCAR_SSJWZ() {
        return CAR_SSJWZ;
    }

    public void setCAR_SSJWZ(String CAR_SSJWZ) {
        this.CAR_SSJWZ = CAR_SSJWZ;
    }

    public String getCAR_SSPCS() {
        return CAR_SSPCS;
    }

    public void setCAR_SSPCS(String CAR_SSPCS) {
        this.CAR_SSPCS = CAR_SSPCS;
    }

    public String getCAR_SSQY() {
        return CAR_SSQY;
    }

    public void setCAR_SSQY(String CAR_SSQY) {
        this.CAR_SSQY = CAR_SSQY;
    }

    public Integer getCAR_SFSC() {
        return CAR_SFSC;
    }

    public void setCAR_SFSC(Integer CAR_SFSC) {
        this.CAR_SFSC = CAR_SFSC;
    }

    public String getREASON() {
        return REASON;
    }

    public void setREASON(String REASON) {
        this.REASON = REASON;
    }

    @Override
    public String toString() {
        return "CAR_REGISTER{" +
                "GUID='" + GUID + '\'' +
                ", CAR_DJZH='" + CAR_DJZH + '\'' +
                ", CAR_CPHM='" + CAR_CPHM + '\'' +
                ", CAR_JDCBH='" + CAR_JDCBH + '\'' +
                ", CAR_CLXH='" + CAR_CLXH + '\'' +
                ", CAR_CLPP='" + CAR_CLPP + '\'' +
                ", CAR_CLYS='" + CAR_CLYS + '\'' +
                ", CAR_CZXM='" + CAR_CZXM + '\'' +
                ", CAR_CLZT='" + CAR_CLZT + '\'' +
                ", CAR_CZXB='" + CAR_CZXB + '\'' +
                ", CAR_CZMZ='" + CAR_CZMZ + '\'' +
                ", CAR_CZSFZH='" + CAR_CZSFZH + '\'' +
                ", CAR_CZDZ='" + CAR_CZDZ + '\'' +
                ", CAR_CZJG='" + CAR_CZJG + '\'' +
                ", CAR_CZLXDH='" + CAR_CZLXDH + '\'' +
                ", CAR_DJSJ=" + CAR_DJSJ +
                ", CAR_SSJWZ='" + CAR_SSJWZ + '\'' +
                ", CAR_SSPCS='" + CAR_SSPCS + '\'' +
                ", CAR_SSQY='" + CAR_SSQY + '\'' +
                ", CAR_SFSC=" + CAR_SFSC +
                ", REASON='" + REASON + '\'' +
                '}';
    }
}
