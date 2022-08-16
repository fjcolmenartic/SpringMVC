package com.openwebinars._Controladores02;

import com.openwebinars._Controladores02.Repositorio.EmpleadoRepository;
import com.openwebinars._Controladores02.modelo.Empleado;
import com.openwebinars._Controladores02.upload.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

	@Bean
	CommandLineRunner initData(EmpleadoRepository repositorio) {
		return (args) -> {
			Empleado empleado = new Empleado("Luís Miguel López", "luismiguellopez@ow.es", "954000000");
			Empleado empleado2 = new Empleado("José García", "josegarcia@ow.es", "954000000");

			repositorio.save(empleado);
			repositorio.save(empleado2);
		};
	}

}
