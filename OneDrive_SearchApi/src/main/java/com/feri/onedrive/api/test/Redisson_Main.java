package com.feri.onedrive.api.test;

import com.feri.onedrive.api.util.RedissonUtil;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 14:26
 */
public class Redisson_Main {
    public static void main(String[] args) {
      //  RedissonUtil.saveStr("abc:xing","123");
        System.out.println(RedissonUtil.getStr("abc:xing"));
    }
}