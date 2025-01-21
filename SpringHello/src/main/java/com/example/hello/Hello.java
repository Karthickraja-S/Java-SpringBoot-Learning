package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// Putting component annotation, will create a object in the container, else it won't create..
@Component
public class Hello {
	
	
	// The HelloExtn created object in container need to be linked here by spring. so we need to tell spring
	// to attach the object to the below variable.
	@Autowired
	HelloExtn helloExtn;
	int i = 0;
	public void sayHello(String name) {
		System.out.println("Hi "+name + "...!");
		i++;
		System.out.println("i value : "+i);
		
		// what if Hello is dependent to some other object.
		helloExtn.saySpecialHello();
	}
}
