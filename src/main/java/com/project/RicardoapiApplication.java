package com.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.objetos.Producto;
import com.project.objetos.Usuario;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RicardoapiApplication {

	public static List<Usuario> usuarios = new ArrayList();
	public static List<Producto> productos = new ArrayList();

	public static void main(String[] args) {

		usuarios.add(new Usuario("José Manuel", "Guillamón"));
		usuarios.add(new Usuario("Inma", "Martín"));
		usuarios.add(new Usuario("Ricardo", "Huaripata"));
		usuarios.add(new Usuario("Bernat", "Costa"));

		productos.add(new Producto("Samsung S7", 789.99));
		productos.add(new Producto("POCO X3", 199.99));
		productos.add(new Producto("iPhone 14 Pro Max", 1469.00));
		productos.add(new Producto("Samsung Note 10 Plus", 1169.99));

		SpringApplication.run(RicardoapiApplication.class, args);
	}

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.project"))
				.build();
	}

}
