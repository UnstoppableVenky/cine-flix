package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.Comments;

public interface CommentsService {

	public List<Comments> findAll();

	public Comments findOne(String cmntId);

	public Comments create(Comments cmnt);

	public Comments update(String cmntId, Comments cmnt);

	public void remove(String cmntId);

}
