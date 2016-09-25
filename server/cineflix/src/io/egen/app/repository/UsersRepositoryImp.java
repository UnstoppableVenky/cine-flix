package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.Users;

@Repository
public class UsersRepositoryImp implements UsersRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Users> findAll() {
		TypedQuery<Users> query = em.createNamedQuery("Users.findAll", Users.class);
		return query.getResultList();
	}

	@Override
	public Users findOne(String usrId) {
		return em.find(Users.class, usrId);
	}

	@Override
	public Users findByEmail(String userEmail) {
		TypedQuery<Users> query = em.createNamedQuery("Users.findByEmail", Users.class);
		query.setParameter("puserEmail", userEmail);
		List<Users> users = query.getResultList();
		if( users.size() == 1){
			return users.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Users create(Users usr) {
		em.persist(usr);
		return usr;
		}
	

	@Override
	public Users update(Users usr) {
		return em.merge(usr);
	}

	@Override
	public void delete(Users existing) {
		em.remove(existing);
	}

}
