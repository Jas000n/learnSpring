# Spring

### 1. Spring两大核心机制

* IoC ：工厂模式
* AOP：代理模式



#### 1.1 Ioc

控制反转，spring框架的灵魂

##### 1.1.1 开发步骤

1. 创建maven，导入依赖

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.2.3.RELEASE</version>
</dependency>
```

2. 在resources文件夹下创建spring.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
       http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
   ">
    <bean id="student" class="com.Jas0n.entity.Student">
        <property name="id" value="1"></property>
        <property name="age" value="22"></property>
        <property name="name" value="jason"></property>
    </bean>
</beans>
```

* 无参构造

  此时下面这段代码会调用无参构造方法后，调用set方法为字段赋值，分别为通过类型取值、通过id取值

```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
Student student = (Student) applicationContext.getBean(Student.class);//通过类型取值
Student student = (Student) applicationContext.getBean("student");//通过id取值
System.out.println(student);
```