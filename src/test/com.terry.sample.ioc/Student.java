package com.terry.sample.ioc;

import lombok.Data;

/**
 * @author terry
 * @date 18-5-12
 */
public class Student {

    private String name;

    private int age;

    private Address address;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
