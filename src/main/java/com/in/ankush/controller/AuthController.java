package com.in.ankush.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.ankush.entity.AuthModel;
import com.in.ankush.entity.JwtResponse;
import com.in.ankush.entity.User;
import com.in.ankush.entity.UserModel;
import com.in.ankush.security.CustomUserDetailsService;
import com.in.ankush.service.UserService;
import com.in.ankush.util.JwtTokenUtil;
import jakarta.validation.Valid;

@RestController
public class AuthController {
	
	/*@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<String> login(){
		return new ResponseEntity<String>("User is logged in",HttpStatus.OK);
	}*/
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;


	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody AuthModel authModel) throws Exception{
		
//  	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken (authModel.getEmail(), authModel.getPassword()));
	
			authenticate(authModel.getEmail(), authModel.getPassword());
	
	//	SecurityContextHolder.getContext().setAuthentication(authentication);
			
	// generate JWT Token		
	 final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authModel.getEmail());
			
	 final String token = jwtTokenUtil.generateToken(userDetails);
			
	
	return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.OK);

	}

	private void authenticate(String email, String password) throws Exception{

		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken (email, password));
			
		} catch (DisabledException e) {
			throw new Exception("User disabled");
		}catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}
	}

	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
	}
	
}



