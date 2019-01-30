package com.fullstacker.elasticsearch.base.service.impl;

import com.fullstacker.elasticsearch.base.CustormerRepository;
import com.fullstacker.elasticsearch.base.pojo.Customer;
import com.fullstacker.elasticsearch.base.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Customer findCustormerById(String id) {
        Optional<Customer> customerOptional = custormerRepository.findById(id);
        Customer customer = customerOptional.get();
        return customer;
    }

    @Override
    public List<Customer> findCustormerByExmple(Customer example) {
        return null;
    }

    @Override
    public Page<Customer> findByPage(Customer example, int start, int raws) {
        return null;
    }

    @Override
    public int updateByExample(Customer example, Customer result) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public int deleteByExample(Customer example) {
        return 0;
    }
}
