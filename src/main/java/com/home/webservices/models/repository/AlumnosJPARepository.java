package com.home.webservices.models.repository;

import org.springframework.data.repository.CrudRepository;
import com.home.webservices.models.entity.Alumno;

public interface AlumnosJPARepository extends CrudRepository<Alumno, Long>{

}
