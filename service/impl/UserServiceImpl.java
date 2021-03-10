 package com.example.qatar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.qatar.dao.UserDao;
import com.example.qatar.entities.User;
import com.example.qatar.entities.UserDto;
import com.example.qatar.service.UserService;

import java.util.*;

import javax.security.auth.login.AccountNotFoundException;

@Component
@Service(value = "userService")
public class UserServiceImpl implements   UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder crypt;

	@Bean
	PasswordEncoder passwordEncoder() 
	{
	    return new BCryptPasswordEncoder();
	}
	public UserDetails loadUserByEmail(String email) throws AccountNotFoundException {
		User user = userDao.findByEmail(email);
		if(user == null){
			throw new AccountNotFoundException("Invalid email or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPwd(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNom()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}

	@Override
    public User save(UserDto user) {
	    User newUser = new User();
	    newUser.setNom(user.getNom());
	    newUser.setPwd(crypt.encode(user.getPwd()));
	    
		newUser.setPrenom(user.getPrenom());
		newUser.setEmail(user.getEmail());
        return userDao.save(newUser);
    }

	
}
