package com.springboot.webservice.restful.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webservice.restful.beans.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	
    private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}


	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanPathVaiable(@PathVariable("name") String name) {
		return new HelloWorldBean("Hello World "+name);
	}
	
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
		
		//return "Hello World V2"; 
		
		//1:
		//2:
//		- Example: `en` - English (Good Morning)
//		- Example: `nl` - Dutch (Goedemorgen)
//		- Example: `fr` - French (Bonjour)
//		- Example: `de` - Deutsch (Guten Morgen)

	}

}
