package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.app.entity.Cinemas;

@Repository
public class CinemasRepositoryImp implements CinemasRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Cinemas> findAll() {
		TypedQuery<Cinemas> query = em.createNamedQuery("Cinemas.findAll", Cinemas.class);
		return query.getResultList();
	}

	@Override
	public Cinemas findOne(String imdbId) {
		return em.find(Cinemas.class, imdbId);
	}

	@Override
	public Cinemas findByTitle(String title) {
		TypedQuery<Cinemas> query = em.createNamedQuery("Cinemas.findByTitle", Cinemas.class);
		query.setParameter("ptitle", title);
		List<Cinemas> cinemas = query.getResultList();
		if(cinemas.size() == 1){
			return cinemas.get(0);
		}
		else{
			return null;
		}
	}
	
	@Override
	public Cinemas create(Cinemas cnm) {
		em.persist(cnm);	
		return cnm;
}

	@Override
	public Cinemas update(Cinemas cnm) {
		return em.merge(cnm);
	}

	@Override
	public void delete(Cinemas existing) {
		em.remove(existing);
	}

	

}
