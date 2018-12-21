package com.ruoyi.kashen.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestTime {

    public static void main(String[] args) {
        //这个文件已经修改了的，没有上传   顶顶顶
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long longTime = new Date().getTime();
        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        System.out.println("long为：" + longTime);
        //将给定的 Date 格式化为日期/时间字符串
        System.out.println("时间:" + sdf.format(new Date(longTime)));
        Calendar calendar = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间。
        calendar.setTime(new Date(longTime));
        //根据日历的规则，为给定的日历字段添加或减去指定的时间量。
        calendar.add(Calendar.DAY_OF_MONTH,2);
        System.out.println("2天后" +sdf.format(calendar.getTime().getTime()));


    }
}
