package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringHelloApplication {

	public static void main(String[] args) {

		// https://www.geeksforgeeks.org/singleton-and-prototype-bean-scopes-in-java-spring/

		
		ApplicationContext context = SpringApplication.run(SpringHelloApplication.class, args);
		System.out.println("Hello World !! ");
		
		
		// the ApplicationContext class will have all the objects created in the container.
		
		// Only if the object is available in container , it gives u object else throws 
		// NoSuchBeanDefinitionException
		
		// when calling getBean , it injects the Hello Object here. ( Dependency Injection ) 
		Hello objHello = context.getBean(Hello.class);
		objHello.sayHello("Karthick");
		
		
		// just to check whether i is again 1 ( to verify whether object creating multiple times )
		Hello objHello2 = context.getBean(Hello.class);
		objHello2.sayHello("Karthick");
		// The above code returns i as 2  ( MEANING -> only one object is created and returning those objects )
		
		
	}

}
