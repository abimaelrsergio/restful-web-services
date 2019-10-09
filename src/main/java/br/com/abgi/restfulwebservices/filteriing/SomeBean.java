package br.com.abgi.restfulwebservices.filteriing;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SomeBean {

	private String field1;
	
	@JsonIgnore
	private String field2;
	
	//password field
	@JsonIgnore
	private String fiels3;

	public SomeBean(String field1, String field2, String fiels3) {
		this.field1 = field1;
		this.field2 = field2;
		this.fiels3 = fiels3;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getFiels3() {
		return fiels3;
	}

	public void setFiels3(String fiels3) {
		this.fiels3 = fiels3;
	}

}
