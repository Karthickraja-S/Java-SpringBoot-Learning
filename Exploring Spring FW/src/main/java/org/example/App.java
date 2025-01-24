package org.example;

import org.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-configurations.xml");


        // When i don't specify name args , it takes first object bcz we specified this as primary="true"
        Employee obj = context.getBean(Employee.class);
        System.out.println(obj.getName());
        System.out.println(obj.getAge());
        System.out.println(obj.getAddress());
        obj.doWork();
        System.out.println("-----------------------------------------");

        // We specified prototype in bean tag. so it creates new object for employee class & sets name to Karthick
        Employee obj2 = context.getBean("empObj2",Employee.class);
        System.out.println(obj2.getName());
        System.out.println(obj2.getAge());
        System.out.println(obj2.getAddress());
        System.out.println("-----------------------------------------");

        Employee obj3 = context.getBean("parameterizedObj",Employee.class);
        System.out.println(obj3.getName());
        System.out.println(obj3.getAge());
        System.out.println(obj3.getAddress());
        System.out.println("-----------------------------------------");

        // U can also verify from
        // https://github.com/navinreddy20/spring6-course/tree/main/2%20Exploring%20Spring%20Framework

        // Java Based Config ( no XMLs ) - https://github.com/navinreddy20/spring6-course/tree/main/3.1%20Working%20with%20Java-Based%20Config%20(3.1%20to%203.9)
        // Where they used a java class like a xml mapping creating new ApplicationContext by AnnotationConfigApplicationContext(<class-name>.class);
    }
}
