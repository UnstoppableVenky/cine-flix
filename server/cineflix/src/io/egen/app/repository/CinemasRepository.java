package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.Cinemas;

public interface CinemasRepository {

	public List<Cinemas> findAll();

	public Cinemas findOne(String imdbId);

	public Cinemas findByTitle(String title);

	public Cinemas create(Cinemas cnm);

	public Cinemas update(Cinemas cnm);

	public  void delete(Cinemas existing);

}
