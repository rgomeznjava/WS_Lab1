package com.home.webservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.home.webservices.models.mongo.Alumno;
import com.home.webservices.models.entity.Usuario;

@Configuration
public class DatosPruebas {
	
	@Bean("listaUsuarios")
	public  List<Usuario> getListaUsuarios() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u1 = new  Usuario("user1","123","RAUL","GOMEZ","NIETO");
		Usuario u2 = new  Usuario("user2","123","JUAN","GARCIA","POZUELO");
		Usuario u3 = new  Usuario("user3","123","MIRIAM","PEREZ","VOLKOK");
		usuarios.add(u1);	usuarios.add(u2);	usuarios.add(u3);
		return usuarios; 
	}
	
	@Bean("listaAlumnos")
	public  List<Alumno> getListaAlumnos() {
		
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		Alumno a1 = new  Alumno("0001","Rul","Gomez","Grijhander");
		Alumno a2 = new  Alumno("0002","Jonny","Long","El Largo");
		Alumno a3 = new  Alumno("0003","Mirian","Lozano","Morenaza");
		listaAlumnos.add(a1);	listaAlumnos.add(a2);	listaAlumnos.add(a3);
		return listaAlumnos; 
	}

}