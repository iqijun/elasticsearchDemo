package com.fullstacker.elasticsearch.base;


import com.fullstacker.elasticsearch.base.pojo.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * @program: elasticsearch
 * @description:
 * @author: xingguishuai
 * @create: 2019-01-22 15:13
 */
@Service
public interface CustormerRepository extends ElasticsearchRepository<Customer,String> {

}
