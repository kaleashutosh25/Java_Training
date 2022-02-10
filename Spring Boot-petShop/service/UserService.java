package com.hcl.petShop.service;

import java.util.List;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.petShop.exception.InvalidUserException;
import com.hcl.petShop.model.Pet;
import com.hcl.petShop.model.User;
import com.hcl.petShop.repository.UserRepository;

@Service
public class UserService {
	
	private org.jboss.logging.Logger logger =LoggerFactory.logger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public boolean userValidate(User user) throws InvalidUserException {
		String validateName = user.getName();
		logger.info("User is Being validated");
		if (validateName.length() >= 4 && validateName.length() < 20) {
			return true;
		}
		throw new InvalidUserException();

	}

	public List<User> listusers() {

		return userRepository.findAll();
	}

	public User getUserById(int id) {

		return userRepository.findById(id).get();
	}

	public Pet getMyPets(int id) {
		User petUser = userRepository.findById(id).get();
		return petUser.getPet();
	}

	public List<User> findByUserName(String name) {
		return userRepository.findByName(name);
	}

	public User addUser(User user) throws InvalidUserException {
		if (userValidate(user))
			userRepository.save(user);
		logger.info("User added successfully");
		
		return user;
	}

	public User updateUser(User user) throws InvalidUserException {
		if (userValidate(user))
			userRepository.save(user);
		logger.info("User updated successfully");
		return user;
	}

	public void removeUser(int id) {
		userRepository.deleteById(id);
	}

}
