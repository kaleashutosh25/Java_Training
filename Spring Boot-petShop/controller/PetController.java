package com.hcl.petShop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.petShop.exception.InvalidUserException;
import com.hcl.petShop.exception.PetNotAvailableException;
import com.hcl.petShop.model.Pet;
import com.hcl.petShop.service.PetService;

@RestController
public class PetController {

	@Autowired
	PetService petService;

	@GetMapping("/pet")
	public String showPet() {
		return "Welcome to Pet Shop !";
	}

	@GetMapping("/pets")
	public List<Pet> petHome() {
		return petService.getAllPets();
	}

	@GetMapping("/pets/petDetail/{id}")
	public Pet petDetail(@PathVariable int id) {
		return petService.getPetById(id);
	}

	@PostMapping("/pets/addPet")
	public Pet addPet(@RequestBody Pet pet) throws InvalidUserException {
		return petService.addUser(pet);
	}

	@PutMapping("/pets/updatePet")
	public Pet updatePetDetails(@RequestBody Pet pet) throws InvalidUserException {
		return petService.updatePet(pet);
	}

	@PutMapping("/pets/buyPet")
	public Pet buyPet(@RequestBody Pet pet) throws PetNotAvailableException {
		return petService.buyPet(pet);
	}

	@DeleteMapping("/pets/deletePet/{id}")
	public void deletePetById(@PathVariable int id) {
		petService.deletePetById(id);
	}

}
