package com.home.webservices.models.mongo;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("Alumnos")
@XmlRootElement
public class Alumno {
	
	@Id
	private String _id;
	
	
	private long id;
	
	
	private String licencia;
	
	private String nombre;
	
	private String apellido1;
	
	private String apodo;
	
	
	
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Alumno(String licencia, String nombre, String apellido1, String apodo) {
		super();
		this.licencia = licencia;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apodo = apodo;
	}
	
	
	
	@Override
	public String toString() {
		return "Alumno [_id=" + _id + ", licencia=" + licencia + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apodo=" + apodo + "]";
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	
}
