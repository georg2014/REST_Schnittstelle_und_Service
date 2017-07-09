package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.User;
import de.tub.ise.anwsys.repos.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping(method=RequestMethod.GET)
	public String start() {
		return String.format("Willkommen auf der user Seite!    /all -> alle");
	}
	
	
	//shows all User
	@RequestMapping(method=RequestMethod.GET, path="/all")
	public List<User> getAllSmartMeter(){
		return (List<User>) repository.findAll(); 
	}
	//shows a single User
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public User getSingleUser(@PathVariable(name="id", required=true)Long id){
		return repository.findById(id);
	}
	
	//creates a new User
	@RequestMapping(method=RequestMethod.POST)
	public User createUser(@RequestBody User user){
		User s = new User(user.getName());
		return repository.save(s);
	}	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteUser(@PathVariable(name="id", required=true)Long id){
		User u = repository.findById(id);
		repository.delete(u);
	}

}
