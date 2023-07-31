package com.epicode.Spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.Spring.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
