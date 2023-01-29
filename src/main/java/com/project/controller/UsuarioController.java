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
import com.project.objetos.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	// GET
	@GetMapping()
	public List<Usuario> obtenerUsuarios() {
		return RicardoapiApplication.usuarios;
	}
	// GET BY ID
	@GetMapping(path = "/{id}")
	public Usuario obtenerUsuarioPorId(@PathVariable("id") int id) {
		try {
			return RicardoapiApplication.usuarios.get(id);
		} catch (Exception e) {
			return new Usuario();
		}
	}
	// GET BY ID
	@PostMapping()
	public boolean guardarUsuario(@RequestBody Usuario usuario) {
		return RicardoapiApplication.usuarios.add(usuario);
	}
	// DELETE
	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") int id) {
		try {
			RicardoapiApplication.usuarios.remove(id);
			return "Usuario eliminado con éxito";

		} catch (Exception e) {
			return "El usuario con id " + id + " no existe";
		}
	}
	// PUT
	@PutMapping(path = "/{id}")
	public String actualizarUsuario(@PathVariable("id") int id, @RequestBody Usuario usuario) {
		try {
			RicardoapiApplication.usuarios.set(id, usuario);
			return "Usuario actualizado con éxito";

		} catch (Exception e) {
			return "El usuario con id " + id + " no existe";
		}
	}
}
