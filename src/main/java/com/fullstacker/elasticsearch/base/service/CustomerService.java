package com.fullstacker.elasticsearch.base.service;


import com.fullstacker.elasticsearch.base.pojo.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService{
    /**
     * <p>功能描述：新增</p>
    * @author: xingguishuai
    * @Date: 2019/1/30 18:08
     * @since 1.0
    */
    public Customer saveCustormer(Customer customer);
    /**
     * <p>功能描述：根据ID查询顾客信息</p>
    * @author: xingguishuai
    * @Date: 2019/1/30 18:09
     * @since 1.0
    */
    public Customer findCustormerById(String id);
  /*  *//**
     * <p>功能描述：根据customer相关字段查询</p>
    * @author: xingguishuai
    * @Date: 2019/1/30 18:11
     * @since 1.0
    *//*
    public List<Customer> findCustormerByExmple(Customer example);*/

    /**
     * <p>功能描述：根据年龄范围查询</p>
    * @author: xingguishuai
    * @Date: 2019/1/31 10:51
     * @since 1.0
    */
    public List<Customer> findByAgeRange(int min,int max);
    /**
     * <p>功能描述：分页查询</p>
    * @author: xingguishuai
    * @Date: 2019/1/30 18:12
     * @since 1.0
    */
    public Page<Customer> findByPage(Customer example,int start,int raws);

  /*  *//**
     * <p>功能描述：将符合example条件的数据更新为result/p>
    * @author: xingguishuai
    * @Date: 2019/1/30 18:14
     * @since 1.0
    *//*
    public int updateByExample(Customer example,Customer result);*/
    /**
     * <p>功能描述：根据id删除</p>
    * @author: xingguishuai
    * @Date: 2019/1/30 18:16
     * @since 1.0
    */
    public  int deleteById(String id);
    /**
     * <p>功能描述：将符合example条件的数据删除</p>
    * @author: xingguishuai
    * @Date: 2019/1/30 18:17
     * @since 1.0
    */
    public int deleteByExample(Customer example);
}
