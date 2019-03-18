package com.poc.elasticsample.controller;

import java.io.IOException;
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

import com.poc.elasticsample.models.User;
import com.poc.elasticsample.responses.Response;
import com.poc.elasticsample.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Response> save(@RequestBody User user) throws IOException{
		String id = userService.save(user);
		Response response = new Response(201, "user created with : "+id);
		return new ResponseEntity<>(response, HttpStatus.CREATED);	
	}
	@PutMapping("{id}")
	public ResponseEntity<Response> update(@PathVariable String id, @RequestBody User user) throws IOException{
		String uId = userService.update(user, id);
		Response response = new Response(201, "user Updated with : "+uId);
		return new ResponseEntity<>(response, HttpStatus.CREATED);	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Response> delete(@PathVariable String id) throws IOException{
		userService.delete(id);
		return new ResponseEntity<Response>(new Response(200, "Deleted"), HttpStatus.OK);
	}
	@GetMapping("{id}")
	public User getAll(@PathVariable String id) throws IOException{
		return userService.get(id);
	}
	@GetMapping("/search/{text}")
	public List<User> inLineSearch(@PathVariable String text) throws IOException{
		return userService.inLineSearch(text);
	}
}
