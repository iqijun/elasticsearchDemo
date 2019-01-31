package com.fullstacker.elasticsearch.base.service.impl;

import com.fullstacker.elasticsearch.base.CustormerRepository;
import com.fullstacker.elasticsearch.base.pojo.Customer;
import com.fullstacker.elasticsearch.base.service.CustomerService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * @program: elasticsearch
 * @description:
 * @author: xingguishuai
 * @create: 2019-01-28 10:39
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustormerRepository custormerRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public Customer saveCustormer(Customer customer) {
        Customer result = custormerRepository.save(customer);
        return result;
    }

    @Override
    public Customer findCustormerById(String id) {
        Optional<Customer> customerOptional = custormerRepository.findById(id);
        //Ootional类判空，如果直接调用customerOptional.get();在value是null值的时候会报错（类似于空指针）
        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            return customer;
        }
        return  null;
    }

    @Override
    public List<Customer> findByAgeRange(int min, int max) {
        return custormerRepository.findByAgeBetween(min,max);
    }


    @Override
    public Page<Customer> findByPage(Customer example, int start, int raws) {
        BoolQueryBuilder boolQueryBuilder = boolQuery();
        if(null != example.getId()){
            boolQueryBuilder.must(matchQuery("id",example.getId()));
        }else {
            if(null != example.getAge()){
                boolQueryBuilder.must(matchQuery("age",example.getAge()));
            }
            if(null != example.getAddress()){
                if(null != example.getAddress().getCity()){
                    boolQueryBuilder.should(matchQuery("address.city",new String[]{example.getAddress().getCity()}));
                }
            }
        }


        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withIndices("es-customer")
//                .withQuery(boolQueryBuilder)
                .withFilter(boolQueryBuilder)
                .withFilter(rangeQuery("23").lte(12))
                .withPageable(PageRequest.of(start,raws))
                .build();
        return elasticsearchTemplate.queryForPage(searchQuery,Customer.class);
    }

   /* @Override
    public int updateByExample(Customer example, Customer result) {
        return 0;
    }*/

    @Override
    public int deleteById(String id) {
        custormerRepository.deleteById(id);
        return 0;
    }

    @Override
    public int deleteByExample(Customer example) {
        custormerRepository.delete(example);
        return 0;
    }
}
