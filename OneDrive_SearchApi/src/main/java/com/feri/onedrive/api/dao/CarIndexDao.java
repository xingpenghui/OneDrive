package com.feri.onedrive.api.dao;

import com.feri.onedrive.api.model.CarIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CarIndexDao extends ElasticsearchRepository<CarIndex,Integer> {
}
