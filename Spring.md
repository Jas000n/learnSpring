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

* 有参构造

```xml
<bean id="student_with_arg" class="com.Jas0n.entity.Student">
    <constructor-arg name="id" value = "3"></constructor-arg>
    <constructor-arg name="name" value ="JJas00nn"></constructor-arg>
    <constructor-arg name="age" value="188"></constructor-arg>
</bean>
```

如果包含特殊字符：

```xml
<constructor-arg name ="Classes">
<value><![CDATA[\\\\\\\\\]]></value>  
<constructor-arg>
```

##### 1.1.2 IoC DI

DI指bean之间的依赖注入

```xml
<constructor-arg name ="Classes" ref="classes"><constructor-arg>
```

以这种方式传引用。

如需要注入到数据结构里，如string[]，可以这样写：

```xml
<list>
	<ref bean="student1"></ref>
  <ref bean="student2"></ref>
</list>
```

#### 1.2 Spring中的bean

bean是根据scope来生成的，表示bean的作用域，scope有4种类型：

* singleton：单例
* prototype：原型模式，表示通过ioc容器获得的对象是不同的
* request：表示在一次http请求内有效
* session：表示在一个用户会话内有效

后两种适用于web项目