package com.fullstacker.elasticsearch.base;


import com.fullstacker.elasticsearch.base.pojo.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: elasticsearch
 * @description:
 * @author: xingguishuai
 * @create: 2019-01-22 15:13
 */
@Service
public interface CustormerRepository extends ElasticsearchRepository<Customer,String> {

    public List<Customer>  findByAgeBetween(int min,int max);

    public List<Customer> findCustomerByAgeGreaterThanEqual(int age);

    List<Customer> findCustomerByFirstNameContains(String name);



}
