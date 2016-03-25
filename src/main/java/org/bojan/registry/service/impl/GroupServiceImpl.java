package org.bojan.registry.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.bojan.registry.dao.GroupDao;
import org.bojan.registry.model.Group;
import org.bojan.registry.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	GroupDao groupDao;
	
	public List<Group> findAll() {
		// TODO Auto-generated method stub
		return groupDao.findAll();
	}

	public void addGroup(Group group) {
		// TODO Auto-generated method stub
		groupDao.addGroup(group);
	}

	public void deleteGroup(long id) {
		// TODO Auto-generated method stub
		groupDao.deleteGroup(id);
	}

	public Group findById(Long id) {
		// TODO Auto-generated method stub
		return groupDao.findById(id);
	}
	
	
	
}
