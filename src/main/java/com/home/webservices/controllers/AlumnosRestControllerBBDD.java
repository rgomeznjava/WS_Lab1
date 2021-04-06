package com.home.webservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.home.webservices.models.entity.Alumno;
import com.home.webservices.models.service.IAlumnosServiceJPA;


@RestController
@RequestMapping("/ws-bd/alumnos")
public class AlumnosRestControllerBBDD {
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	@Qualifier("ALUMNOS_SERVICE_JPA")
	private IAlumnosServiceJPA alumnosService;
	
	
	
	@GetMapping("/listar")
	public List<Alumno> listar(){

		return alumnosService.findAll();
	}
	
	@GetMapping("/findByNombre/{nombre}")
	public Alumno detalle(@PathVariable String nombre) {

		Optional<Alumno> alumno = alumnosService.findByNombre(nombre);
		return alumno.get();
	}
	
	
	@GetMapping("/ver/{id}")
	public Alumno detalle(@PathVariable Long id) {

		Optional<Alumno> alumno = alumnosService.findById(id);
		return alumno.get();
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno crear(@RequestBody Alumno alumno) {
		return alumnosService.save(alumno);
		
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno editar(@RequestBody Alumno alumnoM, @PathVariable Long id) { //Long
		
		Optional<Alumno> opt = alumnosService.findById(id);
		
		Alumno alumno = opt.get();
		alumno.setNombre(alumnoM.getNombre());
        alumno.setApellido1(alumnoM.getApellido1());
        
        return alumnosService.save(alumno);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		alumnosService.deleteById(id);
	}
	

}
