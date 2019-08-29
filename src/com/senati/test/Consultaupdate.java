package com.senati.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Consultaupdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Connection conexion = null;
		
		//Usuario y clave
		final String url = "jdbc:mysql://localhost:3306/";
		final String dbName = "siatmedia";
		final String driver = "com.mysql.cj.jdbc.Driver";
		final String user = "root";
		final String password = "";
		
		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url+dbName,user,password);
			
			if (!conexion.isClosed()) {
				System.out.println("Conexion satisfactoria utilizando TCP/IP...");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Excepcion : " + e.getMessage());
			
		}
		
		PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement("UPDATE USUARIO SET desusuario = ? WHERE nomusuario = ?");
			stmt.setString(1, "Usuario Profesional");
			stmt.setString(2, "jluque");
			int count = stmt.executeUpdate();
			System.out.println("Cantidad actualizaciones " + count);
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
