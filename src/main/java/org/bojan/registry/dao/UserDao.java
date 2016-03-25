package org.bojan.registry.dao;

import java.util.List;

import org.bojan.registry.model.User;

public interface UserDao {
	
	public List<User> findAll();
	public void addUser(User user);
	public void updateUser(User user);
	public User getUserById(long id);
	public void removeUser(long id);
	
}
