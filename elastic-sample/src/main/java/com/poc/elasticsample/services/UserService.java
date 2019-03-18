package com.poc.elasticsample.services;

import java.io.IOException;
import java.util.List;

import com.poc.elasticsample.models.User;

public interface UserService {

	String save(User user) throws IOException;

	String update(User user, String id) throws IOException;

	void delete(String id) throws IOException;

	User get(String id) throws IOException;

	List<User> inLineSearch(String text) throws IOException;

}
