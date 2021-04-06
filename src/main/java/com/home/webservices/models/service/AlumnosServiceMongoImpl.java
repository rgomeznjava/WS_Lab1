package com.home.webservices.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.webservices.models.mongo.Alumno;
import com.home.webservices.models.repository.AlumnosMongoRepository;


@Service("ALUMNOS_SERVICE_MONGO")
public class AlumnosServiceMongoImpl implements IAlumnosService {

	
	@Autowired
	AlumnosMongoRepository mongoRepo;
	
	
	@Override
	public List<Alumno> findAll() {
		 
		return mongoRepo.findAll();
	}

	@Override
	public Optional<Alumno> findById(int id) {
		//return productoDao.findById(id).orElse(null);
		//return alumnos.get(id);
		return mongoRepo.findById(String.valueOf(id));
	}

	@Override
	public Alumno save(Alumno alumno) {
		mongoRepo.save(alumno);
		return alumno;
	}

	@Override
	public void deleteById(int id) {
		//productoDao.deleteById(id);
	}

	@Override
	public Optional<Alumno> findByNombre(String nombre) {
		return Optional.of(mongoRepo.findByNombre(nombre));
	}

}
