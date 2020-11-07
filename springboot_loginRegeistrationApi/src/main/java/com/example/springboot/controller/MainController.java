package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;

@RestController
public class MainController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.insertUser(user);
	}

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/userById/{id}")
	public User findUserById(@PathVariable int id) {
		return userService.getUser(id);
	}

	@GetMapping("/user/{name}")
	public User findUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}

	@PutMapping("/update")
	public User updateProduct(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
}
