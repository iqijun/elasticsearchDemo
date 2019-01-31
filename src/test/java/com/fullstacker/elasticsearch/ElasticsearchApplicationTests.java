package com.fullstacker.elasticsearch;

import com.fullstacker.elasticsearch.base.pojo.Address;
import com.fullstacker.elasticsearch.base.pojo.Customer;
import com.fullstacker.elasticsearch.base.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

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

        String [] names = {"zhao","qian","sun","li","zhou","wu","zheng","wang"};
        String [] province = {"beijing","tianjin","hebei","henan","shandong"};
        String [] city = {"beijing","tianjin","xingtai","zhengzhou","dezhou","jinan","qingdao","yantai"};
        Customer customer = new Customer();
        int index = 0;
        Random random = new Random(100);

        for (String name:names){
            customer.setId("12"+index);
            customer.setFirstName(name);
            customer.setAge(random.nextInt(100));
            customer.setRegDate(new Date());
            Address address = new Address();
            address.setCity(city[index]);
            address.setCountry("cn");
            String provinceName = index<=3?province[index]:province[4];
            address.setProvince(provinceName);
            address.setDetail("中国"+provinceName+city[index]);
            customer.setAddress(address);
           customerService.saveCustormer(customer);
            index++;
        }

    }

    @Test
    public  void testFindById(){
        Customer custormerById = customerService.findCustormerById("1245");
        System.out.println(custormerById);
    }

    @Test
    public void testFindByPage(){
        Customer example = new Customer();
//        example.setId("120");
        example.setAge(50);
//        Address address = new Address();
//        address.setCity("yantai");
//        example.setAddress(address);
        Page<Customer> page = customerService.findByPage(example, 0, 2);
        Iterator<Customer> iterator = page.iterator();
        while ( iterator.hasNext()){
            System.out.println("results:"+iterator.next());
        }
    }
}

