package com.example.qatar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.qatar.entities.Arbitre;
import com.example.qatar.entities.User;
@Repository
public interface UserDao  extends CrudRepository<User,Long> {
	User findByEmail(String email);
}
