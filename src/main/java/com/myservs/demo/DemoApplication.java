package com.myservs.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class DemoApplication {
	//Added to the GIT Repository
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver() {
		AcceptHeaderLocaleResolver localResolver =new AcceptHeaderLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localResolver;
	}
	
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource msgSource=new ResourceBundleMessageSource();
//		msgSource.setBasename("message");
//		return msgSource;
//	}

}
