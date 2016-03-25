package org.bojan.registry.controller;

import org.bojan.registry.model.Group;
import org.bojan.registry.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GroupController {

	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value="/groups")
	public String getAll(Model model){
		model.addAttribute("group", new Group());
		model.addAttribute("groups", groupService.findAll());
		return "groups";
	}
	
	@RequestMapping(value="/groups/add", method=RequestMethod.POST)
	public String addGroup(Group group){
		
		groupService.addGroup(group);
		return "redirect:/groups";
	}
	
	@RequestMapping(value="/groups/remove/{id}")
	public String addGroup(@PathVariable("id") long id){
		
		groupService.deleteGroup(id);
		return "redirect:/groups";
	}
}
