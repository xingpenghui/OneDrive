package com.feri.onedrive.api.api;

import com.feri.onedrive.api.service.OSSService;
import com.feri.onedrive.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-19 11:54
 */
@RestController
public class ResourceController {
    @Autowired
    private OSSService ossService;

    @CrossOrigin //跨域
    @PostMapping("api/resource/ossfileup.do")
    public R fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        return ossService.saveFile(file);
    }
    @CrossOrigin
    @PostMapping("api/resource/ossmorefileup.do")
    public R fileUploads(@RequestParam("file") MultipartFile[] file) throws IOException {
        return ossService.saveFiles(file);
    }
}
