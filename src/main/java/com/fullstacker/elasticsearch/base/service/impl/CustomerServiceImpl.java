package com.fullstacker.elasticsearch.base.service.impl;

import com.fullstacker.elasticsearch.base.CustormerRepository;
import com.fullstacker.elasticsearch.base.pojo.Customer;
import com.fullstacker.elasticsearch.base.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public Customer saveCustormer(Customer customer) {
        Customer result = custormerRepository.save(customer);
        return result;
    }
}
