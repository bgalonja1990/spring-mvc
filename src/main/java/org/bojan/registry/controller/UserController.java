package org.bojan.registry.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bojan.registry.model.Group;
import org.bojan.registry.model.User;
import org.bojan.registry.service.GroupService;
import org.bojan.registry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private GroupService groupService;
	
	@ModelAttribute("allGroups")
	public List<Group> fetchGroups(){
		return groupService.findAll(); 
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request, 
	            ServletRequestDataBinder binder) throws Exception {   
	  binder.registerCustomEditor(List.class, new  
	    CustomCollectionEditor(List.class) {
	    @Override
	    protected Object convertElement(Object element) {
	      String groupId = (String) element;
	      return groupService.findById(Long.valueOf(groupId).longValue());
	    }
	  });
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String users(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("users", userService.findAll());
		
		return "users";
	}
	
	@RequestMapping(value="/users/add", method=RequestMethod.POST)
	public String addUser(@ModelAttribute User user){
		
		if (user.getId() == 0){
			userService.addUser(user);
		}else{
			userService.updateUser(user);
		}
		
		return "redirect:/users";
	}
	
	@RequestMapping(value="/users/edit/{id}")
	public String getEditUser(@PathVariable(value="id") long id, Model model){
		
		model.addAttribute("user", userService.getUserById(id));
		model.addAttribute("users", userService.findAll());
		
		return "users";
	}
	
	@RequestMapping(value="/users/remove/{id}")
	public String removeUser(@PathVariable(value="id") long id, Model model){
		
		userService.removeUser(id);
		
		model.addAttribute("user", new User());
		model.addAttribute("users", userService.findAll());
		
		return "redirect:/users";
	}
}
