package com.fullstacker.elasticsearch;

import com.fullstacker.elasticsearch.base.pojo.Address;
import com.fullstacker.elasticsearch.base.pojo.Customer;
import com.fullstacker.elasticsearch.base.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setId("1245");
        customer.setFirstName("xing");
        customer.setAge(18);
        customer.setRegDate(new Date());
        Address address = new Address();
        address.setCity("bj");
        address.setCountry("cn");
        address.setProvince("bj");
        address.setDetail("bjguojidasha");
        customer.setAddress(address);
        Customer customer1 = customerService.saveCustormer(customer);
        System.out.println(customer1);
    }

    @Test
    public  void strSplitTest(){

    }
}

