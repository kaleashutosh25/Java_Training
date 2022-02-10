package com.hcl.petShop.controller;

import java.util.List;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.petShop.exception.InvalidUserException;
import com.hcl.petShop.model.Pet;
import com.hcl.petShop.model.User;
import com.hcl.petShop.service.UserService;

@RestController
public class UserController {
	
	private org.jboss.logging.Logger logger=LoggerFactory.logger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showUser() {
		return "Welcome to Pet Shop !";
	}

	@GetMapping("/users")
	public List<User> listusers() {
		logger.info("List Users accessed");

		return userService.listusers();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {

		return userService.getUserById(id);
	}

	@GetMapping("/user/name/{name}")
	public List<User> findByUserName(@PathVariable String name) {

		return userService.findByUserName(name);
	}

	@GetMapping("/pets/myPets/{id}")
	public Pet myPets(@PathVariable int id) {

		return userService.getMyPets(id);
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user) throws InvalidUserException {

		return userService.addUser(user);

	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) throws InvalidUserException {

		return userService.updateUser(user);
	}

	@DeleteMapping("delete/{id}")
	public void removeUser(@PathVariable int id) {

		userService.removeUser(id);
	}

}
