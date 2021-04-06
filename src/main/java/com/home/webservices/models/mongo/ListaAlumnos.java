package com.home.webservices.models.mongo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaAlumnos {
	
	//mapeado con este nombre para xml
	@XmlElement(name="alumno")
	private List<Alumno> listaAlumnos = null;

// Da error parser doble ListaAlumnos
//	public List<Alumno> getListaAlumnos() {
//		return listaAlumnos;
//	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
}
