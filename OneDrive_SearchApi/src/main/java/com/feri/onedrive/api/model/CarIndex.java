package com.feri.onedrive.api.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 10:14
 */
@Document(indexName = "onedrivecar",type = "car")
@Data
public class CarIndex {
    private int id;
    private String name;
    private String brand;
    private String ctype;
}
