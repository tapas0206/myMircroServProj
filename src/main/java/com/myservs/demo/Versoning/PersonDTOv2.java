package com.myservs.demo.Versoning;

public class PersonDTOv2 {
	private NamesDTO name;

	public PersonDTOv2() {
	}

	public PersonDTOv2(NamesDTO name) {
		super();
		this.name = name;
	}

	public NamesDTO getName() {
		return name;
	}

	public void setName(NamesDTO name) {
		this.name = name;
	}

}
