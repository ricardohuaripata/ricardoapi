package com.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.RicardoapiApplication;
import com.project.objetos.Producto;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	// GET
	@GetMapping()
	public List<Producto> obtenerProductos() {
		return RicardoapiApplication.productos;
	}
	// GET BY ID
	@GetMapping(path = "/{id}")
	public Producto obtenerProductoPorId(@PathVariable("id") int id) {
		try {
			return RicardoapiApplication.productos.get(id);
		} catch (Exception e) {
			return new Producto();
		}
	}
	// GET BY ID
	@PostMapping()
	public boolean guardarProducto(@RequestBody Producto producto) {
		return RicardoapiApplication.productos.add(producto);
	}
	// DELETE
	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") int id) {
		try {
			RicardoapiApplication.productos.remove(id);
			return "Producto eliminado con éxito";

		} catch (Exception e) {
			return "El producto con id " + id + " no existe";
		}
	}
	// PUT
	@PutMapping(path = "/{id}")
	public String actualizarProducto(@PathVariable("id") int id, @RequestBody Producto producto) {
		try {
			RicardoapiApplication.productos.set(id, producto);
			return "Producto actualizado con éxito";

		} catch (Exception e) {
			return "El producto con id " + id + " no existe";
		}
	}
}
