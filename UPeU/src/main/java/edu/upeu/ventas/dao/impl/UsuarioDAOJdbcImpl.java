package edu.upeu.ventas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.UsuarioDAO;
import edu.upeu.ventas.dominio.Usuario;
import edu.upeu.ventas.util.DBConexion;

public class UsuarioDAOJdbcImpl implements UsuarioDAO {

	public void guardar(Usuario usuario) {
		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("insert into usuario(codigo,username,password) values(?,?,?)");

			ps.setString(1, usuario.getCodigo());
			ps.setString(2, usuario.getUsername());
			ps.setString(3, usuario.getPassword());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

	}

	public List<Usuario> listar() {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select codigo, username from usuario");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Usuario u = new Usuario();
				u.setCodigo(rs.getString(0));
				u.setUsername(rs.getString(1));

				usuarios.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}
		return usuarios;
	}

	public Usuario getUsuarioPorUsername(String username) {
		Usuario u = null;
		try {
			Connection conn = DBConexion.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select id,username from usuario where username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				u = new Usuario();
				u.setCodigo(rs.getString(0));
				u.setUsername(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

		return u;
	}

	public Usuario getUsuarioPorUsernameYContrasenia(String username,
			String contrasenia) {
		Usuario u = null;
		try {
			Connection conn = DBConexion.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select id,username from usuario where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, contrasenia);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				u = new Usuario();
				u.setCodigo(rs.getString(1));
				u.setUsername(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

		return u;
	}

}
