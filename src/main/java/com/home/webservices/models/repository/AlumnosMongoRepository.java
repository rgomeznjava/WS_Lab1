package com.home.webservices.models.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.home.webservices.models.mongo.Alumno;

public interface AlumnosMongoRepository extends MongoRepository<Alumno, String> { 

	
	  public Alumno findByNombre(String nombre);
	
}


