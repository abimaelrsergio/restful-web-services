package br.com.abgi.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@ApiModel(description="Detalhes sobre o usuário")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@ApiModelProperty(notes="O nome deve ter pelo menos dois caracteres")
	@Size(min=2, message="O nome deve ter pelo menos dois caracteres")
	private String name;

	@ApiModelProperty(notes="A data de nascimento deve ser no passado")
	@Past
	private Date birthDate;

	public User() {}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

}
