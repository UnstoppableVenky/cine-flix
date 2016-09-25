package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.app.entity.Comments;

@Repository
public class CommentsRepositoryImp implements CommentsRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Comments> findAll() {
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findAll", Comments.class);
		return query.getResultList();	}

	@Override
	public Comments findOne(String cmntId) {
		return em.find(Comments.class, cmntId);
	}

	@Override
	public Comments findByImdbId(String imdbId) {
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findByImdbId", Comments.class);
		query.setParameter("pimdbId", imdbId);
		List<Comments> comments = query.getResultList();
		if(comments.size() == 1){
			return comments.get(0);
		}
		else{
			return null;
		}	}

	@Override
	public Comments create(Comments cmnt) {
	em.persist(cmnt);
	return cmnt;
	}

	@Override
	public Comments update(Comments cmnt) {
		return em.merge(cmnt);
				}

	@Override
	public void delete(Comments existing) {
		em.remove(existing);
	}

	

}
