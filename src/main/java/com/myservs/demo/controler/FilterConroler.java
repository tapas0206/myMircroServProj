package com.myservs.demo.controler;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.myservs.demo.Dto.FilterDTO;

@RestController
public class FilterConroler {
	@GetMapping("/filters")
	public MappingJacksonValue retriveFilteredBeans() {
		FilterDTO filterDTO=new FilterDTO("value1","value2","value3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed1");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("jsonFilter",filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(filterDTO);
		mapping.setFilters(filterProvider);
		
		return mapping;
	}
	
	
	
}
