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
import io.egen.app.entity.Cinemas;
import io.egen.app.service.CinemasService;


@Controller
@RestController
@RequestMapping(value="Cinemas", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CinemasController {

	@Autowired
	private CinemasService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Cinemas> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{imdbId}")
	public Cinemas findOne(@PathVariable("imdbId") String imdbId){
		return service.findOne(imdbId);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cinemas create(@RequestBody Cinemas cnm){
		return service.create(cnm);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{imdbId}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cinemas update( @PathVariable("imdbId") String imdbId, @RequestBody Cinemas cnm){
		return service.update(imdbId, cnm);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{imdbId}")
	public void delete(@PathVariable String imdbId){
		service.remove(imdbId);
	}

	

	
}
