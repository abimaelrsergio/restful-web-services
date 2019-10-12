package br.com.abgi.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaResource {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
		
		// HATEOAS para SpringBoot < 2.2.0
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		Resource<User> resource = new Resource<User>(user.get());
		resource.add(linkTo.withRel("all-users"));
	
//		// HATEOAS para SpringBoot >= 2.2.0
//		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//		EntityModel<User> model = new EntityModel<>(User);
//		model.add(linkTo.withRel("all-users"));
//		return model;
		
		return resource;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUsers(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id) {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
			
		return userOptional.get().getPosts();
	}
}
