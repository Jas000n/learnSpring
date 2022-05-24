package com.Jas0n.test;

import com.Jas0n.entity.Student;
import com.Jas0n.entity.myClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
//        Student student = new Student();
//        System.out.println(student);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dl.xml");
        myClass myclass1 =(myClass) applicationContext.getBean("class");
        System.out.println(myclass1);
    }
}
