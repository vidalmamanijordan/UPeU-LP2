package edu.upeu.ventas.service;

import java.util.List;

import edu.upeu.ventas.web.form.UsuarioForm;

public interface UsuarioService {

	void guardarUsuario(UsuarioForm usuario);

	List<UsuarioForm> getListaUsuarios();

	boolean verificarAcceso(String username, String contrasenia);
}
