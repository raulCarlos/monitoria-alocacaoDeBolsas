package br.com.unb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HSQLConnectionFactory {
	
	private static String driver = "org.hsqldb.jdbcDriver";
	private static String url	 = "jdbc:hsqldb:file:C://Users/User/Documents/GitHub/alocacaoAdmin/alocacaoadmin/hsqldb/monitoriaDB";
	private static String user 	 = "sa";
	private static String pwd	 = "";
	private static HSQLConnectionFactory factory;
	private static Connection connection;
	
	private HSQLConnectionFactory(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static HSQLConnectionFactory getInstance(){
		if(factory == null){
			factory = new HSQLConnectionFactory();
		}
		return factory;
	}
	
	public Connection getConnection(){
		return connection;
	}
}