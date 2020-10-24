package com.meguerreroa.LoginAppWeb.repositories;

import com.meguerreroa.LoginAppWeb.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}