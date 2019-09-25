package com.feri.onedrive.api.service.impl;

import com.feri.onedrive.api.dao.NewsIndexDao;
import com.feri.onedrive.api.service.NewsIndexService;
import com.feri.onedrive.common.util.RUtil;
import com.feri.onedrive.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 17:40
 */
@Service
public class NewsIndexServiceImpl implements NewsIndexService {
    @Autowired
    private NewsIndexDao newsIndexDao;
    @Override
    public R queryAll(int page, int size) {

        return RUtil.setOK("OK",newsIndexDao.findAll(PageRequest.of(page, size, Sort.by("id").ascending())));
    }
}
