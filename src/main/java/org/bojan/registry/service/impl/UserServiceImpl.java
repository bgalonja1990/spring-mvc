package org.bojan.registry.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.bojan.registry.dao.UserDao;
import org.bojan.registry.model.User;
import org.bojan.registry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	public void removeUser(long id) {
		// TODO Auto-generated method stub
		userDao.removeUser(id);
	}

}
