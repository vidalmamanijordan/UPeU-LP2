package edu.upeu.ventas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConexion {

	static Connection conn = null;

	public static Connection getConexion() throws SQLException {

		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/school", "root", "123456");
				System.out.println("Conexion exitosa");
				return conn;
			} catch (ClassNotFoundException e) {
				System.out.println("Conexion fallida");
				e.printStackTrace();
			}
		}

		return conn;
	}

	public static void exit() {
		try {
			if (conn != null) {
				conn.close();
				conn=null;
				System.out.println("Conexion cerrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			Connection c = DBConexion.getConexion();

			PreparedStatement ps = c
					.prepareStatement("select * from usuario where username = ? and password = ?");
			ps.setString(1, "admin1");
			ps.setString(2, "admin");
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Usuario : " + rs.getString("username"));
				System.out.println("Contrasenia : " + rs.getString("password"));
			} else {
				System.out.println("No se encontraron resultados");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
