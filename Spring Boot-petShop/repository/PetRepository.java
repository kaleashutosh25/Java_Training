package com.hcl.petShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.petShop.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

}
