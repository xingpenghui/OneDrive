package com.feri.onedrive.api.service;

import com.feri.onedrive.common.vo.R;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 17:40
 */
public interface NewsIndexService {
    R queryAll(int page, int size);
}
