package com.example.hello;

import org.springframework.stereotype.Component;


// To create object by spring itself
@Component
public class HelloExtn {
	
	public void saySpecialHello() {
		System.out.println("Hey , Giving you 1000 rs with a hello , enjoy...");
	}

}
