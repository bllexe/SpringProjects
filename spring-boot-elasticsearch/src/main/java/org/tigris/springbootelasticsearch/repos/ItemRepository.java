package org.tigris.springbootelasticsearch.repos;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.tigris.springbootelasticsearch.model.Item;

public interface ItemRepository extends ElasticsearchRepository<Item, String> {

}
