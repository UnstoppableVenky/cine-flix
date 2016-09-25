package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Users;
import io.egen.app.exception.EntityAlreadyExistsException;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService{

	@Autowired
	private UsersRepository repository;
	
	@Override
	public List<Users> findAll() {
		return repository.findAll();
	}

	@Override
	public Users findOne(String usrId) {
		Users usr = repository.findOne(usrId);
		if (usr == null){
			throw new EntityNotFoundException("Cinema details not found");
		}
		return usr;	
		}
	
	@Transactional
	@Override
	public Users create(Users usr) {
		Users existing = repository.findByEmail(usr.getUserEmail());
		if (existing != null){
			throw new EntityAlreadyExistsException("Cinema details already exists with these details");
		}
		return repository.create(usr);	}

	@Transactional
	@Override
	public Users update(String usrId, Users usr) {
		Users existing = repository.findOne(usrId);
		if (existing == null){
			throw new EntityNotFoundException("Cinema details not found");
		}
		return repository.update(usr);	}

	@Transactional
	@Override
	public void remove(String usrId) {
		Users existing = repository.findOne(usrId);
		if (existing == null){
			throw new EntityNotFoundException("Cinema details not found");
		}
		repository.delete(existing);
	}

}
