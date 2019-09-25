package com.feri.onedrive.api.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 17:21
 */
@Document(indexName = "onedrivecar",type = "news")
@Data
public class NewsIndex {
    private String id;
    private String title;
    private String time;
    private String url;
}
