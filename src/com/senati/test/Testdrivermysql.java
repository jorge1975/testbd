package com.senati.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Testdrivermysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conexion1 = null;
		Connection conexion2 = null;
		Connection conexion3 = null;
		
		//Usuario y clave
		String user = "root";
		String password = "";
		
		try {
			//Una sola cadena de conexion en un solo parametro se concatena 
			//el usuario y el password
			String url1 = "jdbc:mysql://localhost:3306/siatmedia?user="+user + "&pasword=" + password;
			conexion1 = DriverManager.getConnection(url1);
			if (conexion1 != null) {
				System.out.println("Conexion 1 satisfactoria");
			}
			
			//Se envia la cadena y los datos de usuario y password por separado
			Properties datos = new Properties();
			datos.put("user",user);
			datos.put("password",password);
			String url2 = "jdbc:mysql://localhost:3306/siatmedia";
			conexion2 = DriverManager.getConnection(url2,datos);
			if (conexion2 != null) {
				System.out.println("Conexion 2 satisfactoria");
			}
			//Se envia la cadena y los datos de usuario y password por separado
			String url3 = "jdbc:mysql://localhost:3306/siatmedia";
			conexion3 = DriverManager.getConnection(url3,user,password);
			if (conexion2 != null) {
				System.out.println("Conexion 3 satisfactoria");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en la cadena, verifique el usuario y el password o el nombre de la base de datos a la que intenta conectarse ");
			e.printStackTrace();
		}
		
		
	}

}
