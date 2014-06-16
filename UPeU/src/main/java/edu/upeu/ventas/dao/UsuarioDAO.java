package edu.upeu.ventas.dao;

import java.util.List;

import edu.upeu.ventas.dominio.Usuario;

public interface UsuarioDAO {
	void guardar(Usuario usuario);

	List<Usuario> listar();

	Usuario getUsuarioPorUsername(String username);

	Usuario getUsuarioPorUsernameYContrasenia(String username,
			String contrasenia);
}
