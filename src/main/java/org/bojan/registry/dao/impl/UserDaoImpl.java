package org.bojan.registry.dao.impl;

import java.util.List;

import org.bojan.registry.dao.UserDao;
import org.bojan.registry.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private  Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.getSession().createCriteria(User.class).list();
		
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.getSession().save(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.getSession().update(user);
	}

	public User getUserById(long id) {
		// TODO Auto-generated method stub
		User user = (User) this.getSession().get(User.class, id);
		Hibernate.initialize(user.getGroups());
		return user;
	}



	public void removeUser(long id) {
		// TODO Auto-generated method stub
		User user = (User) this.getSession().get(User.class, id);
		if (user!=null) 
			this.getSession().delete(user);
	}

}
