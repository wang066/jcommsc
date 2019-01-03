package cn.jcomm.dao;

import java.util.List;

import cn.jcomm.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by jowang on 2017/8/1 0001.
 */
public interface CustomerElasticsearchRepository extends ElasticsearchRepository<Customer, String> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}