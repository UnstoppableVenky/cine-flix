package io.egen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.app.entity.Users;
import io.egen.app.service.UsersService;

@RestController
@RequestMapping(value="Users", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UsersController {

	@Autowired
	private UsersService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Users> findAll(){
		return service.findAll(); 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{usrId}")
	public Users findOne(@PathVariable("usrId") String usrId){
		return service.findOne(usrId);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users create(@RequestBody Users usr){
		return service.create(usr);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{usrId}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users update( @PathVariable("usrId") String usrId, @RequestBody Users usr){
		return service.update(usrId, usr);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{usrId}")
	public void delete(@PathVariable String usrId){
		service.remove(usrId);
	}

	

	
}
