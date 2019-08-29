package com.senati.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Consultaselect {

	public static void main(String[] args)  {
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
		String sql = "select idusuario,nomusuario,desusuario from usuario";
		
		Statement st;
		
		try {
			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			//System.out.println(st.toString());
			while (rs.next()) {
				
				System.out.println(rs.getInt("idusuario") + " " + rs.getString("nomusuario") + " " + rs.getString("desusuario"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
		
		
		
		
		
	}

}
