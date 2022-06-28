package com.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.entities.User;
import com.transport.exceptions.EntityNotFoundException;
import com.transport.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User findByid(Long id) {
		return userRepository.findById(id).
				orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
	}


	public void delete(Long id) {
		if (userRepository.findById(id).isEmpty()) {
			throw new EntityNotFoundException("User not found:  " + id);
		}
		userRepository.deleteById(id);
	}

	public void update(User user) {
		userRepository.findById(user.getId());
		userRepository.save(user);
	}

}
