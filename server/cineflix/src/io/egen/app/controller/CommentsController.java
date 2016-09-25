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
import io.egen.app.entity.Comments;
import io.egen.app.service.CommentsService;


@Controller
@RestController
@RequestMapping(value="Comments", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentsController {

	@Autowired
	private CommentsService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Comments> findAll(){
		return service.findAll(); 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{cmntId}")
	public Comments findOne(@PathVariable("cmntId") String cmntId){
		return service.findOne(cmntId);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments create(@RequestBody Comments cmnt){
		return service.create(cmnt);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{cmntId}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments update( @PathVariable("cmntId") String cmntId, @RequestBody Comments cmnt){
		return service.update(cmntId, cmnt);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{cmntId}")
	public void delete(@PathVariable String cmntId){
		service.remove(cmntId);
	}

	

	
}
