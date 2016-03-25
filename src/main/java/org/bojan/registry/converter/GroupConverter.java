package org.bojan.registry.converter;

import org.bojan.registry.model.Group;
import org.bojan.registry.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter implements Converter<Object, Group>{
	
	@Autowired
	GroupService groupService;
	
	public Group convert(Object element) {
		// TODO Auto-generated method stub
		Long id = (Long) element;
		Group group = groupService.findById(id);
		return group;
	}
	
}
