package edu.upeu.ventas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.DocenteDAO;
import edu.upeu.ventas.dominio.Docente;
import edu.upeu.ventas.util.DBConexion;

public class DocenteDAOJdbcImpl implements DocenteDAO {

	public List<Docente> listar() {

		List<Docente> lista = new ArrayList<Docente>();

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select * from docente");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Docente d = new Docente();
				d.setId(rs.getString("id"));
				d.setNombre(rs.getString("nombre"));
				d.setApePat(rs.getString("ape_pat"));
				d.setApeMat(rs.getString("ape_mat"));
				lista.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

		return lista;
	}

	public Docente getDocentePorId(String id) {
		Docente d = new Docente();

		try {
			Connection conn = DBConexion.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select * from docente where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				d.setId(rs.getString("id"));
				d.setNombre(rs.getString("nombre"));
				d.setApePat(rs.getString("ape_pat"));
				d.setApeMat(rs.getString("ape_mat"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

		return d;
	}

	public void insertar(Docente d) {
		try {
			Connection conn = DBConexion.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("insert into docente(id,nombre,ape_pat,ape_mat) values(uuid(),?,?,?)");
			ps.setString(1, d.getNombre());
			ps.setString(2, d.getApePat());
			ps.setString(3, d.getApeMat());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

	}

	public void actualizar(Docente d) {
		try {
			Connection conn = DBConexion.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("update docente set nombre=?,ape_pat=?,ape_mat=? where id=?");
			ps.setString(1, d.getNombre());
			ps.setString(2, d.getApePat());
			ps.setString(3, d.getApeMat());
			ps.setString(4, d.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}
	}

}
