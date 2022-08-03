package com.demo.pruebatecnicamc.be.repositories.mysql.respositories;

import com.demo.pruebatecnicamc.be.repositories.mysql.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();
    User findById(Long id);
    User findByEmail(String email);
    User findByName(String name);
    int deleteByEmail(String email);
}
