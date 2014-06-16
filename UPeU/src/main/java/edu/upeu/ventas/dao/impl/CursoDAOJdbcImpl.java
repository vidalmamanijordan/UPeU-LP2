package edu.upeu.ventas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.CursoDAO;
import edu.upeu.ventas.dominio.Curso;
import edu.upeu.ventas.util.DBConexion;

public class CursoDAOJdbcImpl implements CursoDAO {
	
	public void insertar(Curso p) {

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("insert into curso(id,nombre,nro_horas,nro_creditos) values(uuid(),?,?,?)");

			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getNroHoras());
			ps.setInt(3, p.getNroCreditos());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

	}

	public List<Curso> listar() {
		List<Curso> lista = new ArrayList<Curso>();

		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("select * from curso");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Curso p = new Curso();
				p.setId(rs.getString("id"));
				p.setNombre(rs.getString("nombre"));
				p.setNroHoras(rs.getInt("nro_horas"));
				p.setNroCreditos(rs.getInt("nro_creditos"));

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

	public Curso getCusoPorId(String id) {
		
		Curso a = null;
		
		try {
			Connection conn = DBConexion.getConexion();
			PreparedStatement ps = conn.prepareStatement("select id, nombre, nro_horas, nro_creditos from curso where id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				a = new Curso();
				a.setId(rs.getString(1));
				a.setNombre(rs.getString(2));
				a.setNroHoras(rs.getInt(3));
				a.setNroCreditos(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConexion.exit();
		}

		return a;
	}
	
	public void actualizar(Curso curso) {
		try {
			Connection conn = DBConexion.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("update curso set nombre = ?, nro_horas=?, nro_creditos=? where id = ?");

			ps.setString(1, curso.getNombre());
			ps.setInt(2, curso.getNroHoras());
			ps.setInt(3, curso.getNroCreditos());
			ps.setString(4, curso.getId());

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
				
				PreparedStatement ps = conn.prepareStatement("delete from curso where id=?");
				
				ps.setString(1, (id));
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBConexion.exit();
			}
		}
}
