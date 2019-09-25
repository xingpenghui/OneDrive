package com.feri.onedrive.api.service;

import com.feri.onedrive.common.vo.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface OSSService {
    R saveFile(MultipartFile file) throws IOException;
    R saveFiles(MultipartFile[] file) throws IOException;
}
