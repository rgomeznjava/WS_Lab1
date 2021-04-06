package com.home.webservices.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.home.webservices.models.mongo.Alumno;
import com.home.webservices.models.repository.AlumnosFakeRepository;


@Service("ALUMNOS_SERVICE_FAKE")
public class AlumnosServiceFakeImpl implements IAlumnosService {

	
	@Autowired
	@Qualifier("ALUMNOS_REPOSITORY_FAKE")
	private AlumnosFakeRepository repositorio;  // CrudRepository<Alumno, String> 
	
	
	
	@Override
	public List<Alumno> findAll() {
		 
		//return listaAlumnos;
		return (List<Alumno>) repositorio.findAll();
	}

	@Override
	public Optional<Alumno> findByNombre(String nombre) {
		
		return repositorio.findByNombre(nombre);
	}
	
	@Override
	public Optional<Alumno> findById(int id) {
		
		return repositorio.findById(String.valueOf(id));
	}

	@Override
	public Alumno save(Alumno alumno) {
		
		alumno = repositorio.save(alumno);
		
		return alumno;
	}

	@Override
	public void deleteById(int id) {
		repositorio.deleteById(String.valueOf(id));
	}
}
