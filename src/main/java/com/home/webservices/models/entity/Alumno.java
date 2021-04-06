package com.home.webservices.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name = "alumnos")
public class Alumno {
	

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "licencia")
	private String licencia;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido1")
	private String apellido1;
	
	@Column(name = "apodo")
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
		return "AlumnoDB [id=" + id + ", licencia=" + licencia + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apodo=" + apodo + "]";
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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
