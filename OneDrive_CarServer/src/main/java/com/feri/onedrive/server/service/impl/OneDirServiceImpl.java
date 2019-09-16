package com.feri.onedrive.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.onedrive.entity.core.OneDir;
import com.feri.onedrive.server.dao.OneDirDao;
import com.feri.onedrive.server.service.OneDirService;
import org.springframework.stereotype.Service;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-16 14:46
 */
@Service
public class OneDirServiceImpl extends ServiceImpl<OneDirDao, OneDir> implements OneDirService  {
}
