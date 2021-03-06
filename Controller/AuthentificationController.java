package com.example.qatar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.qatar.config.TokenProvider;
import com.example.qatar.entities.AuthToken;
import com.example.qatar.entities.LoginUser;
import com.example.qatar.service.UserService;


@RestController
@RequestMapping("/token")
public class AuthentificationController {

	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private TokenProvider jwtTokenUtil;

	    @Autowired
	    private UserService userService;

	    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginUser.getEmail(),
	                        loginUser.getPwd()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = jwtTokenUtil.generateToken(authentication);
	        return ResponseEntity.ok(new AuthToken(token));
	    }
}
