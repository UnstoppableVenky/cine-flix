package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.Users;

public interface UsersService {

	public List<Users> findAll();

	public Users findOne(String usrId);

	public Users create(Users usr);

	public Users update(String usrId, Users usr);

	public void remove(String usrId);


}
