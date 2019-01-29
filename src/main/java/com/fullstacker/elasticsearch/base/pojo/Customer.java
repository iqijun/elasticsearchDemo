package com.fullstacker.elasticsearch.base.pojo;

/**
 * @program: elasticsearch
 * @description:
 * @author: xingguishuai
 * @create: 2019-01-22 14:59
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.util.Date;
import java.util.List;

@Document(indexName = "es-customer", type = "customer", shards = 2, replicas = 1, refreshInterval = "-1")
public class Customer {

    @Id
    private String id;

    private String firstName;

    private Integer age;

    private Date regDate;

    private Address address;

    private List<Customer> friends;
    public Customer() {
    }
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Customer> getFriends() {
        return friends;
    }

    public void setFriends(List<Customer> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', age='%s']", this.id,
                this.firstName, this.age);
    }

    public static  void main(String[] args){
        Customer customer = new Customer();
        customer.setId("1");
        customer.setAge(10);
        customer.setFirstName("xing");
        System.out.println(customer);
    }
}
