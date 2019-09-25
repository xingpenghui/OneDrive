package com.feri.admin;

import com.feri.onedrive.admin.core.config.SystemConfig;
import com.feri.onedrive.admin.core.util.EncryptionUtil;
import org.junit.Test;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-17 11:41
 */
public class Pass_Test {
    @Test
    public void pass1(){
        //1、创建秘钥
        //String key= EncryptionUtil.createAESKEY();
        //System.out.println(key);
        String msg="guanliyuan";
        //2、加密
        String mw=EncryptionUtil.AESEnc(SystemConfig.PASSKEY,msg);
        System.out.println("密文："+mw);
        //3、解密
        System.out.println("明文："+EncryptionUtil.AESDec(SystemConfig.PASSKEY,mw));
    }
}
