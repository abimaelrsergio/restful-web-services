package br.com.abgi.restfulwebservices.helloworld;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}
