package com.feri.onedrive.api.dao;

import com.feri.onedrive.api.model.NewsIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-25 17:22
 */
public interface NewsIndexDao extends ElasticsearchRepository<NewsIndex,String> {

}
