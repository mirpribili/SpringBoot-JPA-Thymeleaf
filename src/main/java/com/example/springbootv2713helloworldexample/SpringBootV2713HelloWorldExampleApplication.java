package com.example.springbootv2713helloworldexample;

import com.example.springbootv2713helloworldexample.exception.UrlAccessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class SpringBootV2713HelloWorldExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootV2713HelloWorldExampleApplication.class, args);
	}
	@EventListener(classes = ContextRefreshedEvent.class)
	public void listen(){
		// check if url is accessible
		// if ok
		throw new UrlAccessException("http://wwww.ios.com");
	}

}
