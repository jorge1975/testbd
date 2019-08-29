package com.senati.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Consultainsert {

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
		
		try {
			PreparedStatement stmt;
			stmt = conexion.prepareStatement("INSERT INTO USUARIO(nomusuario,pasusuario,desusuario) VALUES (?,?,?)");
			stmt.setString(1, "wgarcia");
			stmt.setString(2, "123456");
			stmt.setString(3, "Usuario Jefatura");
			int count = stmt.executeUpdate();
			System.out.println("Registros insertados " + count);
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
