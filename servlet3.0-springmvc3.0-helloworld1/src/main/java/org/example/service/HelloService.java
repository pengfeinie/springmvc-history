package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	
	public String getHelloMessage(String name) {
		return name + " Jack";
		
	}
	

}
