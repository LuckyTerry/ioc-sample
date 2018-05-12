package com.terry.sample.ioc;

import com.terry.sample.ioc.core.BeanFactory;
import com.terry.sample.ioc.core.BeanFactoryImpl;
import com.terry.sample.ioc.exception.BeansUndefinedException;
import com.terry.sample.ioc.exception.TypePluralException;
import org.junit.Test;

/**
 * @author terry
 * @date 18-5-12
 */
public class IocTest {

    @SuppressWarnings("Duplicates")
    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new BeanFactoryImpl();

        Student student;

        try {
            student = (Student) beanFactory.getBean("student1");
            System.out.println("My name is " + student.getName() + ". i am from " + student.getAddress().getName() + ", and i am " + student.getAge() + " years old.");
        } catch (BeansUndefinedException e) {
            System.out.println("未找到student1");
        }

        try {
            student = beanFactory.getBean(Student.class);
            System.out.println("My name is " + student.getName() + ". i am from " + student.getAddress().getName() + ", and i am " + student.getAge() + " years old.");
        } catch (BeansUndefinedException e) {
            System.out.println("未找到student");
        } catch (TypePluralException e) {
            System.out.println("有多个Student实例");
        }

        try {
            student = beanFactory.getBean("student2", Student.class);
            System.out.println("My name is " + student.getName() + ". i am from " + student.getAddress().getName() + ", and i am " + student.getAge() + " years old.");
        } catch (BeansUndefinedException e) {
            System.out.println("未找到student2");
        }

        try {
            student = beanFactory.getBean(Student.class);
            System.out.println("My name is " + student.getName() + ". i am from " + student.getAddress().getName() + ", and i am " + student.getAge() + " years old.");
        } catch (BeansUndefinedException e) {
            System.out.println("未找到student");
        } catch (TypePluralException e) {
            System.out.println("有多个Student实例");
        }

        Address address;
        try {
            address = (Address) beanFactory.getBean("address1");
            System.out.println(address.getName());
        } catch (BeansUndefinedException e) {
            System.out.println("未找到address1");
        }

        try {
            address = (Address) beanFactory.getBean("address2");
            System.out.println(address.getName());
        } catch (BeansUndefinedException e) {
            System.out.println("未找到address2");
        }

        try {
            address = (Address) beanFactory.getBean("address3");
            System.out.println(address.getName());
        } catch (BeansUndefinedException e) {
            System.out.println("未找到address3");
        }
    }
}
