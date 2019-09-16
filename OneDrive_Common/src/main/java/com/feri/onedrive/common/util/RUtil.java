package com.feri.onedrive.common.util;


import com.feri.onedrive.common.menum.Renum;
import com.feri.onedrive.common.vo.R;

/**
 * @program: TalentShow
 * @description:
 * @author: Feri
 * @create: 2019-09-10 11:28
 */
public class RUtil {
    /**
     * 设置成功*/
    public static <T> R setOK(String msg, T obj){
        R<T> r=new R<>();
        r.setCode(Renum.SUCCESS.getCode());
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }

    public static <T> R setOK(String msg){
        R<T> r=new R<>();
        r.setCode(Renum.SUCCESS.getCode());
        r.setMsg(msg);
        r.setData(null);
        return r;
    }
    public static <T> R setOK(){
        R<T> r=new R<>();
        r.setCode(Renum.SUCCESS.getCode());
        r.setMsg("OK");
        r.setData(null);
        return r;
    }

    public static <T> R setERROR(String msg, T obj){
        R<T> r=new R<>();
        r.setCode(Renum.ERROR.getCode());
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }
    public static <T> R setERROR(String msg){
        R<T> r=new R<>();
        r.setCode(Renum.ERROR.getCode());
        r.setMsg(msg);
        r.setData(null);
        return r;
    }
    public static <T> R setERROR(){
        R<T> r=new R<>();
        r.setCode(Renum.ERROR.getCode());
        r.setMsg("ERROR");
        r.setData(null);
        return r;
    }
    public static <T> R setR(boolean issuccess,String msg){
        return issuccess?setOK(msg):setERROR(msg);
    }
}
