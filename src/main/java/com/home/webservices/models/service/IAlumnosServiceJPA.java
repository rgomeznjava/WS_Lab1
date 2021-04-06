package com.home.webservices.models.service;

import java.util.List;
import java.util.Optional;
import com.home.webservices.models.entity.Alumno;

public interface IAlumnosServiceJPA {

	public List<Alumno> findAll();
	
	public Optional<Alumno> findById(Long id);  //Long
	
	public Optional<Alumno> findByNombre(String nombre);  
	
	
	public Alumno save(Alumno alumno);
	
	public void deleteById(Long id); //Long
}
