package com.epicode.Spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.Spring.models.Sonda;

@Repository
public interface SondaRepository extends CrudRepository<Sonda, Long> {

	
	
}
