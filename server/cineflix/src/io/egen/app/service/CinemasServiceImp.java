package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Cinemas;
import io.egen.app.exception.EntityAlreadyExistsException;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.CinemasRepository;

@Service
public class CinemasServiceImp implements CinemasService{

	@Autowired
	private CinemasRepository repository;
	
	@Override
	public List<Cinemas> findAll() {
		return repository.findAll();
	}

	@Override
	public Cinemas findOne(String imdbId) {
		Cinemas cnm = repository.findOne(imdbId);
		if (cnm == null){
			throw new EntityNotFoundException("Cinema details not found");
		}
		return cnm;
	}

	@Transactional
	@Override
	public Cinemas create(Cinemas cnm) {
		Cinemas existing = repository.findByTitle(cnm.getTitle());
		if (existing != null){
			throw new EntityAlreadyExistsException("Cinema details already exists with these details");
		}
		return repository.create(cnm);
	}

	@Transactional
	@Override
	public Cinemas update(String imdbId, Cinemas cnm) {
		Cinemas existing = repository.findOne(imdbId);
		if (existing == null){
			throw new EntityNotFoundException("Cinema details not found");
		}
		return repository.update(cnm);
	}

	@Transactional
	@Override
	public void remove(String imdbId) {
		Cinemas existing = repository.findOne(imdbId);
		if (existing == null){
			throw new EntityNotFoundException("Cinema details not found");
		}
		repository.delete(existing);
		
	}

}
