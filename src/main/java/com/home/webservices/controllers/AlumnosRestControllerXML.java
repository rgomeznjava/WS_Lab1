package com.home.webservices.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.home.webservices.models.entity.ListaAlumnos;
import com.home.webservices.models.service.IAlumnosServiceJPA;


@RestController
@RequestMapping("/ws-xml/alumnos")
public class AlumnosRestControllerXML {
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	@Qualifier("ALUMNOS_SERVICE_JPA")
	private IAlumnosServiceJPA alumnosService;
	
	
	
	@GetMapping(value="/listar", produces = MediaType.APPLICATION_XML_VALUE)
	public ListaAlumnos listar(){
		
		ListaAlumnos listaAlumnos = new ListaAlumnos();  //DatosAlumnos
		listaAlumnos.setListaAlumnos(alumnosService.findAll());		
				
		return listaAlumnos;
	}
	
	
	@GetMapping(value="/findByNombre/{nombre}", produces = MediaType.APPLICATION_XML_VALUE)
	public Alumno detalle(@PathVariable String nombre) {

		Optional<Alumno> alumno = alumnosService.findByNombre(nombre);
		return alumno.get();
	}
	
	
	@GetMapping(value="/ver/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public Alumno detalle(@PathVariable long id) {

		Optional<Alumno> alumno = alumnosService.findById(id);
		return alumno.get();
	}
	
	
	@PostMapping(value="/crear", consumes  = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno crear(@RequestBody Alumno alumno) {
		return alumnosService.save(alumno);
		
	}
	
	
	@PutMapping(value="/editar/{id}", consumes  = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno editar(@RequestBody Alumno alumno, @PathVariable long id) { 
		
		Optional<Alumno> opt = alumnosService.findById(id);
		
		Alumno alumnoDb = opt.get();
		alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido1(alumno.getApellido1());
        
        return alumnosService.save(alumnoDb);
	}
	
	
	@DeleteMapping(value="/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id) {
		alumnosService.deleteById(id);
	}
	
}

