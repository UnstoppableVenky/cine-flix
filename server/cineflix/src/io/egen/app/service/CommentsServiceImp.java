package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.app.entity.Comments;
import io.egen.app.exception.EntityAlreadyExistsException;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.CommentsRepository;

@Service
public class CommentsServiceImp implements CommentsService{

	@Autowired
	private CommentsRepository repository;
	
	@Override
	public List<Comments> findAll() {
		return repository.findAll();
	}

	@Override
	public Comments findOne(String cmntId) {
		Comments cnmt = repository.findOne(cmntId);
		if (cnmt == null){
			throw new EntityNotFoundException("Cinema details not found");
		}
		return cnmt;	
	}
	
	@Transactional
	@Override
	public Comments create(Comments cmnt) {
		Comments existing = repository.findByImdbId(cmnt.getImdbId());
		if (existing != null){
			throw new EntityAlreadyExistsException("Cinema details already exists with these details");
		}
		return repository.create(cmnt);
	}

	@Transactional
	@Override
	public Comments update(String cmntId, Comments cmnt) {
		Comments existing = repository.findOne(cmntId);
		if (existing == null){
			throw new EntityNotFoundException("Cinema details not found");
		}
		return repository.update(cmnt);	}

	@Transactional
	@Override
	public void remove(String cmntId) {
		Comments existing = repository.findOne(cmntId);
		if (existing == null){
			throw new EntityNotFoundException("Cinema details not found");
		}
		repository.delete(existing);	}

}
