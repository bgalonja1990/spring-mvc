package org.bojan.registry.service;

import java.util.List;

import org.bojan.registry.model.User;

public interface UserService {
	
	public List<User> findAll();
	public void addUser(User user);
	public void updateUser(User user);
	public User getUserById(long id);
	public void removeUser(long id);
	
}
