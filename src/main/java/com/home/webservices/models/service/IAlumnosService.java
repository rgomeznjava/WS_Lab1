package com.home.webservices.models.service;

import java.util.List;
import java.util.Optional;

import com.home.webservices.models.mongo.Alumno;

public interface IAlumnosService {

	public List<Alumno> findAll();
	
	public Optional<Alumno> findById(int id);  //Long
	
	public Optional<Alumno> findByNombre(String nombre);  
	
	
	public Alumno save(Alumno alumno);
	
	public void deleteById(int id); //Long
}
