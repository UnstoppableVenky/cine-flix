package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.Cinemas;

public interface CinemasService {

	public List<Cinemas> findAll();

	public Cinemas findOne(String imdbId);

	public Cinemas create(Cinemas cnm);

	public Cinemas update(String imdbId, Cinemas cnm);

	public void remove(String imdbId);

}
