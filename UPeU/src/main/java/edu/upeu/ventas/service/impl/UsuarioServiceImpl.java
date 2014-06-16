package edu.upeu.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.UsuarioDAO;
import edu.upeu.ventas.dao.impl.UsuarioDAOJdbcImpl;
import edu.upeu.ventas.dominio.Usuario;
import edu.upeu.ventas.service.UsuarioService;
import edu.upeu.ventas.web.form.UsuarioForm;

public class UsuarioServiceImpl implements UsuarioService {

	UsuarioDAO usuarioDAO = new UsuarioDAOJdbcImpl();

	public void guardarUsuario(UsuarioForm usuario) {
		Usuario u = new Usuario();
		u.setCodigo(usuario.getCodigo());
		u.setUsername(usuario.getUsername());
		u.setPassword(usuario.getPassword());

		usuarioDAO.guardar(u);

	}

	public List<UsuarioForm> getListaUsuarios() {
		List<UsuarioForm> lista = new ArrayList<UsuarioForm>();

		return lista;
	}

	public boolean verificarAcceso(String username, String contrasenia) {
		Usuario u = usuarioDAO.getUsuarioPorUsernameYContrasenia(username, contrasenia);
		if(u!=null){
			return true;
		}
		return false;
	}

}
