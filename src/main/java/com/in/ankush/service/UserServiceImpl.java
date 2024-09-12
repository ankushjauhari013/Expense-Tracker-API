package com.in.ankush.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.in.ankush.entity.User;
import com.in.ankush.entity.UserModel;
import com.in.ankush.exceptions.ItemAlreadyExistsException;
import com.in.ankush.exceptions.ResourceNotFoundException;
import com.in.ankush.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private PasswordEncoder bCryptEncoder;
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(UserModel user) {
		
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistsException("User Already Registered -> " + user.getEmail());
		}
		
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword(bCryptEncoder.encode(newUser.getPassword()));
		return userRepository.save(newUser);
		
	}

	@Override
	public User readUser() {
		Long userId = getLoggedInUser().getId();
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for the id: "+ userId));
	}
	

	@Override
	public User updateUser(UserModel user) {
		User existingUser = readUser();
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
		existingUser.setPassword(user.getPassword() != null ? bCryptEncoder.encode(user.getPassword()): existingUser.getPassword());
		existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
		return userRepository.save(existingUser);	
	}

	@Override
	public void deleteUser() {
		User user = readUser();
		userRepository.delete(user);
	}

	@Override
	public User getLoggedInUser() {
		Authentication authenticate  = 	SecurityContextHolder.getContext().getAuthentication();
		String email = authenticate.getName();
		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found for the " +email));
	}
	
	
}
