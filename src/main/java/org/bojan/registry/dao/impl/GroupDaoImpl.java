package org.bojan.registry.dao.impl;

import java.util.List;

import org.bojan.registry.dao.GroupDao;
import org.bojan.registry.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl implements GroupDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<Group> findAll() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(Group.class).list();
	}

	public void addGroup(Group group) {
		// TODO Auto-generated method stub
		 getSession().save(group);
	}

	public void deleteGroup(long id) {
		// TODO Auto-generated method stub
		Group group = (Group)getSession().get(Group.class, id);
		if(group!=null){
			getSession().delete(group);
		}
	}

	public Group findById(Long id) {
		// TODO Auto-generated method stub
		return (Group)getSession().get(Group.class, id);
	}
	
	
	
}
