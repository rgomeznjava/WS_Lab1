package com.home.webservices.models.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home.webservices.models.mongo.Alumno;

//@Configuration
@Repository("ALUMNOS_REPOSITORY_FAKE")
public class AlumnosFakeRepository implements CrudRepository<Alumno, String> {

	
//	@Bean("listaAlumnos")
//	public  List<Alumno> getListaAlumnos() {
//		
//		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
//		Alumno a1 = new  Alumno("0001","Rul","Gomez","Grijhander");
//		Alumno a2 = new  Alumno("0001","Jonny","Long","El Largo");
//		Alumno a3 = new  Alumno("0001","Mirian","Lozano","Morenaza");
//		listaAlumnos.add(a1);	listaAlumnos.add(a2);	listaAlumnos.add(a3);
//		return listaAlumnos; 
//	}
	
	
	
	//@Lazy
	@Autowired
	@Qualifier("listaAlumnos")
	private List<Alumno> listaAlumnos;
	
	
	
	@Override
	public <S extends Alumno> S save(S entity) {
		listaAlumnos.add(entity);
		return entity;
	}

	@Override
	public <S extends Alumno> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Alumno> findById(String id) {
		
		//List<Integer> pares = numeros.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		List<Alumno> l = listaAlumnos.stream().filter(a -> a.getNombre().equalsIgnoreCase(id)).collect(Collectors.toList());
		return Optional.of(l.get(0));
		
		//return listaAlumnos.stream().map(a -> a.getNombre().equalsIgnoreCase(id)).findFirst().isPresent())
	}
	
	
	public Optional<Alumno> findByNombre(String nombre) {
		
		//List<Integer> pares = numeros.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		List<Alumno> l = listaAlumnos.stream().filter(a -> a.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
		return Optional.of(l.get(0));
		
		//return listaAlumnos.stream().map(a -> a.getNombre().equalsIgnoreCase(id)).findFirst().isPresent())
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Alumno> findAll() {
		// TODO Auto-generated method stub
		return listaAlumnos;
	}

	@Override
	public Iterable<Alumno> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		listaAlumnos.remove(Integer.valueOf(id).intValue());
	}

	@Override
	public void delete(Alumno entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Alumno> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


}
