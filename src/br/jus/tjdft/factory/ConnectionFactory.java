package br.jus.tjdft.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	
	public static Connection getConexao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
