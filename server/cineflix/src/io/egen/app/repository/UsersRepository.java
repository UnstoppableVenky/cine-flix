package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.Users;

public interface UsersRepository {

	public List<Users> findAll();

	public Users findOne(String usrId);

	public Users findByEmail(String userEmail);

	public Users create(Users usr);

	public Users update(Users usr);

	public void delete(Users existing);

}
