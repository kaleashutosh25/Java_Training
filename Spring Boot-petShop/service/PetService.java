package com.hcl.petShop.service;

import java.util.List;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.petShop.controller.UserController;
import com.hcl.petShop.exception.InvalidUserException;
import com.hcl.petShop.exception.PetNotAvailableException;
import com.hcl.petShop.model.Pet;
import com.hcl.petShop.repository.PetRepository;

@Service
public class PetService {
	
	private org.jboss.logging.Logger logger=LoggerFactory.logger(UserController.class);

	@Autowired
	private PetRepository petRepository;

	public boolean petValidate(Pet pet) throws InvalidUserException {
		String validateName = pet.getName();
		logger.info("Pet is Being validated");
		if (validateName.length() >= 4 && validateName.length() < 20) {
			return true;
		}
		throw new InvalidUserException();
	}

	public List<Pet> getAllPets() {
		return petRepository.findAll();
	}

	public Pet getPetById(int id) {
		return petRepository.findById(id).get();
	}

	public Pet addUser(Pet pet) throws InvalidUserException {
		if (petValidate(pet))
			petRepository.save(pet);
		return pet;
	}

	public Pet updatePet(Pet pet) throws InvalidUserException {
		if (petValidate(pet))
			petRepository.save(pet);
		return pet;
	}

	public void deletePetById(int id) {
		petRepository.deleteById(id);
	}

	public Pet buyPet(Pet pet) throws PetNotAvailableException {
		int i = pet.getId();
		Pet tpet = petRepository.findById(i).get();
		if (tpet.getUser() == null) {
			petRepository.save(pet);
			logger.info("Bought Pet Successfully");
		} else {
			throw new PetNotAvailableException();
		}
		return pet;
	}

}
