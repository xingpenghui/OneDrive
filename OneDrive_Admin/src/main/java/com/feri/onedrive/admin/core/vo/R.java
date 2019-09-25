package com.feri.onedrive.admin.core.vo;

import lombok.Data;

/**
 * @program: TalentShow
 * @description: 统一结果
 * @author: Feri
 * @create: 2019-09-10 11:26
 */
@Data
public class R<T> {
    private int code;
    private String msg;
    private T data;
}
