package com.in.ankush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.in.ankush.entity.User;
import com.in.ankush.entity.UserModel;
import com.in.ankush.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;

	
	/*
	 * @GetMapping("/users/{id}") public ResponseEntity<User> readUser(@PathVariable
	 * Long id){ return new
	 * ResponseEntity<User>(userService.readUser(id),HttpStatus.OK); }
	 * 
	 * @PutMapping("/users/{id}") public ResponseEntity<User>
	 * updateUser(@RequestBody User user, @PathVariable Long id){ User mUser =
	 * userService.updateUser(user, id); return new
	 * ResponseEntity<User>(mUser,HttpStatus.OK); }
	 * 
	 * @DeleteMapping("/users/{id}") public ResponseEntity<HttpStatus>
	 * deleteUser(@PathVariable Long id){ userService.deleteUser(id); return new
	 * ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT); }
	 */
	
	
	@GetMapping("/profile")
	public ResponseEntity<User> readUser(){
		return new ResponseEntity<User>(userService.readUser(),HttpStatus.OK);
	}
	
	@PutMapping("/profile")
	public ResponseEntity<User> updateUser(@RequestBody UserModel user ){
		return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);
	}
	
	@DeleteMapping("/deactivate")
	public ResponseEntity<HttpStatus> deleteUser(){
		userService.deleteUser();
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	} 
	
	
}
