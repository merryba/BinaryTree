package com.merryba.login.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.merryba.login.model.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
     User findByEmail(String email);
     User findByEmailAndPassword(String email,String password);
}