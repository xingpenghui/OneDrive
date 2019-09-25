package com.feri.onedrive.api.service.impl;

import com.feri.onedrive.api.core.oss.OssUtil;
import com.feri.onedrive.api.core.util.FileUtil;
import com.feri.onedrive.api.service.OSSService;
import com.feri.onedrive.common.util.RUtil;
import com.feri.onedrive.common.vo.R;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-19 11:49
 */
@Service
public class OSSServiceImpl implements OSSService {
    @Override
    public R saveFile(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
          //文件的上传
            String f= FileUtil.renameFile(file.getOriginalFilename());
            String u=OssUtil.sendByte("zzjava1904",f,file.getBytes());
            if(u!=null){
                return RUtil.setOK("上传成功",u);
            }
        }
        return RUtil.setERROR("上传异常，请检查网络");
    }

    @Override
    public R saveFiles(MultipartFile[] file) throws IOException {
        if(file!=null && file.length>0){
            List<String> urls=new ArrayList<>();
            for(MultipartFile f:file){
                if(!f.isEmpty()){
                    //文件的上传
                    String fn= FileUtil.renameFile(f.getOriginalFilename());
                    String u=OssUtil.sendByte("zzjava1904",fn,f.getBytes());
                    if(u!=null){
                       urls.add(u);
                    }
                }
            }
            return RUtil.setOK("批量上传成功",urls);
        }
        return RUtil.setERROR("上传异常，请检查网络");
    }
}
