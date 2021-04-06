package com.home.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.home.webservices.models.mongo.Alumno;
import com.home.webservices.models.repository.AlumnosMongoRepository;
import com.home.webservices.models.repository.AlumnosJPARepository;

@SpringBootApplication
public class LanzarAplicacion  implements CommandLineRunner {

	@Autowired
	private AlumnosMongoRepository repositoryMongo;
	
	@Autowired
	private AlumnosJPARepository repositoryJPA;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LanzarAplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//repositoryJPA.deleteAll();
		
//		repository.deleteAll();
//
//	    // save a couple of customers
//	    repository.save(new Alumno("00001", "Raul", "Gomez", "Grijano"));
//	    repository.save(new Alumno("00002", "Jose", "Montero", "Capitan"));

		
		
		

	    // fetch all customers
	    System.out.println("Customers found with findAll():");
	    System.out.println("-------------------------------");
	    for (Alumno alumno : repositoryMongo.findAll()) {
	      System.out.println(alumno);
	    }
	    System.out.println();

	    // fetch an individual customer
	    System.out.println("Customer found with findByNombre('Raul'):");
	    System.out.println("--------------------------------");
	    System.out.println(repositoryMongo.findByNombre("Raul"));

	    //System.out.println("Customers found with findByLastName('Smith'):");
	    System.out.println("--------------------------------");
	    //for (Alumno alumno : repository.findByLastName("Raul")) {7System.out.println(alumno);7}

		
	}

}
