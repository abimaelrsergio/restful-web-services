# restful-web-services

1) URL para o actuator:

	a) http://localhost:8080/actuator
	
	b) http://localhost:8080
	
	c) Não habilitar tudo em produção, principalmente não habilitar o httptrace (implica na performance)
	
2) URLs para o SWAGGER:
	
	a) http://localhost:8080/v2/api-docs
	
	b) http://localhost:8080/swagger-ui.html
	
3) Auto complete do application.properties:

	a) Instale o: Spring Tools Eclipse plugin
	
5) No Spring 2.0.0.M4, o nome das duas propriedades do spring security foram atualizadas (para Basic Authentication):
	
	a) o usuario padrão é user
	
	b) spring.security.user.name=username
	
	c) spring.security.user.password=password
	
6) H2 database:
	
	a) localhost:8080/h2-console
	
	b) JDBC URL: jdbc:h2:mem:testdb
	
