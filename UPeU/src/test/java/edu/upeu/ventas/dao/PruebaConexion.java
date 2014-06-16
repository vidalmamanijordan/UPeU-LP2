package edu.upeu.ventas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaConexion {

	Connection conn = null;

	public Connection getConexion() throws SQLException {

		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/ventas_upeu", "root",
						"123456");
				System.out.println("Conexion exitosa");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void exit() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		PruebaConexion pc = new PruebaConexion();

		try {
			Connection c = pc.getConexion();
			PreparedStatement ps = c.prepareStatement("select * from usuario");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("password"));
			}

			pc.exit();
		} catch (Exception e) {
		}

	}

}
