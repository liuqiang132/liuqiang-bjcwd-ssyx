package com.liuqiang.ssyx.search.mapper;

import com.liuqiang.ssyx.model.search.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: es操作接口
 * @date 2023/9/14 12:27
 */
@Repository
public interface SkuMapper extends ElasticsearchRepository<SkuEs,Long> {
}
