package com.example.qatar.service;




import java.util.List;

import org.springframework.stereotype.Service;

import com.example.qatar.entities.User;
import com.example.qatar.entities.UserDto;
@Service
public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String email);

    User findById(Long id);
}
