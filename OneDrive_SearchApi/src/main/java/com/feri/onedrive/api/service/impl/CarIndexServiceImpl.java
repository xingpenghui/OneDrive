package com.feri.onedrive.api.service.impl;

import com.feri.onedrive.api.dao.CarIndexDao;
import com.feri.onedrive.api.model.CarIndex;
import com.feri.onedrive.api.service.CarIndexService;
import com.feri.onedrive.common.util.RUtil;
import com.feri.onedrive.common.vo.R;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 10:16
 */
@Service
public class CarIndexServiceImpl implements CarIndexService {
    @Autowired
    private CarIndexDao carIndexDao;

    @Override
    public R<List<CarIndex>> queryAll(int page, int size) {
        //创建分页对象
        Pageable pageable= PageRequest.of(page,size, Sort.by("id").ascending());
        return RUtil.setOK("OK",carIndexDao.findAll(pageable).iterator());
    }

    @Override
    public R<List<CarIndex>> queryLike(int page, int size, String msg) {
        //创建查询条件对象 id 进行模糊查询
        WildcardQueryBuilder wildcardQueryBuilder= QueryBuilders.wildcardQuery("id","%"+msg+"%");
        return RUtil.setOK("OK",carIndexDao.search(wildcardQueryBuilder, PageRequest.of(page,size,Sort.by("id").ascending())));
    }
}
