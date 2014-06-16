package edu.upeu.ventas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.upeu.ventas.dao.AlumnoDAO;
import edu.upeu.ventas.dominio.Alumno;
import edu.upeu.ventas.util.DBConexion;

public class AlumnoDAOJdbcImpl implements AlumnoDAO {

	public void insertar(Alumno p) {

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("insert into alumno(id,nombre,ape_pat,ape_mat) values(uuid(),?,?,?)");

			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApePat());
			ps.setString(3, p.getApeMat());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

	}

	public List<Alumno> listar() {
		List<Alumno> lista = new ArrayList<Alumno>();

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select * from alumno");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Alumno p = new Alumno();
				p.setId(rs.getString("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApePat(rs.getString("ape_pat"));
				p.setApeMat(rs.getString("ape_mat"));

				lista.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}
		System.out.println("Tamanio:" + lista.size());
		return lista;
	}

	public Alumno getAlumnoPorId(String id) {
		Alumno a = null;
		try {
			Connection conn = DBConexion.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("select id, nombre, ape_pat, ape_mat from alumno where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				a = new Alumno();
				a.setId(rs.getString(1));
				a.setNombre(rs.getString(2));
				a.setApePat(rs.getString(3));
				a.setApeMat(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

		return a;
	}

	public void actualizar(Alumno alumno) {
		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("update alumno set nombre = ?, ape_pat=?, ape_mat=? where id = ?");

			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getApePat());
			ps.setString(3, alumno.getApeMat());
			ps.setString(4, alumno.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}
	}
	
	public void eliminar(String id){
		
		try {
			Connection conn = DBConexion.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("delete alumno where id=?");
			
			ps.setString(1, (id));
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConexion.exit();
		}
	}

}
