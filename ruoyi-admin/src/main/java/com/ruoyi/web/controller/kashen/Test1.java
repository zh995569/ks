package com.ruoyi.web.controller.kashen;


import com.ruoyi.framework.util.ZUtil;
import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Test1
 * @Author Chansey
 * @Date 2018/12/14 11:46
 * Version 1.0
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        String str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOYAAAC0CAYAAACALFBHAAAEXElEQVR4Xu3TQREAAAgCQelf2hr3WBMwi+wcAQI5geUSCUSAwBmmJyAQFDDMYCkiETBMP0AgKGCYwVJEImCYfoBAUMAwg6WIRMAw/QCBoIBhBksRiYBh+gECQQHDDJYiEgHD9AMEggKGGSxFJAKG6QcIBAUMM1iKSAQM0w8QCAoYZrAUkQgYph8gEBQwzGApIhEwTD9AIChgmMFSRCJgmH6AQFDAMIOliETAMP0AgaCAYQZLEYmAYfoBAkEBwwyWIhIBw/QDBIIChhksRSQChukHCAQFDDNYikgEDNMPEAgKGGawFJEIGKYfIBAUMMxgKSIRMEw/QCAoYJjBUkQiYJh+gEBQwDCDpYhEwDD9AIGggGEGSxGJgGH6AQJBAcMMliISAcP0AwSCAoYZLEUkAobpBwgEBQwzWIpIBAzTDxAIChhmsBSRCBimHyAQFDDMYCkiETBMP0AgKGCYwVJEImCYfoBAUMAwg6WIRMAw/QCBoIBhBksRiYBh+gECQQHDDJYiEgHD9AMEggKGGSxFJAKG6QcIBAUMM1iKSAQM0w8QCAoYZrAUkQgYph8gEBQwzGApIhEwTD9AIChgmMFSRCJgmH6AQFDAMIOliETAMP0AgaCAYQZLEYmAYfoBAkEBwwyWIhIBw/QDBIIChhksRSQChukHCAQFDDNYikgEDNMPEAgKGGawFJEIGKYfIBAUMMxgKSIRMEw/QCAoYJjBUkQiYJh+gEBQwDCDpYhEwDD9AIGggGEGSxGJgGH6AQJBAcMMliISAcP0AwSCAoYZLEUkAobpBwgEBQwzWIpIBAzTDxAIChhmsBSRCBimHyAQFDDMYCkiETBMP0AgKGCYwVJEImCYfoBAUMAwg6WIRMAw/QCBoIBhBksRiYBh+gECQQHDDJYiEgHD9AMEggKGGSxFJAKG6QcIBAUMM1iKSAQM0w8QCAoYZrAUkQgYph8gEBQwzGApIhEwTD9AIChgmMFSRCJgmH6AQFDAMIOliETAMP0AgaCAYQZLEYmAYfoBAkEBwwyWIhIBw/QDBIIChhksRSQChukHCAQFDDNYikgEDNMPEAgKGGawFJEIGKYfIBAUMMxgKSIRMEw/QCAoYJjBUkQiYJh+gEBQwDCDpYhEwDD9AIGggGEGSxGJgGH6AQJBAcMMliISAcP0AwSCAoYZLEUkAobpBwgEBQwzWIpIBAzTDxAIChhmsBSRCBimHyAQFDDMYCkiETBMP0AgKGCYwVJEImCYfoBAUMAwg6WIRMAw/QCBoIBhBksRiYBh+gECQQHDDJYiEgHD9AMEggKGGSxFJAKG6QcIBAUMM1iKSAQM0w8QCAoYZrAUkQgYph8gEBQwzGApIhEwTD9AIChgmMFSRCJgmH6AQFDAMIOliETAMP0AgaCAYQZLEYmAYfoBAkEBwwyWIhIBw/QDBIIChhksRSQChukHCAQFDDNYikgEDNMPEAgKGGawFJEIGKYfIBAUMMxgKSIReILvALUlA2PNAAAAAElFTkSuQmCC";
        /*String s = str.substring(22);
        System.out.println(s);

        byte[] b = Base64.decodeBase64(s);
        String res =Base64.encodeBase64String(b);
        System.out.println("data:image/png;base64,"+res);*/
        /*byte[] b = str.getBytes();
        String s = new String(b);
        System.out.println(s);
        Test1 t = new Test1();
        t.aaa();*/

        /*Long id = 123l;
        if ("123".equals(id.toString())){
            System.out.println("true");
        }else {
            System.out.println("false");
        }*/

        /*String s = "dfg55erge5";
        System.out.println(s.contains("55"));*/

        /*String path = "e:\\123.jpeg";
        String base64 = ZUtil.GetImageStr(path);
        System.out.println(base64);*/
        String s = "";
        byte[] b = s.getBytes();
        System.out.println(b);
    }

    /**
     * 将图片转换成Base64编码
     * @param imgFile 待处理图片
     * @return
     */
    /*public static String getImgStr(String imgFile){
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(data));
    }*/

}

