package com.home.webservices.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.webservices.models.entity.Alumno;
import com.home.webservices.models.repository.AlumnosJPARepository;


@Service("ALUMNOS_SERVICE_JPA")
public class AlumnosServiceJPAImpl implements IAlumnosServiceJPA{
	
	@Autowired
	//@Qualifier("ALUMNOS_REPOSITORY_JPA")
	private AlumnosJPARepository repositorio;  // CrudRepository<AlumnoDB, String> 
	
	
	
	@Override
	public List<Alumno> findAll() {
		 
		List<Alumno> listaAlumnoDB = (List<Alumno>) repositorio.findAll();
		return listaAlumnoDB;
	}

	@Override
	public Optional<Alumno> findByNombre(String nombre) {
		
		//return repositorio.findByNombre(nombre);
		return null;
	}
	
	@Override
	public Optional<Alumno> findById(Long id) {
		
		return repositorio.findById(id);
	}

	@Override
	public Alumno save(Alumno alumnoDB) {
		
		alumnoDB = repositorio.save(alumnoDB);
		
		return alumnoDB;
	}


	@Override
	public void deleteById(Long id) {
		repositorio.deleteById(id);
	}
}
