package com.myservs.demo.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myservs.demo.Versoning.NamesDTO;
import com.myservs.demo.Versoning.PersonDTOv1;
import com.myservs.demo.Versoning.PersonDTOv2;

@RestController
public class VersionControler {
	
	//TODO URI Version
	@GetMapping("V1/Person")
	public PersonDTOv1 personV1()  {
		return new PersonDTOv1("Tapas Agrawal");
	}
	@GetMapping("V2/Person")
	public PersonDTOv2 personV2()  {
		return new PersonDTOv2(new NamesDTO("Tapas"," Agrawal"));
	}
	
	//TODO Request Parameter Versions
	@GetMapping(value="/Person/param",params="Version=1")
	public PersonDTOv1 paramV1()  {
		return new PersonDTOv1("Tapas Agrawal");
	}
	@GetMapping(value="/Person/param",params="Version=2")
	public PersonDTOv2 paramV2()  {
		return new PersonDTOv2(new NamesDTO("Tapas"," Agrawal"));
	}
	
	//TODO Header Version
	@GetMapping(value="/Person/header",headers="X-API-VERSION=1")
	public PersonDTOv1 headerV1()  {
		return new PersonDTOv1("Tapas Agrawal");
	}
	@GetMapping(value="/Person/header",headers="X-API-VERSION=2")
	public PersonDTOv2 headerV2()  {
		return new PersonDTOv2(new NamesDTO("Tapas"," Agrawal"));
	}
	
	//TODO Mime Type Version
	@GetMapping(value="/Person/produces",produces="application/vnd.company.app-v1+json")
	public PersonDTOv1 producesV1()  {
		return new PersonDTOv1("Tapas Agrawal");
	}
	@GetMapping(value="/Person/produces",produces="application/vnd.company.app-v2+json")
	public PersonDTOv2 producesV2()  {
		return new PersonDTOv2(new NamesDTO("Tapas"," Agrawal"));
	}
	
	
}
