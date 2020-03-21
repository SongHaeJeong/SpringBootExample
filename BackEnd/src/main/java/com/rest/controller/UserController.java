package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.User;
import com.rest.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok().body(userService.getAllUser());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getProductById(@PathVariable long id) {
		return ResponseEntity.ok().body(userService.getUserById(id));
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok().body(userService.createUser(user));
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteProduct(@PathVariable long id) {
		this.userService.deleteUser(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateProduct(@PathVariable long id, @RequestBody User product) {
		product.setId(id);
		return ResponseEntity.ok().body(this.userService.updateProduct(product));
	}
}
