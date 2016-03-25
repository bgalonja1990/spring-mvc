package org.bojan.registry.dao;

import java.util.List;

import org.bojan.registry.model.Group;

public interface GroupDao {
	
	public List<Group> findAll();
	public void addGroup(Group group);
	public void deleteGroup(long id);
	public Group findById(Long id);
}
