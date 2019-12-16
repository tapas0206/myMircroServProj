package com.myservs.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld //implements ErrorController {
{
//	  private static final String PATH = "/error";

		@Autowired
		private MessageSource messageSrc;
	  
	  
//		@GetMapping(value="/hello")
//		public String helloWorld(@RequestHeader(name="Accept-language",required=false) Locale locale) { 	
//			return messageSrc.getMessage("msg.Greeting", null,locale);
//		}
		@GetMapping(value="/hello")
		public String helloWorld() { 	
			return messageSrc.getMessage("msg.Greeting", null,LocaleContextHolder.getLocale());
		}
		
		
		@GetMapping(value="/hello/{name}")
		public String helloWorld(@PathVariable String name) { 	
			return "helloWorld"+name;
		}
	
//	@RequestMapping(value = PATH)
//    public String error() {
//        return "404 Not Found";
//    }
//
//	@Override
//	public String getErrorPath() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
