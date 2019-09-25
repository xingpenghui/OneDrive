package com.feri.onedrive.api.service;

import com.feri.onedrive.api.model.CarIndex;
import com.feri.onedrive.common.vo.R;

import java.util.List;

public interface CarIndexService {
    R<List<CarIndex>> queryAll(int page,int size);
    R<List<CarIndex>> queryLike(int page,int size,String msg);
}
