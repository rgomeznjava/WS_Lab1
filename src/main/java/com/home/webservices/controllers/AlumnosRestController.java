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

import com.home.webservices.models.mongo.Alumno;
import com.home.webservices.models.service.IAlumnosService;


@RestController
@RequestMapping("/ws/alumnos")
public class AlumnosRestController {
	
	@Autowired
	private Environment env;
	  
	
	
	/**
	 *   INYECTAR ALUMNOS SERVICE: 
	 *   
	 *   ALUMNOS_SERVICE_FAKE 
	 *   ALUMNOS_SERVICE_MONGO
	 */
	@Autowired
	@Qualifier("ALUMNOS_SERVICE_MONGO")
	private IAlumnosService alumnosService;
	 
	
	@GetMapping("/mongo")
	@ResponseStatus(HttpStatus.OK)
	public void consulta() {
		
		// mongoRepo.findAll().forEach(a -> System.out.println(a.getNombre()));
		//System.out.println("mongo ---> " + mongoRepo.findByNombre("Raul"));
		List <Alumno> a1 =  (List<Alumno>) alumnosService.findAll();
		System.out.println("mongo ---> " + a1);
	}
	
	
	@GetMapping("/listar")
	public List<Alumno> listar(){
		
//		return alumnosService.findAll().stream().map(alumno ->{
//			return alumno;
//		}).collect(Collectors.toList());
		
		return alumnosService.findAll();
	}
	
	@GetMapping("/findByNombre/{nombre}")
	public Alumno detalle(@PathVariable String nombre) {

		Optional<Alumno> alumno = alumnosService.findByNombre(nombre);
		return alumno.get();
	}
	
	
	@GetMapping("/ver/{id}")
	public Alumno detalle(@PathVariable int id) {

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
	public Alumno editar(@RequestBody Alumno alumno, @PathVariable int id) { //Long
		
		Optional<Alumno> opt = alumnosService.findById(id);
		
		Alumno alumnoDb = opt.get();
		alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido1(alumno.getApellido1());
        
        return alumnosService.save(alumnoDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable int id) {
		alumnosService.deleteById(id);
	}
	

}
