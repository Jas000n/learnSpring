package com.Jas0n.test;

import com.Jas0n.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        Student student = new Student();
//        System.out.println(student);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean(Student.class);
        //Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
