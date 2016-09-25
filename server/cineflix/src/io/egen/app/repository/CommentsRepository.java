package io.egen.app.repository;

import java.util.List;
import io.egen.app.entity.Comments;

public interface CommentsRepository {

	public List<Comments> findAll();

	public Comments findOne(String cmntId);

	public Comments findByImdbId(String imdbId);

	public Comments create(Comments cmnt);

	public Comments update(Comments cmnt);

	public void delete(Comments existing);

}
